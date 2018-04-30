package com.tp.lottery.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tp.lottery.service.entity.JoinBuy;
import com.tp.lottery.service.entity.JoinBuyDetail;
import com.tp.lottery.service.entity.Order;
import com.tp.lottery.service.entity.OrderDetail;
import com.tp.lottery.service.entity.OrderDetailEntity;
import com.tp.lottery.service.entity.OrderEntity;
import com.tp.lottery.service.entity.Rule;
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

	@Override
	public List<Order> listOrderSelective(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.listOrderSelective(order);
	}

	@Override
	public List<OrderDetail> listOrderDetailByOrderId(Long orderId) {
		// TODO Auto-generated method stub
		return orderMapper.listOrderDetailByOrderId(orderId);
	}

	@Override
	public JoinBuy getJoinBuyByOrderId(Long orderId) {
		// TODO Auto-generated method stub
		return orderMapper.getJoinBuyByOrderId(orderId);
	}

	@Override
	public List<JoinBuyDetail> listJoinBuyDetailByJoinBuyId(Long joinBuyId) {
		// TODO Auto-generated method stub
		return orderMapper.listJoinBuyDetailByJoinBuyId(joinBuyId);
	}

	@Override
	public Rule getRuleByRuleId(Long ruleId) {
		// TODO Auto-generated method stub
		return orderMapper.getRuleByRuleId(ruleId);
	}

	@Override
	public int updateOrderWinPrize2(Order entity) {
		// TODO Auto-generated method stub
		return orderMapper.updateOrderWinPrize2(entity);
	}

	@Override
	public int updateOrderDetailWinPrize2(OrderDetail entity) {
		// TODO Auto-generated method stub
		return orderMapper.updateOrderDetailWinPrize2(entity);
	}

	@Override
	public int updateJoinBuyDetailWinPrize(JoinBuyDetail entity) {
		// TODO Auto-generated method stub
		return orderMapper.updateJoinBuyDetailWinPrize(entity);
	}

	
	

}
