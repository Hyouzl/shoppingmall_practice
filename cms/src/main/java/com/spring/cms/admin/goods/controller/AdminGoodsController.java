package com.spring.cms.admin.goods.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.cms.goods.dto.GoodsDto;

@Controller
@RequestMapping("/admin/goods")
public class AdminGoodsController {
	
	@RequestMapping(value="/adminGoodsAdd" , method=RequestMethod.GET)
	public ModelAndView addNewGoods() {
		return new ModelAndView("/admin/goods/adminGoodsAdd");
	}
	
	@RequestMapping(value="/adminGoodsAdd" , method=RequestMethod.POST)
	public ResponseEntity<Object> addNewGoods(MultipartHttpServletRequest multipartRequest) throws Exception{
		
		multipartRequest.setCharacterEncoding("utf-8");
		
		GoodsDto goodsDto = new GoodsDto();
		goodsDto.setGoodsCd(multipartRequest.getParameter("goodsCd"));
		goodsDto.setGoodsNm(multipartRequest.getParameter("goodsNm"));
		goodsDto.setPrice(Integer.parseInt(multipartRequest.getParameter("price")));
		goodsDto.setDiscountRate(Integer.parseInt(multipartRequest.getParameter("discountRate")));
		goodsDto.setStock(multipartRequest.getParameter("stock"));
		goodsDto.setSort(multipartRequest.getParameter("sort"));
		goodsDto.setSize(multipartRequest.getParameter("size"));
		goodsDto.setColor(multipartRequest.getParameter("color"));		goodsDto.setColor(multipartRequest.getParameter("color"));
		goodsDto.setPoint(multipartRequest.getParameter("point"));
		goodsDto.setPart(multipartRequest.getParameter("part"));
		goodsDto.setColor(multipartRequest.getParameter(""));
		
	}
	
	
	
}
