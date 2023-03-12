package test;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Author;
import model.Book;
import util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
//			Author au1 = new Author("001", "Nguyen Nhat Anh", new Date(System.currentTimeMillis()));
//			Author au2 = new Author("002", "Nam Cao", new Date(System.currentTimeMillis()));
//			Author au3 = new Author("003", "Xuan Dieu", new Date(System.currentTimeMillis()));
//			Book b1 = new Book("2301", "Toi thay hoa vang tren co xanh", 200000, au1);
//			Book b2 = new Book("2302", "Mat biec", 300000, au1);
//			Book b3 = new Book("2303", "Chieu len", 400000, au3);
//			Book b4 = new Book("2304", "I see", 350000, au2);
//			
//			session.saveOrUpdate(au1);
//			session.saveOrUpdate(au2);
//			session.saveOrUpdate(au3);
//			session.saveOrUpdate(b1);
//			session.saveOrUpdate(b2);
//			session.saveOrUpdate(b3);
//			session.saveOrUpdate(b4);
			
			Book b1 = session.find(Book.class, "2302");
			System.out.println(b1.getTitle() + " of " + b1.getAuthor().getFullName());
			
			trans.commit();
			session.close();
		}
	}
}
