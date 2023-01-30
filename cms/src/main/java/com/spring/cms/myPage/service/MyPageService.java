package com.spring.cms.myPage.service;

import java.util.List;
import java.util.Map;


import com.spring.cms.myPage.dto.CartDto;




public interface MyPageService {
	
	public void addCart(CartDto cartDto) throws Exception;
	public List<Map<String,Object>> getMyOrderList(String memberId) throws Exception;
	public List<Map<String,Object>> getMyCartList(String memberId) throws Exception;
	public boolean checkDuplicatedCart(CartDto cartDto) throws Exception;
	

}
