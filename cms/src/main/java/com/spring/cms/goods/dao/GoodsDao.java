package com.spring.cms.goods.dao;

import java.util.List;

import com.spring.cms.goods.dto.GoodsDto;
public interface GoodsDao {

	public GoodsDto selectOneGoods(int goodsCd) throws Exception;
	public List<GoodsDto> selectListGoods(GoodsDto goodsDto) throws Exception;

}
