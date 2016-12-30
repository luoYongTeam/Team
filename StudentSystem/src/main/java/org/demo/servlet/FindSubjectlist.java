package org.demo.servlet;


import com.google.gson.Gson;
import org.demo.dao.SubjectDao;
import org.demo.entity.Subject;

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
        SubjectDao dao=new SubjectDao();
        List<Subject> list=dao.findList(Subject.class);
        for (Subject s: list) {
            s.setStudents(null);
        }
        String json=new Gson().toJson(list);
        //设置响应类型
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);
    }
}
