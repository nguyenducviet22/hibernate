package test;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.CatDao;
import model.Cat;
import util.HibernateUtil;

public class Test2 {
	public static void main(String[] args) {
		//Transient
		Cat cat = new Cat("Son", new Date(System.currentTimeMillis()), true);
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				//Persistent
				session.save(cat);
				trans.commit();
				//Detach => Persistent
				session.refresh(cat);
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
