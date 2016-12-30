package com.ssh.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.ssh.dao.BookTypeDao;
import com.ssh.entity.BookType;

@Repository
public class BookTypeDaoImpl extends BaseDao implements BookTypeDao {

	//添加图书类型
	@Override
	public boolean addBookType(BookType type) {
		getSession().save(type);
		return true;
	}
	//显示所有图书类型
	@Override
	public List showAllBookType() {
		String sql="from BookType";
		return getSession().createQuery(sql).list();
	}
	//删除图书类型
	@Override
	public boolean deleteBookType(BookType type) {
		getSession().delete(type);
		return true;
	}
	//根据ID查询图书类型
	@Override
	public BookType getBookTypeById(int id) {
		return (BookType) getSession().get(BookType.class, id);
	}
	//修改图书类型
	@Override
	public boolean updateBookType(BookType type) {
		getSession().update(type);
		return true;
	}
}
