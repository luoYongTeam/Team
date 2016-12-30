package com.ssh.dao;

import java.util.List;

import com.ssh.entity.Admin;

public interface AdminDao {
	//添加管理员
	public boolean addAdmin(Admin admin);
	//查询管理员
	public List<Admin> doLogin(String name,String pwd);
}
