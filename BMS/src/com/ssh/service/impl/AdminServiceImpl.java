package com.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssh.dao.AdminDao;
import com.ssh.entity.Admin;
import com.ssh.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	@Resource
	private AdminDao adminDao ;
	@Override
	public boolean addAdmin(Admin admin) {
		return adminDao.addAdmin(admin);
	}

	@Override
	public Admin login(Admin admin) {
		if(admin!=null){
			List<Admin> list=adminDao.doLogin(admin.getAname(), admin.getApwd());
			for (Admin u : list) {
				if(u.getAname().equals(admin.getAname())&& u.getApwd().equals(admin.getApwd())){
					return u;
				}
			}
		}
		return null;

	}
	
	//Spring×¢Èë
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
}
