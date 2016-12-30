package org.demo.service;

import org.demo.dao.SubjectDao;
import org.demo.entity.Subject;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */
public class AddSubjectService {
    public String service(Subject subject){
        SubjectDao dao=new SubjectDao();
        dao.save(subject);
        return "添加成功";
    }
}
