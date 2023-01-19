package com.spring.cms.admin.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.cms.admin.member.dto.AdminDto;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView adminLogin() throws Exception {
		
		return new ModelAndView("/admin/member/login");
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<Object> login(AdminDto adminDto, HttpServletRequest request) throws Exception {
		
		
		
	}
	
	
	
}
