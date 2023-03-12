package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Student;
import model.Teacher;
import util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();

			Teacher t1 = new Teacher("T1", "Ng Van A", new Date(System.currentTimeMillis()), "English");
			Student s1 = new Student("S1", "Ng Van B", new Date(System.currentTimeMillis()), 9.6);

			session.save(t1);
			session.save(s1);
			trans.commit();
			session.close();
		}
	}
}
