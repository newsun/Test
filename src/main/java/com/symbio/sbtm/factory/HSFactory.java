package com.symbio.sbtm.factory;

import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;

//import org.hibernate.service.ServiceRegistryBuilder;

public class HSFactory {

	/*
	 * Hibernate 4 session factory
	 */

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration cfg = new Configuration().configure();
			// ServiceRegistry serviceRegistry = new
			// StandardServiceRegistryBuilder()
			// .applySettings(cfg.getProperties()).buildServiceRegistry();
			// return cfg.buildSessionFactory(serviceRegistry);
			return cfg.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static org.hibernate.SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
