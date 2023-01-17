package com.spring.cms.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.cms.member.dao.MemberDao;
import com.spring.cms.member.dto.MemberDto;

public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public boolean login(MemberDto memberDto) throws Exception {
		
		MemberDto checkExsistId = memberDao.selectLogin(memberDto);
		
		if(checkExsistId != null) {
			if(bCryptPasswordEncoder.matches(memberDto.getPassWd(), checkExsistId.getPassWd())) {
				return true;
			}
		}
		
		return false;
	}

}
