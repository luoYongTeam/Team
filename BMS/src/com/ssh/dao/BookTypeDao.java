package com.ssh.dao;

import java.util.List;

import com.ssh.entity.BookType;

public interface BookTypeDao {
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
