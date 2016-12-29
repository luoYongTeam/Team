package com.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssh.dao.BookInfoDao;
import com.ssh.entity.BookInfo;
import com.ssh.service.BookInfoService;
@Service
public class BookInfoServiceImpl implements BookInfoService {
	@Resource
	private BookInfoDao bookInfoDao;
	//添加图书
	@Override
	public boolean addBook(BookInfo book) {
		return bookInfoDao.addBook(book);
	}
	//删除图书
	@Override
	public boolean delBook(BookInfo book) {
		return bookInfoDao.delBook(book);
	}
	//显示所有的图书
	@Override
	public List showAllBook() {
		return bookInfoDao.showAllBook();
	}
	//获取图书的ID
	@Override
	public BookInfo getBookById(int id) {
		return bookInfoDao.getBookById(id);
	}
	//修改图书信息
	@Override
	public boolean updateBook(BookInfo book) {
		return bookInfoDao.updateBook(book);
	}
	
	//注入
	public void setBookInfoDao(BookInfoDao bookInfoDao) {
		this.bookInfoDao = bookInfoDao;
	}
}
