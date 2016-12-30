package com.ssh.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.ssh.dao.BookTypeDao;
import com.ssh.entity.BookType;
import com.ssh.service.BookTypeService;

@Service
public class BookTypeServiceImpl implements BookTypeService{
	@Resource
	private BookTypeDao bookTypeDao ;
	//添加图书类型
	@Override
	public boolean addBookType(BookType type) {
		return bookTypeDao.addBookType(type);
	}
	//显示所有的图书类型
	@Override
	public List showAllBookType() {
		return bookTypeDao.showAllBookType();
	}
	//删除图书类型
	@Override
	public boolean deleteBookType(BookType type) {
		return bookTypeDao.deleteBookType(type);
	}
	//获取图书类型的ID
	@Override
	public BookType getBookTypeById(int id) {
		return bookTypeDao.getBookTypeById(id);
	}
	//修改图书类型
	@Override
	public boolean updateBookType(BookType type) {
		return bookTypeDao.updateBookType(type);
	}
	//依赖注入
	public void setBookTypeDao(BookTypeDao bookTypeDao) {
		this.bookTypeDao = bookTypeDao;
	}
}
