package com.symbio.sbtm.factory;

import java.io.File;
import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.symbio.sbtm.model.Role;
import com.symbio.sbtm.model.User;

public class HibernateSessionFactory {
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;

	public static void main(String[] args) {
		testUserGroup();
	}

	public static void testUserGroup() {
		try {
			Configuration configuration = new Configuration();
			configuration.addResource("com/symbio/sbtm/vo/UserGroup.hbm.xml")
					.configure();
			configuration.configure()
					.setProperty("hibernate.show_sql", "false");
			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					configuration.getProperties()).buildServiceRegistry();
			factory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		System.out.println("**Example : Hibernate 4 SessionFactory**");
		System.out.println("----------------------------------------");
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM UserGroup").list();

			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				Role user = (Role) iterator.next();
				System.out.println("First Name: " + user.getId());
				System.out.println("First Name: " + user.getName());
				System.out.println("Description: " + user.getDescription());
				System.out.println("----------------------------------------");
			}
			// UserGroup up = new UserGroup();
			// up.setName("TEst");
			// up.setDescription("TESTTEST");
			// session.save(up);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public static void testUser() {
		try {
			Configuration configuration = new Configuration();
			File f = new File("com/symbio/sbtm/vo/User.hbm.xml");
			if (f.exists())
				System.out.println("File not exist");
			else
				System.out.println("File exists");
			configuration.addResource("com/symbio/sbtm/vo/User.hbm.xml")
					.configure();
			configuration.configure()
					.setProperty("hibernate.show_sql", "false");
			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					configuration.getProperties()).buildServiceRegistry();
			factory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		System.out.println("**Example : Hibernate 4 SessionFactory**");
		System.out.println("----------------------------------------");
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM User").list();
			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				User u = (User) iterator.next();
				System.out.println("User ID: " + u.getUserId());
				System.out.println("User Name: " + u.getFirstName());
				System.out.println("User Description: " + u.getDescription());
			}
			// for (Iterator iterator = employees.iterator();
			// iterator.hasNext();) {
			// UserGroup user = (UserGroup) iterator.next();
			// System.out.println("First Name: " + user.getId());
			// System.out.println("First Name: " + user.getName());
			// System.out.println("Description: " + user.getDescription());
			// System.out.println("----------------------------------------");
			// }

			// UserGroup up = new UserGroup();
			// up.setName("TEst");
			// up.setDescription("TESTTEST");
			// session.save(up);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
