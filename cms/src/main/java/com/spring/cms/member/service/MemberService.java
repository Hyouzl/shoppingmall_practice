package com.spring.cms.member.service;

import com.spring.cms.member.dto.MemberDto;

public interface MemberService {
	

	public boolean login(MemberDto memberDto) throws Exception;
	public void addMember(MemberDto memberDto) throws Exception;
	public String checkDuplicatedId(String memberId) throws Exception;
}
