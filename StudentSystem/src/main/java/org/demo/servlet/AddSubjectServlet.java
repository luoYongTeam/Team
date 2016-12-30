package org.demo.servlet;

import com.google.gson.Gson;
import org.demo.entity.Subject;
import org.demo.service.AddSubjectService;
import org.demo.utils.UUIDUtil;

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
@WebServlet("/addSubjectServlet")
public class AddSubjectServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String subName=request.getParameter("subName");
       Subject subject=new Subject();
       subject.setSubid(UUIDUtil.getUUID());
       subject.setSubName(subName);
       AddSubjectService service=new AddSubjectService();
        String message=service.service(subject);

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(message);

    }
}
