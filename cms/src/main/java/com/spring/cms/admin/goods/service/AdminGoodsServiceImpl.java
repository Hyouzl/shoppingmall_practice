package com.spring.cms.admin.goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cms.admin.goods.dao.AdminGoodsDao;
import com.spring.cms.goods.dto.GoodsDto;

@Service
public class AdminGoodsServiceImpl implements AdminGoodsService {

	@Autowired
	private AdminGoodsDao adminGoodsDao;
	
	@Override
	public void addNewGoods(GoodsDto goodsDto) throws Exception {
		adminGoodsDao.insertGoods(goodsDto);
	}

	@Override
	public List<GoodsDto> getGoodsList() throws Exception {
		return adminGoodsDao.selectGoodsList();
	}

}
