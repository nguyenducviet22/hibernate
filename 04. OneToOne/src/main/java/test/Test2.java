package test;

import java.sql.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Person;
import util.HibernateUtil;

public class Test2 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if(sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
//			Person person = new Person("Nguyen Van A", new Date(System.currentTimeMillis()), null);
//			session.save(person);
			
//			Person person = session.find(Person.class, 1L);
//			Person person2 = new Person("Nguyen Thi B", new Date(System.currentTimeMillis()), person);
//			session.save(person2);
			
			Person person = session.find(Person.class, 1L);
			Person person2 = session.find(Person.class, 2L);
			person.setSpouse(person2);
			session.saveOrUpdate(person);
			trans.commit();
			session.close();
		}
	}
}
