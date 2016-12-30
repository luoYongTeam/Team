package org.demo.servlet;

import com.google.gson.Gson;
import org.demo.entity.Team;
import org.demo.service.DeleteTeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */@WebServlet("/deleteTeamServlet")
public class DeleteTeamServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tid =request.getParameter("tid");
        Team team=new Team();
        team.setTid(tid);
        DeleteTeamService service=new DeleteTeamService();
        String message=service.service(team);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(message);
    }
}
