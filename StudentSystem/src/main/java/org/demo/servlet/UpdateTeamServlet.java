package org.demo.servlet;

import com.google.gson.Gson;
import org.demo.entity.Team;
import org.demo.service.UpdateTeamService;

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
@WebServlet("/updateTeamServlet")
public class UpdateTeamServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tid =request.getParameter("teamid");
        String className=request.getParameter("className");
        Team team=new Team();
        team.setTid(tid);
        team.setClassName(className);
        UpdateTeamService service=new UpdateTeamService();
        String message=service.service(team);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(message);
    }
}
