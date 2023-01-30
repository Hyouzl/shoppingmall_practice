package com.spring.cms.goods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.cms.goods.dao.GoodsDao;
import com.spring.cms.goods.dto.GoodsDto;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public GoodsDto getGoodsDetail(int goodsCd) throws Exception {
		return goodsDao.selectOneGoods(goodsCd);
	}

	@Override
	public List<GoodsDto> getGoodsList(GoodsDto goodsDto) throws Exception {
		return goodsDao.selectListGoods(goodsDto);
	}
	
}
