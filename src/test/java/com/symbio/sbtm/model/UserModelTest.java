package com.symbio.sbtm.model;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import junit.framework.Assert;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.*;

import com.symbio.sbtm.factory.HSFactory;
import com.symbio.sbtm.model.Role;
import com.symbio.sbtm.model.User;

public class UserModelTest {

	private Session session;

	@BeforeClass
	public void beforeClass() {
		session = HSFactory.getSessionFactory().openSession();
	}

	@DataProvider(name = "userData")
	public static Object[][] usersDataProvider() {
		return new Object[][] { new Object[] { "admin", "System Administrator",
				"Administrator" },
		 new Object[] { "pm", "Project Manager", "Project Manager" },
		 new Object[] { "creator", "Component Creator", "Creator" },
		 new Object[] { "tester", "Tester", "Tester" }
		};
	}

	@DataProvider(name = "roleData")
	public static Object[][] rolesDataProvider() {
		return new Object[][] { new Object[] { "Administrator",
				"System Administrator" },
		// new Object[] { "Project Manager", "Project Manager" },
		// new Object[] { "Creator", "Component Creator" },
		// new Object[] { "Tester", "Tester" }
		};
	}

	@Test(dataProvider = "roleData")
	public void createRoles(String name, String description) {
		Transaction tx = session.beginTransaction();
		try {
			Role role = new Role();
			role.setName(name);
			role.setDescription(description);
			session.save(role);
			tx.commit();

			// List roles = session.createQuery("FROM Role").list();
			// for (Iterator iterator = roles.iterator(); iterator.hasNext();) {
			// Role ro = (Role) iterator.next();
			// System.out.println("role id: " + ro.getId());
			// System.out.println("First Name: " + ro.getName());
			// System.out.println("Description: " + ro.getDescription());
			// System.out.println("----------------------------------------");
			// }

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "userData", dependsOnMethods = "createRoles")
	public void createUsers(String name, String description, String role) {
		Transaction tx = session.beginTransaction();
		try {
			User up = new User(name, "1111");
			up.setDescription(description);

			session.save(up);
			tx.commit();

			List roles = session
					.createQuery("from Role as role where role.name=:name")
					.setString("name", role).list();
			Role ro = null;
			if (roles.size() > 0) {
				tx = session.beginTransaction();
				ro = (Role) roles.get(0);
				ro.getUsers().add(up);
				session.update(ro);
				tx.commit();
			}

			if (null != ro) {
				tx = session.beginTransaction();
				up.getRoles().add(ro);
				session.update(up);
				tx.commit();
			}

			// List users = session.createQuery("FROM User").list();
			// for (Iterator iterator = users.iterator(); iterator.hasNext();) {
			// User user = (User) iterator.next();
			// System.out.println("UserID: " + user.getUserId());
			// System.out.println("Username: " + user.getFirstName());
			// System.out.println("Description: " + user.getDescription());
			// System.out.println("Role: "
			// + user.getRoles().toArray()[0].toString());
			// System.out.println("----------------------------------------");
			// }
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			Assert.fail();
		}
	}

	@AfterClass
	public void afterClass() {
		session.close();
	}
}
