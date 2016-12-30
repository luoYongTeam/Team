package org.demo.servlet;

import com.google.gson.Gson;
import org.demo.dao.TeamDao;
import org.demo.entity.Team;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/28.
 */
@WebServlet("/findTeamByIdServlet")
public class FindTeamByIdServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tid = request.getParameter("tid");
        TeamDao dao = new TeamDao();
        Team team  = dao.findById(Team.class, tid);
        team.setStudents(null);
        String json = new Gson().toJson(team);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
    }
}
