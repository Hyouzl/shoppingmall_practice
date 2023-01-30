package com.spring.cms.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cms.goods.dto.GoodsDto;
import com.spring.cms.member.dto.MemberDto;
import com.spring.cms.order.dao.OrderDao;
import com.spring.cms.order.dto.OrderDto;

@Service
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public MemberDto getOrdererDetail(String memberId) throws Exception {		
		return orderDao.selectOneOrderer(memberId);
	}

	@Override
	public GoodsDto getGoodsDetail(int goodsCd) throws Exception {
		return orderDao.selectOneCartGoods(goodsCd);
	}

	@Override
	public void addOrder(OrderDto orderDto) throws Exception {
		orderDao.insertOrder(orderDto);
		
	}

}
