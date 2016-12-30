package com.ssh.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.ssh.dao.AdminDao;
import com.ssh.entity.Admin;

@Repository
public class AdminDaoImpl extends BaseDao implements AdminDao{
	//添加管理员
	@Override
	public boolean addAdmin(Admin admin) {
		getSession().save(admin);
		return true;
	}
	//查询登录管理员账号
	@SuppressWarnings("unchecked")
	@Override
	public List<Admin> doLogin(String name,String pwd) {
		return getSession().createQuery("FROM Admin a WHERE a.aname='"+name+"' AND a.apwd = '"+pwd+"'").list();
	}

}
