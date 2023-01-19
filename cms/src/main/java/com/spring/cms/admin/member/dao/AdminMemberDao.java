package com.spring.cms.admin.member.dao;

import com.spring.cms.admin.member.dto.AdminDto;

public interface AdminMemberDao {
	
	public AdminDto selectAdminLogin(AdminDto adminDto) throws Exception;

}
