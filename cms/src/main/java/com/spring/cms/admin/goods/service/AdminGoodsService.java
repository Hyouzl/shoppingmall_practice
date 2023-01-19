package com.spring.cms.admin.goods.service;

import java.util.List;

import com.spring.cms.goods.dto.GoodsDto;

public interface AdminGoodsService {

	public void addNewGoods(GoodsDto goodsDto) throws Exception;
	public List<GoodsDto> getGoodsList() throws Exception;
	
 }
