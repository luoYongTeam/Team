package com.ssh.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssh.dao.BookInfoDao;
import com.ssh.entity.BookInfo;


@Repository
public class BookInfoDaoImpl extends BaseDao implements BookInfoDao{
	
	//���ͼ��
	@Override
	public boolean addBook(BookInfo book) {
		getSession().save(book);
		return true;
	}
	//ɾ��ͼ��
	@Override
	public boolean delBook(BookInfo book) {
		getSession().delete(book);
		return true;
	}
	//��ʾ���е�ͼ����Ϣ
	@Override
	public List showAllBook() {
		String sql = "from BookInfo b inner join b.type" ;
		return getSession().createQuery(sql).list();
	}
	//��ȡͼ���ID
	@Override
	public BookInfo getBookById(int id) {
		return (BookInfo) getSession().get(BookInfo.class, id);
	}
	//�޸�ͼ����Ϣ
	@Override
	public boolean updateBook(BookInfo book) {
		getSession().update(book);
		return true;
	}

}
