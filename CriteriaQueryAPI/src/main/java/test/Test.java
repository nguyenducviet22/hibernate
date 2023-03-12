package test;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import model.Category;
import model.Product;
import util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> query = builder.createQuery(Product.class);
			Root<Product> root = query.from(Product.class);
			query.select(root);

			Predicate p1 = builder.like(root.get("name").as(String.class), "%Nike%");
			Predicate p2 = builder.like(root.get("description").as(String.class), "Durable");
			Predicate p3 = builder.between(root.get("price").as(BigDecimal.class), new BigDecimal(450),
					new BigDecimal(500));

			query.where(p3);
			query.where(builder.and(p3, builder.and(p1, p2)));
			query.where(builder.and(p1, p2));

			Query<Product> q = session.createQuery(query);
			List<Product> list = q.getResultList();
			for (Product product : list) {
//				System.out.println(product);
			}
			session.close();
		}

		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
			Root<Product> root = query.from(Product.class);
			query.multiselect(builder.count(root.get("id")), builder.max(root.get("price")),
					builder.min(root.get("price")));

			Query<Object[]> q = session.createQuery(query);
			Object[] o = q.getSingleResult();
//			System.out.println("Amount: " + o[0]);
//			System.out.println("The highest price: " + o[1]);
//			System.out.println("The lowest price: " + o[2]);

			session.close();
		}

		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
			Root<Product> proRoot = query.from(Product.class);
			Root<Category> cateRoot = query.from(Category.class);
			query = query.where(builder.equal(proRoot.get("category"), cateRoot.get("cid")));

			query.multiselect(cateRoot.get("cname").as(String.class), 
					builder.count(proRoot.get("id")),
					builder.min(proRoot.get("price").as(BigDecimal.class)),
					builder.max(proRoot.get("price").as(BigDecimal.class)));
			query.groupBy(cateRoot.get("cname").as(String.class));
			query.orderBy(builder.asc(cateRoot.get("cname").as(String.class)));
			
			Query<Object[]> q = session.createQuery(query);
			List<Object[]> list = q.getResultList();
			for (Object[] obj : list) {
				System.out.println(obj[0]);
				System.out.println(obj[1]);
				System.out.println(obj[2]);
				System.out.println(obj[3]);
			}
			session.close();
		}
	}
}
