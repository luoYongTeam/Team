package com.ssh.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.ssh.dao.BookTypeDao;
import com.ssh.entity.BookType;

@Repository
public class BookTypeDaoImpl extends BaseDao implements BookTypeDao {

	//���ͼ������
	@Override
	public boolean addBookType(BookType type) {
		getSession().save(type);
		return true;
	}
	//��ʾ����ͼ������
	@Override
	public List showAllBookType() {
		String sql="from BookType";
		return getSession().createQuery(sql).list();
	}
	//ɾ��ͼ������
	@Override
	public boolean deleteBookType(BookType type) {
		getSession().delete(type);
		return true;
	}
	//����ID��ѯͼ������
	@Override
	public BookType getBookTypeById(int id) {
		return (BookType) getSession().get(BookType.class, id);
	}
	//�޸�ͼ������
	@Override
	public boolean updateBookType(BookType type) {
		getSession().update(type);
		return true;
	}
}
