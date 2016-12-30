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
import java.util.List;

/**
 * Created by Administrator on 2016/12/27.
 */
@WebServlet("/findTeamlist")
public class FindTeamlist extends HttpServlet {
    @Override
    protected void service(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
        TeamDao dao=new TeamDao();
        List<Team> list=dao.findList(Team.class);
        for (Team team : list) {
            team.setStudents(null);
        }
        String json = new Gson().toJson(list);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);

    }
}
