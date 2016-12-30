package org.demo.service;

import org.demo.dao.StudentDao;
import org.demo.entity.Student;

import java.util.List;


public class UpdateStudentService {

	public String service(Student student) {
		StudentDao dao=new StudentDao();
		dao.update(student);
		return "修改成功";
		
	}

}
