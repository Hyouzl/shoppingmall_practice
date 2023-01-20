package com.spring.cms.admin.goods.dao;

import java.util.List;

import com.spring.cms.goods.dto.GoodsDto;

public interface AdminGoodsDao {
	
	
	public void insertGoods(GoodsDto goodsDto) throws Exception;
	public List<GoodsDto> selectListGoods() throws Exception;
	public void updateGoods(GoodsDto goodsDto) throws Exception;
	public void deleteGoods(int goodsCd) throws Exception;
}
