package com.ssh.dao;

import java.util.List;

import com.ssh.entity.Admin;

public interface AdminDao {
	//��ӹ���Ա
	public boolean addAdmin(Admin admin);
	//��ѯ����Ա
	public List<Admin> doLogin(String name,String pwd);
}
