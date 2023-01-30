package com.spring.cms.order.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.cms.member.service.MemberService;
import com.spring.cms.order.dto.OrderDto;
import com.spring.cms.order.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping(value="/orderGoods" , method=RequestMethod.GET)
	public ModelAndView orderGoods(@RequestParam("goodsCd") int goodsCd, @RequestParam("orderGoodsQty") int orderGoodsQty , HttpServletRequest request) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("/order/orderGoods");
		
		HttpSession session = request.getSession();
		
		mv.addObject("orderer" , orderService.getOrdererDetail((String)session.getAttribute("memberId")));
		mv.addObject("goodsDto", orderService.getGoodsDetail(goodsCd));
		mv.addObject("orderGoodsQty", orderGoodsQty);
		
		return mv;
	}
	
	@RequestMapping(value="/orderGoods" , method=RequestMethod.POST)
	public ResponseEntity<Object> orderGoods (OrderDto orderDto, HttpServletRequest request) throws Exception {
	
		orderService.addOrder(orderDto);
		
		HttpSession session = request.getSession();
		session.setAttribute("myOrderCnt", memberService.getMyOrderCnt((String)session.getAttribute("memberId")));
		
		String jsScript= "<script>";
				jsScript += "alert('상품을 주문하였습니다.');";
				jsScript += "location.href='" + request.getContextPath() + "/goods/goodsDetail?goodsCd=" + orderDto.getGoodsCd() +"';";
				jsScript += "</script>";
		
				HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
			
		return new ResponseEntity<Object>(jsScript, responseHeaders, HttpStatus.OK);
			
	}
	
	

	
	
	
}
