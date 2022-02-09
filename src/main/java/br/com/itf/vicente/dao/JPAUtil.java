package br.com.itf.vicente.dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtil {

	public static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("itf-web-jpa-persistence");
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
 
}
