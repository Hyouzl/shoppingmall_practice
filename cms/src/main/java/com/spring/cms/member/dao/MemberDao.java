package com.spring.cms.member.dao;

import com.spring.cms.member.dto.MemberDto;

public interface MemberDao {
	
	public MemberDto selectLogin(MemberDto memberDto) throws Exception;
	

}
