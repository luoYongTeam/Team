package com.ssh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssh.dao.BookInfoDao;
import com.ssh.entity.BookInfo;


@Repository
public class BookInfoDaoImpl extends BaseDao implements BookInfoDao{
	
	//添加图书
	@Override
	public boolean addBook(BookInfo book) {
		getSession().save(book);
		return true;
	}
	//删除图书
	@Override
	public boolean delBook(BookInfo book) {
		getSession().delete(book);
		return true;
	}
	//显示所有的图书信息
	@Override
	public List showAllBook() {
		String sql = "from BookInfo b inner join b.type" ;
		return getSession().createQuery(sql).list();
	}
	//获取图书的ID
	@Override
	public BookInfo getBookById(int id) {
		return (BookInfo) getSession().get(BookInfo.class, id);
	}
	//修改图书信息
	@Override
	public boolean updateBook(BookInfo book) {
		getSession().update(book);
		return true;
	}

}
