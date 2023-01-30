package com.spring.cms.myPage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.cms.member.service.MemberService;
import com.spring.cms.myPage.dto.CartDto;
import com.spring.cms.myPage.service.MyPageService;


@Controller
@RequestMapping("/myPage")
public class MyPageController {
	@Autowired
	private MyPageService myPageService;
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/addCart", method=RequestMethod.GET)
	public String addCart(@RequestParam("goodsCd") int goodsCd , @RequestParam ("cartGoodsQty") int cartGoodsQty , HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("memberId");
	
		
		CartDto cartDto = new CartDto();
		cartDto.setMemberId(memberId);
		cartDto.setGoodsCd(goodsCd);
		cartDto.setCartGoodsQty(cartGoodsQty);
		
		String result = "duple";
		if (!myPageService.checkDuplicatedCart(cartDto)) {
			myPageService.addCart(cartDto);
			session.setAttribute("myCartCnt" , memberService.getMyCartCnt((memberId)));
			result = "notDuple";
		} 

		
		
		return result;
		
	}
	
	@RequestMapping(value="/myOrderList" , method=RequestMethod.GET)
	public ModelAndView myOrderList(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/myPage/myOrderList");
		mv.addObject("myOrderList", myPageService.getMyOrderList((String)session.getAttribute("memberId")));
		
		return mv;
		
	}
	@RequestMapping(value="/myCartList" , method=RequestMethod.GET)
	public ModelAndView myCartList(HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/myPage/myCartList");
		mv.addObject("myCartList", myPageService.getMyCartList((String)session.getAttribute("memberId")));
		
		return mv;
		
	}

}
