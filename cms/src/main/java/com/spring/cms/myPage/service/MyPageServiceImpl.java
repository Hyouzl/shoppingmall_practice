package com.spring.cms.myPage.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.cms.myPage.dao.MyPageDao;
import com.spring.cms.myPage.dto.CartDto;

@Service
public class MyPageServiceImpl implements MyPageService {

	@Autowired
	private MyPageDao myPageDao;
	

	@Override
	public void addCart(CartDto cartDto) throws Exception {
		myPageDao.insertCart(cartDto);
		
	}

	@Override
	public List<Map<String, Object>> getMyOrderList(String memberId) throws Exception {
		return myPageDao.selectListMyOrder(memberId);
	}

	@Override
	public List<Map<String, Object>> getMyCartList(String memberId) throws Exception {
		return myPageDao.selectListMyCart(memberId);
	}

	@Override
	public boolean checkDuplicatedCart(CartDto cartDto) throws Exception {
		if(myPageDao.selectOneDuplicatedCart(cartDto) != null) 		return true;
		else 														return false;
	}

	
	
	

}
