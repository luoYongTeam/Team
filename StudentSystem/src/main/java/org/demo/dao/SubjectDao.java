package org.demo.dao;

import org.demo.entity.Student;
import org.demo.entity.Subject;
import org.demo.utils.HibernateUtil;
import org.demo.utils.PageBean;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/28.
 */
public class SubjectDao extends BaseDao<Subject>{
    public List<Subject> findList(PageBean pageBean){
        String jpql = "from Subject s ";
        EntityManager em = HibernateUtil.getEntityManager();
        //开启事务
        em.getTransaction().begin();
        List<Subject> list = new ArrayList<>();
        try{
            Query query = em.createQuery(jpql);
            query.setFirstResult(pageBean.getFirstResult());
            query.setMaxResults(pageBean.getMaxResult());
            list = query.getResultList();
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return list;
    }
    public Long count(){
        String jpql = "select count(*) from Subject s  ";
        EntityManager em = HibernateUtil.getEntityManager();
        //开启事务
        em.getTransaction().begin();
        Long row = null;
        try{
            row  =  (Long) em.createQuery(jpql).getSingleResult();
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return row;
    }
}
