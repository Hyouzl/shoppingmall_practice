package com.spring.cms.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.cms.member.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private	SqlSession sqlSession;

	@Override
	public MemberDto selectLogin(MemberDto memberDto) throws Exception {
		return sqlSession.selectOne("member.selectLogin" , memberDto);
	
	}

	
	
}
