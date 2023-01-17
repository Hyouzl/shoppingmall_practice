package com.spring.cms.member.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.cms.member.dto.MemberDto;
import com.spring.cms.member.service.MemberService;

@Controller
@RequestMapping("/customer/member")
public class MemberController {
	
	
	
	private MemberService memberService;
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("/");
	}
 	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("/customer/member/login");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Object> login(MemberDto memberDto, HttpServletRequest request) throws Exception {
		
		String message = "";
		
		if(memberService.login(memberDto)) {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("memberId", memberDto.getMemberId());
			
			
			message = "<script>";
			message += " alert('로그인 되었습니다.');";
			message += " location.href='" + request.getContextPath() + "/index';";
			message += "</script>";
			
		}
		else {
			
			message = "<script>";
			message += " alert('로그인에 실패하였습니다. 아이디와 비밀번호를 입력하세요. ');";
			message += " history.go(-1);";
			message += "</script>";
		}
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		return new ResponseEntity<Object>(message, responseHeaders, HttpStatus.OK);
		
	}
	

}
