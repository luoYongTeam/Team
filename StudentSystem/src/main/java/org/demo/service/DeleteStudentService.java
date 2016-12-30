package org.demo.service;

import org.demo.dao.CardDao;
import org.demo.dao.StudentDao;
import org.demo.dao.TeamDao;
import org.demo.entity.Card;
import org.demo.entity.Student;
import org.demo.entity.Team;

import java.util.List;

/**
 * Created by Administrator on 2016/12/29.
 */
public class DeleteStudentService {
    public String service(String sid) {
        System.out.println(sid);
        StudentDao dao=new StudentDao();
      /*  CardDao carddao=new CardDao();
        boolean b = carddao.deleteCard(sid);
        System.out.println(b);*/
        Student student=new Student();
        student.setSid(sid);
        Card card=new Card();
        CardDao carddao=new CardDao();
        card.setCid(sid);
        carddao.delete(card);
        dao.delete(student);

        return   "删除成功";
    }
}
