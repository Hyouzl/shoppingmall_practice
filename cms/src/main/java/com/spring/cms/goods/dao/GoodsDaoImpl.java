package com.spring.cms.goods.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.cms.goods.dto.GoodsDto;


@Repository
public class GoodsDaoImpl implements GoodsDao {

	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public GoodsDto selectOneGoods(int goodsCd) throws Exception {
		return sqlSession.selectOne("goods.selectOneGoods", goodsCd);
	}

	@Override
	public List<GoodsDto> selectListGoods(GoodsDto goodsDto) throws Exception {
		return sqlSession.selectList("goods.selectListGoods",goodsDto);
	}

}
