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
		List<LotteryNumEntity> lotteryNums=new ArrayList<>();
		Date nowDate=new Date();
		Date beginDate;
		try {
			beginDate = DateUtil.fomatDate(DateUtil.getDay()+" 00:00:00","yyyy-MM-dd HH:mm:ss");
			beginDate=DateUtil.addReduceDay(beginDate, 1);
		} catch (ParseException e) {
			beginDate=new Date();
			e.printStackTrace();
		}
		Date mtDate=DateUtil.addReduceDay(beginDate, 1);
		String lotteryNumPre=DateUtil.getDays();
		int i=1;
		do {
			LotteryNumEntity lotteruNum=new LotteryNumEntity();
			lotteruNum.setLotteryNum(lotteryNumPre+leftPad(i));
			lotteruNum.setLotteryTypeId(1l);
			lotteruNum.setOpenTime(beginDate);
			lotteruNum.setCreateDate(nowDate);
			lotteruNum.setCreateUser("system");
			lotteruNum.setWinNum(WinNumber.getWinNumber());
			lotteryNums.add(lotteruNum);
			beginDate=DateUtil.addMinute(beginDate, 10);
			i++;
		} while (beginDate.before(mtDate));
		lotteryNumService.batchInsert(lotteryNums);
    }
	
	private String leftPad(int i){
		String str=i+"";
		if(i<10){
			str="00"+i;
		}else if(i<100){
			str="0"+i;
		}
		return str;
		
	}
}
