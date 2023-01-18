package com.spring.cms.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.cms.member.dto.MemberDto;

public class MemberDaoImpl implements MemberDao {
	
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public MemberDto selectLogin(MemberDto memberDto) throws Exception {
		
		return sqlSession.selectOne("member.selectLogin",memberDto);
	}

	@Override
	public void insertMember(MemberDto memberDto) throws Exception {
		
		sqlSession.insert("member.insertMember",memberDto);
		
	}

	@Override
	public String duplicatedCheckId(String memberId) throws Exception {
		return sqlSession.selectOne("member.selectDuplicatedId",memberId);
	}





	
	
}
