package com.ssh.service;

import com.ssh.entity.Admin;

public interface AdminService {
	//��ӹ���Ա
	public boolean addAdmin(Admin admin);
	//��ѯ����Ա
	public Admin login(Admin admin);
}
