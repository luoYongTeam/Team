package org.demo.service;

import org.demo.dao.TeamDao;
import org.demo.entity.Team;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */
public class DeleteTeamService {
    public String service(Team team){
        TeamDao dao=new TeamDao();
        dao.delete(team);
        return  "删除成功";
    }
}
