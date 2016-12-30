package org.demo.dao;

import org.demo.entity.Card;
import org.demo.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Created by Administrator on 2016/12/29.
 */
public class CardDao extends BaseDao<Card>{

    public boolean deleteCard(String stuId){
        String sql = "delete from card_info c where c.stu_id = ?1";
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        boolean b = false;
        try{
            //执行原生sql语句
            //如果第二个参数不指定实体类型，则返回的是Object数组
            Query query = em.createNativeQuery(sql);
            query.setParameter(1,stuId);
            query.executeUpdate();
            em.getTransaction().commit();
            b = true;
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return b;
    }
}
