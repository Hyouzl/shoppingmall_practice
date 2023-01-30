package com.spring.cms.order.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.cms.goods.dto.GoodsDto;
import com.spring.cms.member.dto.MemberDto;
import com.spring.cms.order.dto.OrderDto;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public MemberDto selectOneOrderer(String memberId) throws Exception {
		return sqlSession.selectOne("order.selectOneOrderer", memberId);
	}

	@Override
	public GoodsDto selectOneCartGoods(int goodsCd) throws Exception {
		return sqlSession.selectOne("order.selectOneCartGoods",goodsCd);
	}

	@Override
	public void insertOrder(OrderDto orderDto) throws Exception {
		sqlSession.insert("order.insertOrder", orderDto);
		
	}
	

}
