package org.demo.servlet;

import com.google.gson.Gson;
import org.demo.entity.Team;
import org.demo.service.AddTeamService;
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
@WebServlet("/addTeamServlet")
public class AddTeamServelt extends HttpServlet{
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String className = request.getParameter("className");
        Team team=new Team();
        team.setTid(UUIDUtil.getUUID());
        team.setClassName(className);
        AddTeamService service=new AddTeamService();
       String message=service.service(team);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(message);



    }
}
