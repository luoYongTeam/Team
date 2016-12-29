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
	//���ͼ��
	@Override
	public boolean addBook(BookInfo book) {
		return bookInfoDao.addBook(book);
	}
	//ɾ��ͼ��
	@Override
	public boolean delBook(BookInfo book) {
		return bookInfoDao.delBook(book);
	}
	//��ʾ���е�ͼ��
	@Override
	public List showAllBook() {
		return bookInfoDao.showAllBook();
	}
	//��ȡͼ���ID
	@Override
	public BookInfo getBookById(int id) {
		return bookInfoDao.getBookById(id);
	}
	//�޸�ͼ����Ϣ
	@Override
	public boolean updateBook(BookInfo book) {
		return bookInfoDao.updateBook(book);
	}
	
	//ע��
	public void setBookInfoDao(BookInfoDao bookInfoDao) {
		this.bookInfoDao = bookInfoDao;
	}
}
