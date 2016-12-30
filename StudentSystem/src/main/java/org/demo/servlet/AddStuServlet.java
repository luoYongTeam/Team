package org.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.demo.dao.BaseDao;
import org.demo.entity.Card;
import org.demo.entity.Student;
import org.demo.entity.Subject;
import org.demo.entity.Team;
import org.demo.service.AddService;
import org.demo.utils.UUIDUtil;


@WebServlet("/addStudentServlet")
public class AddStuServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stuName = request.getParameter("stuName");
		int age = Integer.parseInt(request.getParameter("age"));
		String sex = request.getParameter("sex");
		String card = request.getParameter("card");
		String tid = request.getParameter("team");
		String[] sub = request.getParameterValues("subjects");

		System.out.println(stuName);
		System.out.println(age);
		System.out.println(card);
		System.out.println(tid);
		for (String string : sub) {
			System.out.println(string);
		}
		
		BaseDao dao = new BaseDao();
		
		Team t = new Team();
		t.setTid(tid);
	
		
		Student stu = new Student();
		stu.setSid(UUIDUtil.getUUID());
		stu.setStuName(stuName);
		stu.setAge(age);
		stu.setSex(sex);
		stu.setTeam(t);

		for(int i=0;i<sub.length;i++){
			Subject s = new Subject();
			s.setSubid(sub[i]);
		
			stu.getSubjects().add(s);
			
		}
		
		

		Card c = new Card();
		c.setCid(UUIDUtil.getUUID());
		c.setCardNum(card);
		c.setStudent(stu);
		stu.setCard(c);
		
		
		AddService service=new AddService();
		String message=service.service(stu);

		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(message);
	}
		}


