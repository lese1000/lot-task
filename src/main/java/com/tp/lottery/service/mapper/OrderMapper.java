package com.tp.lottery.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tp.lottery.service.entity.JoinBuy;
import com.tp.lottery.service.entity.JoinBuyDetail;
import com.tp.lottery.service.entity.Order;
import com.tp.lottery.service.entity.OrderDetail;
import com.tp.lottery.service.entity.OrderDetailEntity;
import com.tp.lottery.service.entity.OrderEntity;
import com.tp.lottery.service.entity.Rule;

public interface OrderMapper {
	void addOrder(OrderEntity entity);
	int updateOrderWinPrize(OrderEntity entity);
	int updateOrderDetailWinPrize(OrderDetailEntity entity);
	int batchAddOrderDetail(@Param("orderDetails")List<OrderDetailEntity> orderDetails);
	List<OrderDetailEntity> findOrderByLotteryNumId(@Param("lotteryNumId")Long lotteryNumId);
	
	List<Order> listOrderSelective(Order order);
	List<OrderDetail> listOrderDetailByOrderId(Long orderId);
	JoinBuy getJoinBuyByOrderId(Long orderId);
	List<JoinBuyDetail> listJoinBuyDetailByJoinBuyId(Long joinBuyId);
	
	Rule getRuleByRuleId(Long ruleId);
	
	int updateOrderWinPrize2(Order entity);
	int updateOrderDetailWinPrize2(OrderDetail entity);
	int updateJoinBuyDetailWinPrize(JoinBuyDetail entity);

}
