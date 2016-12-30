package com.ssh.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_admin")
public class Admin implements Serializable{
	
	private int aid ;
	private String aname;
	private String apwd ;
	
	
	public Admin() {
	}
	
	public Admin(int aid, String aname, String apwd) {
		this.aid = aid;
		this.aname = aname;
		this.apwd = apwd;
	}
	@Id
	@GeneratedValue()
	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getApwd() {
		return apwd;
	}

	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	
	
	
}
