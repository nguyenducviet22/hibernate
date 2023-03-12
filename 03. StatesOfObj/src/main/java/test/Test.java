package test;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.CatDao;
import model.Cat;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		//Transient
		Cat cat1 = new Cat();
		cat1.setId(1);
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				//Persistent
				cat1 = session.get(Cat.class, 1);
				trans.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(cat1);
	}
}
