package com.ssh.service;

import com.ssh.entity.Admin;

public interface AdminService {
	//添加管理员
	public boolean addAdmin(Admin admin);
	//查询管理员
	public Admin login(Admin admin);
}
