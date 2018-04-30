package com.tp.lottery.service.service;

import java.util.List;

import com.tp.lottery.service.entity.JoinBuy;
import com.tp.lottery.service.entity.JoinBuyDetail;
import com.tp.lottery.service.entity.Order;
import com.tp.lottery.service.entity.OrderDetail;
import com.tp.lottery.service.entity.OrderDetailEntity;
import com.tp.lottery.service.entity.OrderEntity;
import com.tp.lottery.service.entity.Rule;


public interface OrderService{

	void addOrder(OrderEntity entity);
	int batchAddOrder(OrderEntity entity,List<OrderDetailEntity> orderDetails);
	List<OrderDetailEntity> findOrderByLotteryNumId(Long lotteryNumId);
	int updateOrderWinPrize(OrderEntity entity);
	int updateOrderDetailWinPrize(OrderDetailEntity entity);
	
	
	List<Order> listOrderSelective(Order order);
	List<OrderDetail> listOrderDetailByOrderId(Long orderId);
	JoinBuy getJoinBuyByOrderId(Long orderId);
	List<JoinBuyDetail> listJoinBuyDetailByJoinBuyId(Long joinBuyId);
	
	Rule getRuleByRuleId(Long ruleId);
	
	int updateOrderWinPrize2(Order entity);
	int updateOrderDetailWinPrize2(OrderDetail entity);
	int updateJoinBuyDetailWinPrize(JoinBuyDetail entity);

}
