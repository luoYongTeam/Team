package com.ssh.dao;

import java.util.List;

import com.ssh.entity.BookInfo;

public interface BookInfoDao {
	//添加图书
	public boolean addBook(BookInfo book);
	//删除图书
	public boolean delBook(BookInfo book);
	//查询出所有的图书
	public List showAllBook();
	//根据ID查询出图书
	public BookInfo getBookById(int id);
	//修改图书信息
	public boolean updateBook(BookInfo book);
	
}	
