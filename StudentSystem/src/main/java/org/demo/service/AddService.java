package org.demo.service;

import org.demo.dao.StudentDao;
import org.demo.entity.Student;

import java.util.List;



public class AddService {

	public String service(Student stu) {
		StudentDao dao = new StudentDao();
		dao.save(stu);
		return "添加成功";
	}

}
