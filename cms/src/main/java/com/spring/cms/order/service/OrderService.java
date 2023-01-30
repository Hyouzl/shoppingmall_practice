package com.spring.cms.order.service;

import com.spring.cms.goods.dto.GoodsDto;
import com.spring.cms.member.dto.MemberDto;
import com.spring.cms.order.dto.OrderDto;

public interface OrderService {
	
	
	public void addOrder(OrderDto orderDto) throws Exception;
	public MemberDto getOrdererDetail(String memberId) throws Exception;
	public GoodsDto getGoodsDetail(int goodsCd) throws Exception;

}
