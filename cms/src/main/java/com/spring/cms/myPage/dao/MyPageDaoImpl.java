package com.spring.cms.myPage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.cms.myPage.dto.CartDto;

@Repository
public class MyPageDaoImpl implements MyPageDao {

	@Autowired
	private SqlSession sqlSession;
	


	@Override
	public void insertCart(CartDto cartDto) throws Exception {
		sqlSession.insert("myPage.insertCart", cartDto);
	}
	
	@Override
	public List<Map<String, Object>> selectListMyOrder(String memberId) throws Exception {
		List<Map<String, Object>> aaa = sqlSession.selectList("myPage.selectMyOrderList", memberId);
		for (Map<String, Object> map : aaa) {
			System.out.println(map);
		}
		
		return aaa;
	}

	@Override
	public Map<String, Object> selectOneMyOrder(String memberId) throws Exception {
		return sqlSession.selectOne("myPage.selectOneMyOrder" , memberId);
	}

	@Override
	public List<Map<String, Object>> selectListMyCart(String memberId) throws Exception {
		List<Map<String,Object>> bbb = sqlSession.selectList("myPage.selectListMyCart", memberId);
		for (Map<String, Object> map : bbb) {
			System.out.println(map);
		}
		
		
		return bbb;
	}

	@Override
	public CartDto selectOneDuplicatedCart(CartDto cartDto) throws Exception {
		return sqlSession.selectOne("myPage.selectOneDuplicatedCart", cartDto);
	}
	
	

}
