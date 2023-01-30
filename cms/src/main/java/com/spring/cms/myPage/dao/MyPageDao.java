package com.spring.cms.myPage.dao;

import java.util.List;
import java.util.Map;

import com.spring.cms.myPage.dto.CartDto;

public interface MyPageDao {
	
	public void insertCart(CartDto cartDto) throws Exception;
	public List<Map<String,Object>> selectListMyOrder(String memberId) throws Exception;
	public Map<String,Object> selectOneMyOrder(String memberId) throws Exception;
	public List<Map<String,Object>> selectListMyCart(String memberId) throws Exception;
	public CartDto selectOneDuplicatedCart(CartDto cartDto) throws Exception ;
	
	
}
