package com.spring.cms.goods.service;

import java.util.List;

import com.spring.cms.goods.dto.GoodsDto;

public interface GoodsService {
	
	public GoodsDto getGoodsDetail(int goodsCd) throws Exception;
	public List<GoodsDto> getGoodsList(GoodsDto goodsDto) throws Exception;
	
 
}
