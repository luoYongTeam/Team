package org.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.google.gson.Gson;
import org.demo.dao.BaseDao;
import org.demo.dao.StudentDao;
import org.demo.entity.Student;
import org.demo.entity.Subject;

@WebServlet("/findStuById")
public class FindStuByIdServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String stuid = request.getParameter("stuid");
		System.out.println(stuid);
		StudentDao dao = new StudentDao();
		Student stu =  dao.findById(Student.class, stuid);
		stu.getTeam().setStudents(null);
		stu.getCard().setStudent(null);
		for (Subject ss:stu.getSubjects()) {
			ss.setStudents(null);
		}
		String json = new Gson().toJson(stu);
		System.out.println(json);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().println(json);
		
	}
}
