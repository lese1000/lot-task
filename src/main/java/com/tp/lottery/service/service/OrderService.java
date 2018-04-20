package com.tp.lottery.service.service;

import java.util.List;

import com.tp.lottery.service.entity.OrderDetailEntity;
import com.tp.lottery.service.entity.OrderEntity;


public interface OrderService{

	void addOrder(OrderEntity entity);
	int batchAddOrder(OrderEntity entity,List<OrderDetailEntity> orderDetails);
	List<OrderDetailEntity> findOrderByLotteryNumId(Long lotteryNumId);
	int updateOrderWinPrize(OrderEntity entity);
	int updateOrderDetailWinPrize(OrderDetailEntity entity);

}
