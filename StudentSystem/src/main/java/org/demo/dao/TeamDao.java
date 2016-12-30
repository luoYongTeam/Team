package org.demo.dao;

import org.demo.entity.Subject;
import org.demo.entity.Team;
import org.demo.utils.HibernateUtil;
import org.demo.utils.PageBean;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/27.
 */
public class TeamDao extends BaseDao<Team>{
    public List<Team> findList(PageBean pageBean){
        String jpql = "from Team t ";
        EntityManager em = HibernateUtil.getEntityManager();
        //开启事务
        em.getTransaction().begin();
        List<Team> list = new ArrayList<>();
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
        String jpql = "select count(*) from Team s  ";
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
