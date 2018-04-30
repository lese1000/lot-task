package com.tp.lottery.task;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tp.lottery.service.entity.LotteryNumEntity;
import com.tp.lottery.service.service.LotteryNumService;
import com.tp.lottery.util.DateUtil;
import com.tp.lottery.util.WinNumber;

@Component
public class GeneratingLotteryNumTask {
	private Logger logger = LoggerFactory.getLogger(GeneratingLotteryNumTask.class);
	@Autowired
	private LotteryNumService lotteryNumService;
	
	@Scheduled(cron="0 0 0 * * ?")     
//	@Scheduled(fixedDelay = 100*60*1000)    
    public void GeneratingLotteryNum() {
		logger.info(">>生成期号定时任务启动<<");
		List<LotteryNumEntity> lotteryNums=new ArrayList<>();
		Date nowDate=new Date();
		Date beginDate;
		try {
			beginDate = DateUtil.fomatDate(DateUtil.getDay()+" 00:00:00","yyyy-MM-dd HH:mm:ss");
			beginDate=DateUtil.addReduceDay(beginDate, 1);//生成第二天的期号
		} catch (ParseException e) {
			beginDate=new Date();
			e.printStackTrace();
		}
		Date mtDate=DateUtil.addReduceDay(beginDate, 1);
		String lotteryNumPre=DateUtil.getDays();
		int i=1;
		do {
			LotteryNumEntity lotteryNum=new LotteryNumEntity();
			lotteryNum.setLotteryNum(lotteryNumPre + leftPadding(i));
			lotteryNum.setLotteryTypeId(1l);
			lotteryNum.setBeginTime(beginDate);
			lotteryNum.setCreateDate(nowDate);
			lotteryNum.setCreateUser("system");
			lotteryNum.setWinNum(WinNumber.getWinNumber());
			lotteryNums.add(lotteryNum);
			beginDate=DateUtil.addMinute(beginDate, 10);
			lotteryNum.setEndTime(beginDate);
			lotteryNum.setOpenTime(beginDate);
			i++;
		} while (beginDate.before(mtDate));
		lotteryNumService.batchInsert(lotteryNums);
		logger.info(">>生成期号定时任务结束<<");
    }
	
	//第一次或者重启时执行，判断当前是否有期号生成，没有则进行生成
	@Scheduled(fixedDelay = 1000*60*60*24*365)
	public void generateLotteryNumWhenServerReStart() {
		logger.info(">>服务（重启）启动，判断是否生成期号任务启动<<");
		Long nums = lotteryNumService.countTodayLotteryNum();
		if(null == nums || nums == 0) {
			List<LotteryNumEntity> lotteryNums=new ArrayList<>();
			Date nowDate=new Date();
			Date beginDate;
			try {
				beginDate = DateUtil.fomatDate(DateUtil.getDay()+" 00:00:00","yyyy-MM-dd HH:mm:ss");//生成当日的期号
//				beginDate=DateUtil.addReduceDay(beginDate, 1);
			} catch (ParseException e) {
				beginDate=new Date();
				e.printStackTrace();
			}
			Date mtDate=DateUtil.addReduceDay(beginDate, 1);
			String lotteryNumPre=DateUtil.getDays();
			int i=1;
			do {
				LotteryNumEntity lotteryNum=new LotteryNumEntity();
				lotteryNum.setLotteryNum(lotteryNumPre + leftPadding(i));
				lotteryNum.setLotteryTypeId(1l);
				lotteryNum.setBeginTime(beginDate);
				lotteryNum.setCreateDate(nowDate);
				lotteryNum.setCreateUser("system");
				lotteryNum.setWinNum(WinNumber.getWinNumber());
				lotteryNums.add(lotteryNum);
				beginDate=DateUtil.addMinute(beginDate, 10);
				lotteryNum.setEndTime(beginDate);
				lotteryNum.setOpenTime(beginDate);
				i++;
			} while (beginDate.before(mtDate));
			lotteryNumService.batchInsert(lotteryNums);
			logger.info(">>判断是否生成期号任务结束，期号生成完毕<<");
		}else {
			logger.info(">>判断是否生成期号任务结束，不需要生成期号<<");
		}
	}
	
	
	private String leftPadding(int i){
		String str=i+"";
		if(i < 10){
			str = "00" + i;
		}else if( i < 100){
			str = "0" + i;
		}
		return str;
		
	}
}
