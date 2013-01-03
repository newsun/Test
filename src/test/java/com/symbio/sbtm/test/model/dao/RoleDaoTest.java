package com.symbio.sbtm.test.model.dao;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.sbtm.model.Role;
import com.symbio.sbtm.model.dao.RoleDao;
import com.symbio.sbtm.test.model.*;

@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class RoleDaoTest {
	@Autowired
	private RoleDao roleDao;

	private static final Logger logger = Logger.getLogger(RoleDaoTest.class.getName());

	// @Test
	public void testSearch() {
		Role role = null;
		try {
			role = roleDao.getRoleByName("Administrator");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("failed to get the Administrator role");
		}
		Assert.assertNotNull(role);
	}
}
