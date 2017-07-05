package org.ihc.kr.hibernate.practice.learnHibernateDemo;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.ihc.kr.hibernate.practice.model.Address;
import org.ihc.kr.hibernate.practice.model.Person;

/**
 * Hibernate Demo
 *
 */
public class App {
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Person p = new Person("motha", "chetan");
		session.persist(p);
		

		Person steve = new Person("morratj", "Jobs");
		Person donald = new Person("Donald", "Trump");

		Address valley = new Address("Steve P Jobs San Francisco 11111");
		Address newyork = new Address("Trump Tower New York 22222");
		Address chicago = new Address("Trump Tower Chicago 33333");

		steve.getAddresses().add(valley);
		donald.getAddresses().add(newyork);
		donald.getAddresses().add(chicago);

		System.out.println("Creating Person: " + steve.getFirstName());
		session.persist(steve);
		System.out.println("Creating Person: " + donald.getFirstName());
		session.persist(donald);

		Query query = session.createQuery("from Person");
		List<Person> lst = query.getResultList();

		for (Person person : lst) {
			System.out.println(person);
		}
		
		session.getTransaction().commit();
		session.close();
	}
}
