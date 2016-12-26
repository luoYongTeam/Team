package org.demo.dao;

import org.demo.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class BaseDao<T> {
		//添加
	public void save(T t){
		//获取Entity对象
		EntityManager em=HibernateUtil.getEntityManager();
		//开启事务
		em.getTransaction().begin();
		try{
			//执行保存操作
			em.persist(t);
			//提交事务
			em.getTransaction().commit();
		}catch (Exception e){
			e.printStackTrace();
			//事务回滚
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}
//删除
	public void delete(T t){
		//获得Entity对象
		EntityManager em=HibernateUtil.getEntityManager();
		//开启事务
		em.getTransaction().begin();
		try{
			//执行删除操作
			em.remove(em.merge(t));
			//提交事务
			em.getTransaction().commit();
		}catch (Exception e){
			e.printStackTrace();
			//事务回滚
			em.getTransaction().rollback();
		}
	}
	//修改
	public void update(T t){
		//获得EntityManager对象
		EntityManager em=HibernateUtil.getEntityManager();
		//开启事务
		em.getTransaction().begin();
		try {
			em.merge(t);
			//提交事务
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			//回滚事务
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}
	//根据主键查询
	public T findById(Class<T> entityClass,Object id){
		//获取EntityManager对象
			EntityManager em=HibernateUtil.getEntityManager();
		//开启事务
		em.getTransaction().begin();
		T entity=null;
		try{
			//查询操作
			entity=em.find(entityClass,id);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return  entity;
	}
	//查出列表
	public List<T> findList(Class<T> entityClass){
		//编写jpql语句
		String jpql="from"+entityClass.getName();
		//获得EntityManager对象
		EntityManager em=HibernateUtil.getEntityManager();
		//开启事务
		em.getTransaction().begin();
		List<T> list=null;
		try{
			Query query=em.createQuery(jpql);
			list=query.getResultList();
			//提交事务
			em.getTransaction().commit();
		}catch (Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		finally {
			em.close();
		}
		return list;
	}
}
