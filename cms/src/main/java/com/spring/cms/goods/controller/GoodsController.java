package com.spring.cms.goods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@RequestMapping(value = "/shoppingCart", method=RequestMethod.GET)
	public String shoppingCart() {
		return "/goods/shoppingCart";
	}

}
