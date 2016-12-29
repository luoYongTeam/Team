package com.ssh.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_bookType")
public class BookType implements Serializable{

	private int tid ;
	private String tname ;
	
	
	public BookType() {
	}
	public BookType(int tid, String tname) {
		super();
		this.tid = tid;
		this.tname = tname;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
}
