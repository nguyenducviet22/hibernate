package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.DetailedOrder;
import model.Order;
import util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();

			Order o1 = new Order();
			o1.setCustomerName("Ng Van A");
			o1.setBoughtDate(new Date(123, 1, 30));
			
			DetailedOrder de1 = new DetailedOrder();
			de1.setProductName("Haha");
			de1.setSoldPrice(5000);
			de1.setQuantity(5);
			de1.setTotal(5*5000);
			de1.setOrder(o1);
			
			DetailedOrder de2 = new DetailedOrder();
			de2.setProductName("Hihi");
			de2.setSoldPrice(6000);
			de2.setQuantity(4);
			de2.setTotal(4*6000);
			de2.setOrder(o1);
			
			o1.addDeOrder(de1);
			o1.addDeOrder(de2);

			session.save(o1);
			
			trans.commit();
			session.close();
		}
	}
}
