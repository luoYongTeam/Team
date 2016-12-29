package com.ssh.service;

import java.util.List;

import com.ssh.entity.BookInfo;

public interface BookInfoService {
	//���ͼ��
	public boolean addBook(BookInfo book);
	//ɾ��ͼ��
	public boolean delBook(BookInfo book);
	//��ѯ�����е�ͼ��
	public List showAllBook();
	//����ID��ѯ��ͼ��
	public BookInfo getBookById(int id);
	//�޸�ͼ����Ϣ
	public boolean updateBook(BookInfo book);
}
