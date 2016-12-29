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
	//���ͼ������
	@Override
	public boolean addBookType(BookType type) {
		return bookTypeDao.addBookType(type);
	}
	//��ʾ���е�ͼ������
	@Override
	public List showAllBookType() {
		return bookTypeDao.showAllBookType();
	}
	//ɾ��ͼ������
	@Override
	public boolean deleteBookType(BookType type) {
		return bookTypeDao.deleteBookType(type);
	}
	//��ȡͼ�����͵�ID
	@Override
	public BookType getBookTypeById(int id) {
		return bookTypeDao.getBookTypeById(id);
	}
	//�޸�ͼ������
	@Override
	public boolean updateBookType(BookType type) {
		return bookTypeDao.updateBookType(type);
	}
	//����ע��
	public void setBookTypeDao(BookTypeDao bookTypeDao) {
		this.bookTypeDao = bookTypeDao;
	}
}
