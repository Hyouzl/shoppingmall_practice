package com.spring.cms.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.cms.goods.service.GoodsService;




@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value = "/goodsDetail" , method = RequestMethod.GET)
	public ModelAndView goodsDetail(@RequestParam("goodsCd") int goodsCd) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		
		
		
		mv.setViewName("/goods/goodsDetail");
		
		return mv;
		
	}
	
	@RequestMapping(value = "/shoppingCart", method=RequestMethod.GET)
	public String shoppingCart() {
		return "/goods/shoppingCart";
	}

}
