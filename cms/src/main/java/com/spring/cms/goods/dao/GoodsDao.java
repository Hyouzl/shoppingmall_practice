package com.spring.cms.goods.dao;

import com.spring.cms.goods.dto.GoodsDto;
public interface GoodsDao {

	public GoodsDto selectOneGoods(int goodsCd) throws Exception;

}
