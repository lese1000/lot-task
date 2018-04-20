package com.tp.lottery.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tp.lottery.service.entity.OrderDetailEntity;
import com.tp.lottery.service.entity.OrderEntity;
import com.tp.lottery.service.mapper.OrderMapper;
import com.tp.lottery.service.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {


	@Autowired
	private OrderMapper orderMapper;

	@Override
	public void addOrder(OrderEntity entity) {
		 orderMapper.addOrder(entity);
	}
	
	@Transactional
	@Override
	public int batchAddOrder(OrderEntity entity, List<OrderDetailEntity> orderDetails) {
		int i=0;
		try {
			addOrder(entity);
			for(OrderDetailEntity detail:orderDetails){
				detail.setOrderId(entity.getId());
			}
			i= orderMapper.batchAddOrderDetail(orderDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<OrderDetailEntity> findOrderByLotteryNumId(Long lotteryNumId) {
		return orderMapper.findOrderByLotteryNumId(lotteryNumId);
	}

	@Override
	public int updateOrderWinPrize(OrderEntity entity) {
		return orderMapper.updateOrderWinPrize(entity);
	}

	@Override
	public int updateOrderDetailWinPrize(OrderDetailEntity entity) {
		return orderMapper.updateOrderDetailWinPrize(entity);
	}

	
	

}
