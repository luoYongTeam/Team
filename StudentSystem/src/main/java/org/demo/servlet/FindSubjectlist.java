package org.demo.servlet;


import com.google.gson.Gson;
import org.demo.dao.StudentDao;
import org.demo.dao.SubjectDao;
import org.demo.entity.Student;
import org.demo.entity.Subject;
import org.demo.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */
@WebServlet("/findSubjectlist")
public class FindSubjectlist extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建PageBean对象,存放PageNum
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));

        PageBean pageBean = new PageBean();
        pageBean.setPageNum(pageNum);
        SubjectDao dao = new SubjectDao();
        Long n = dao.count();
        int row=Integer.parseInt(String.valueOf(n));
        pageBean.setRowCount(row);
        List<Subject> list =dao.findList(pageBean);
        pageBean.setList(list);
        for (Subject s: list) {
            s.setStudents(null);
        }
        pageBean.setList(list);
        String json=new Gson().toJson(pageBean);
        //设置响应类型
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);
    }
}
