package com.spring.cms.order.dao;

import com.spring.cms.goods.dto.GoodsDto;
import com.spring.cms.member.dto.MemberDto;
import com.spring.cms.order.dto.OrderDto;

public interface OrderDao {
	
	public MemberDto selectOneOrderer(String memberId) throws Exception;
	public GoodsDto selectOneCartGoods(int goodsCd) throws Exception;
	public void insertOrder(OrderDto orderDto) throws Exception;
	

}
