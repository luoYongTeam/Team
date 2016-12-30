package org.demo.service;

import org.demo.dao.SubjectDao;
import org.demo.entity.Subject;

import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */
public class DeleteSubjectService {
    public String service(Subject subject){
        SubjectDao dao=new SubjectDao();
        dao.delete(subject);
        return "删除成功";
    }
}
