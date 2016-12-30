package org.demo.service;

import org.demo.dao.TeamDao;
import org.demo.entity.Team;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */
public class UpdateTeamService {
    public String service(Team team){
        TeamDao dao=new TeamDao();
        dao.update(team);
        return  "修改成功";
    }
}
