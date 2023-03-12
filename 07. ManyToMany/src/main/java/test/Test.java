package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Meeting;
import model.Staff;
import util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			
			Staff s1 = new Staff("001", "Ng Van A", new Date(2000, 05, 05));
//			session.save(s1);
			
			Meeting m1 = new Meeting();
			m1.setMeetingName("Hehe");
			m1.setTime(new Date(2023, 01, 05));
			m1.setAddress("Room 1");
			m1.addStaff(s1);
			
			session.save(m1);
			
			trans.commit();
			session.close();
		}
	}
}
