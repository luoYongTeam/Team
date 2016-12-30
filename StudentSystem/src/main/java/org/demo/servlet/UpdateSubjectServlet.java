package org.demo.servlet;

import com.google.gson.Gson;
import org.demo.entity.Subject;
import org.demo.service.UpdateSubjectService;

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
@WebServlet("/updateSubjectServlet")
public class UpdateSubjectServlet extends HttpServlet{
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String subid =request.getParameter("subid");
        String subName=request.getParameter("subName");
        Subject subject=new Subject();
        subject.setSubid(subid);
        subject.setSubName(subName);
        UpdateSubjectService service=new UpdateSubjectService();
        String message=service.service(subject);

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(message);
    }
}
