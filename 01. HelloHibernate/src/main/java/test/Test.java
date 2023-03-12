package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cat;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction trans = session.beginTransaction();
					Cat cat1 = new Cat();
					cat1.setName("Tom");
					cat1.setSex(true);
					session.save(cat1);
					trans.commit();
				} finally {
					session.close();
				}
			} else {

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
