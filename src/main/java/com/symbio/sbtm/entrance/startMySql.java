package com.symbio.sbtm.entrance;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
//import com.mysql.management.MysqldResource;
//import com.mysql.management.MysqldResourceI;
//import com.mysql.management.util.QueryUtil;

public class startMySql {
    //	public static final String DRIVER = "com.mysql.jdbc.Driver";
    //	public static final String JAVA_IO_TMPDIR = "java.io.tmpdir";
    //
    //	public static void main(String[] args) throws Exception {
    //		File ourAppDir = new File(System.getProperty(JAVA_IO_TMPDIR));
    //		File databaseDir = new File(ourAppDir, "mysql-mxj");
    //		int port = Integer.parseInt(System.getProperty("c-mxj_test_port",
    //				"3336"));
    //		String userName = "alice";
    //		String password = "q93uti0opwhkd";
    //		MysqldResource mysqldResource = startDatabase(databaseDir, port,
    //				userName, password);
    //		Class.forName(DRIVER);
    //		Connection conn = null;
    //		try {
    //			String dbName = "our_test_app";
    //			String url = "jdbc:mysql://localhost:" + port + "/" + dbName //
    //					+ "?" + "createDatabaseIfNotExist=true"//
    //			;
    //			conn = DriverManager.getConnection(url, userName, password);
    //			String sql = "SELECT VERSION()";
    //			String queryForString = new QueryUtil(conn).queryForString(sql);
    //			System.out.println("------------------------");
    //			System.out.println(sql);
    //			System.out.println("------------------------");
    //			System.out.println(queryForString);
    //			System.out.println("------------------------");
    //			System.out.flush();
    //			Thread.sleep(100); // wait for System.out to finish flush
    //		} finally {
    //			try {
    //				if (conn != null) {
    //					conn.close();
    //				}
    //			} catch (Exception e) {
    //				e.printStackTrace();
    //			}
    //			try {
    //				mysqldResource.shutdown();
    //			} catch (Exception e) {
    //				e.printStackTrace();
    //			}
    //		}
    //	}
    //
    //	public static MysqldResource startDatabase(File databaseDir, int port,
    //			String userName, String password) {
    //		MysqldResource mysqldResource = new MysqldResource(databaseDir);
    //		Map database_options = new HashMap();
    //		database_options.put(MysqldResourceI.PORT, Integer.toString(port));
    //		database_options.put(MysqldResourceI.INITIALIZE_USER, "true");
    //		database_options.put(MysqldResourceI.INITIALIZE_USER_NAME, userName);
    //		database_options.put(MysqldResourceI.INITIALIZE_PASSWORD, password);
    //		mysqldResource.start("test-mysqld-thread", database_options);
    //		if (!mysqldResource.isRunning()) {
    //			throw new RuntimeException("MySQL did not start.");
    //		}
    //		System.out.println("MySQL is running.");
    //		return mysqldResource;
    //	}
}
