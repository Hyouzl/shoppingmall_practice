package com.spring.cms.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.cms.member.dao.MemberDao;
import com.spring.cms.member.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public boolean login(MemberDto memberDto) throws Exception {
		
		
		MemberDto checkExsistId = memberDao.selectLogin(memberDto);
		
		if(checkExsistId != null) {
			if(bCryptPasswordEncoder.matches(memberDto.getPasswd(), checkExsistId.getPasswd())) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public void addMember(MemberDto memberDto) throws Exception {
		
		if (memberDto.getEmailstsYn() == null)  memberDto.setEmailstsYn("N");
		if (memberDto.getSmsstsYn() == null)    memberDto.setSmsstsYn("N");
		memberDao.insertMember(memberDto);
		
	}

	@Override
	public String checkDuplicatedId(String memberId) throws Exception {
		if (memberDao.duplicatedCheckId(memberId) == null) return "duplicate";
		else return "notDuplicate";
	}
	

	
	

}
