package com.ssh.service;

import java.util.List;

import com.ssh.entity.BookType;


public interface BookTypeService {
	//���ͼ������
	public boolean addBookType(BookType type);
	//��ʾ����ͼ������
	public List showAllBookType() ;
	//ɾ��ͼ������
	public boolean deleteBookType(BookType type);
	//����ID��ѯͼ������
	public BookType getBookTypeById(int id);
	//�޸�ͼ������
	public boolean updateBookType(BookType type);
}
