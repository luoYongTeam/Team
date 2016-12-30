package org.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.google.gson.Gson;
import org.demo.dao.StudentDao;
import org.demo.entity.Student;
import org.demo.entity.Subject;
import org.demo.utils.PageBean;

@WebServlet("/findStuList")
public class FindStuListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建PageBean对象,存放PageNum
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		System.out.println(pageNum);
		PageBean pageBean = new PageBean();
		pageBean.setPageNum(pageNum);
		StudentDao dao = new StudentDao();
		Long n = dao.count();
		int row=Integer.parseInt(String.valueOf(n));
		pageBean.setRowCount(row);
		List<Student> list =dao.findList(pageBean);
		pageBean.setList(list);
		for(Student s : list){
			s.getTeam().setStudents(null);
			s.getCard().setStudent(null);
			for (Subject ss:s.getSubjects()) {
				ss.setStudents(null);
			}
		}
	    String json = new Gson().toJson(pageBean);
		System.out.println(json);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().print(json);

	

	}
}
