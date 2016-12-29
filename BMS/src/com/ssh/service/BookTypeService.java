package com.ssh.service;

import java.util.List;

import com.ssh.entity.BookType;


public interface BookTypeService {
	//添加图书类型
	public boolean addBookType(BookType type);
	//显示所有图书类型
	public List showAllBookType() ;
	//删除图书类型
	public boolean deleteBookType(BookType type);
	//根据ID查询图书类型
	public BookType getBookTypeById(int id);
	//修改图书类型
	public boolean updateBookType(BookType type);
}
