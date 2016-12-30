package org.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.google.gson.Gson;
import org.demo.entity.Card;
import org.demo.entity.Student;
import org.demo.entity.Subject;
import org.demo.entity.Team;
import org.demo.service.UpdateStudentService;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/updateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("sid3");
		String stuName = request.getParameter("stuName1");
		int age = Integer.parseInt(request.getParameter("age1"));
		String sex = request.getParameter("sex1");

		String card = request.getParameter("card1");
		String tid = request.getParameter("team1");
		String[] sub = request.getParameterValues("subjects");

		Team t = new Team();
		t.setTid(tid);

		
		Student stu = new Student();
		stu.setSid(sid);
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
		c.setCid(sid);
		c.setCardNum(card);
		c.setStudent(stu);
		stu.setCard(c);
		
		
		

		UpdateStudentService service=new UpdateStudentService();
		String message=service.service(stu);

		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println(message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
