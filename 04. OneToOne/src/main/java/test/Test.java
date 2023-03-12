package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Person;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction trans = session.beginTransaction();
				String hql = "select p.name, p.spouse.name from Person p";
				List<Object[]> result = session.createQuery(hql).list();
				for (Object[] rs : result) {
					String name = rs[0] + "";
					String spousename = rs[1] + "";
					
					System.out.println(name + " got married to " + spousename);
				}
				trans.commit();
				session.close();
			}
	}
}
