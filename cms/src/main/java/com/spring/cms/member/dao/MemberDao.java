package com.spring.cms.member.dao;

import com.spring.cms.member.dto.MemberDto;

public interface MemberDao {
	
	
	public MemberDto selectLogin(MemberDto memberDto) throws Exception;
	public void insertMember(MemberDto memberDto) throws Exception;
	public String duplicatedCheckId(String memberId) throws Exception;
	public int selectMyCartCnt(String memberId) throws Exception;
	public int selectMyOrderCnt(String memberId) throws Exception;

	
}
