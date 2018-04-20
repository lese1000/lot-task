package com.tp.lottery.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tp.lottery.service.entity.OrderDetailEntity;
import com.tp.lottery.service.entity.OrderEntity;

public interface OrderMapper {
	void addOrder(OrderEntity entity);
	int updateOrderWinPrize(OrderEntity entity);
	int updateOrderDetailWinPrize(OrderDetailEntity entity);
	int batchAddOrderDetail(@Param("orderDetails")List<OrderDetailEntity> orderDetails);
	List<OrderDetailEntity> findOrderByLotteryNumId(@Param("lotteryNumId")Long lotteryNumId);
}
