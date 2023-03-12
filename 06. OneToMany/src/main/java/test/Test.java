package test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Customer;
import model.MyOrder;
import util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();

//			Customer cus1 = new Customer("001", "Viet", "abc@gmail.com");
//			Customer cus2 = new Customer("002", "Son", "abcd@gmail.com");
//
//			MyOrder or1 = new MyOrder("001", "Binh Duong", cus1);
//			MyOrder or2 = new MyOrder("002", "Binh Duong", cus2);
//			MyOrder or3 = new MyOrder("003", "Binh Duong", cus1);
//			MyOrder or4 = new MyOrder("004", "Binh Duong", cus2);
//			MyOrder or5 = new MyOrder("005", "Binh Duong", cus1);
//			MyOrder or6 = new MyOrder("006", "Binh Duong", cus2);
//			MyOrder or7 = new MyOrder("007", "Binh Duong", cus1);
//			MyOrder or8 = new MyOrder("008", "Binh Duong", cus2);
//
//			List<MyOrder> list = new ArrayList<>();
//			list.add(or1);
//			list.add(or2);
//			list.add(or3);
//			list.add(or4);
//			list.add(or5);
//			list.add(or6);
//			list.add(or7);
//			list.add(or8);
//
//			session.saveOrUpdate(cus1);
//			session.saveOrUpdate(cus2);
//			session.saveOrUpdate(or1);
//			session.saveOrUpdate(or2);
//			session.saveOrUpdate(or3);
//			session.saveOrUpdate(or4);
//			session.saveOrUpdate(or5);
//			session.saveOrUpdate(or6);
//			session.saveOrUpdate(or7);
//			session.saveOrUpdate(or8);
//
//			Customer cus3 = new Customer("003", "Haha", "haha@gmail.com");
//			session.save(cus3);

			String hql = "from Customer c where size(c.orders) > 0";
			List<Customer> result = session.createQuery(hql).list();
			for (Customer rs : result) {
				System.out.println(rs);
			}

			trans.commit();
			session.close();
		}
	}
}
