package org.demo.service;

import org.demo.dao.TeamDao;
import org.demo.entity.Team;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */
public class AddTeamService {
    public String service(Team team){
        TeamDao dao=new TeamDao();
        dao.save(team);
         return  "添加成功";
    }
}
