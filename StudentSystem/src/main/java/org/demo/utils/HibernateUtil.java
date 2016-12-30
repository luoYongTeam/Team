package org.demo.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	
	private static EntityManagerFactory emFactory;
	
	static {
		emFactory = Persistence.createEntityManagerFactory("new_jpa");
	}
	
	public static EntityManager getEntityManager(){
		return emFactory.createEntityManager();
	}

	public static void main(String[] args) {
		System.out.println(getEntityManager());
	}
}
