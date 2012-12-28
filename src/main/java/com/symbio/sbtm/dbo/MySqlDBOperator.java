package com.symbio.sbtm.dbo;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.naming.*;
import javax.sql.*; //import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import com.symbio.sbtm.dbo.IDBO;

/**
 * <strong>mysql数据库操作帮助类</strong>
 * <p>
 * 包装了mysql常用的操作方法。类似于SqlHelper在java中的实现。
 * </p>
 * 
 * @author birdshover
 */
public class MySqlDBOperator implements IDBO {
	private Boolean locker = false;
	private InitialContext ict = null;

	// /**
	// * 测试使用方法，也可以直接使用，改方法应该只被调用一次。 用来注册数据源。
	// */
	// public synchronized void forTest() {
	// if (locker)
	// return;
	// else
	// locker = true;
	// BasicDataSource bdds = new BasicDataSource();
	// bdds.setDriverClassName("org.gjt.mm.mysql.Driver");
	// // bdds.setDriverClassName("com.mysql.jdbc.Driver");
	// bdds
	// .setUrl("jdbc:mysql://localhost:3306/SBTMDBWeb?useUnicode=true&characterEncoding=UTF-8");
	// bdds.setUsername("root");
	// bdds.setPassword("test");
	// bdds.setInitialSize(100);
	// Hashtable<String, String> env = new Hashtable<String, String>();
	// env.put("java.naming.factory.initial",
	// "org.apache.naming.java.javaURLContextFactory");
	// try {
	// ict = new InitialContext(env);
	// ict.bind("SBTMDB", bdds);
	// } catch (Exception ex) {
	// locker = false;
	// System.out.println(ex.getMessage());
	// }
	// }
	//
	// /**
	// * 返回数据库连接对象，连接失败则返回null
	// *
	// * @return Connection
	// */
	// public Connection getConnection() {
	// try {
	// if (ict == null)
	// forTest();
	// // InitialContext context = new InitialContext();
	// // DataSource ds2 = (DataSource) context
	// // .lookup("java:comp/env/SBTMDB");
	// DataSource ds = (DataSource) ict.lookup("SBTMDB");
	//
	// return ds.getConnection();
	// } catch (NamingException ex) {
	// System.err.println(ex.getMessage());
	// return null;
	// } catch (SQLException ex) {
	// System.err.println(ex.getMessage());
	// return null;
	// } catch (Exception ex) {
	// System.err.println(ex.getMessage());
	// return null;
	// }
	// }

	public Connection getConnection() {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}

		try {
			java.sql.Connection conn = java.sql.DriverManager
					.getConnection("jdbc:mysql://localhost:3306/SBTMDB?useUnicode=true&characterEncoding=UTF-8&user=root&password=test");
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 无结果查询，适用于更新和插入
	 * 
	 * @param SQL语句
	 * @param 语句带的参数
	 * @return 操作影响行数
	 * @throws SQLException
	 * @example Object[] parms = new Object[2];<br/>
	 *          parms[0] = "标题"; <br/>
	 *          parms[1] = "内容";<br/>
	 *          int val = mysqlhelper.ExecuteNoneQuery(
	 *          "insert into Documents(Title,Content) values (?,?)", parms);
	 */
	public int ExecuteNoneQuery(String cmdtext, Object[] parms)
			throws SQLException {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(cmdtext);
			prepareCommand(pstmt, parms);
			int v = pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			Serializable ret = null;
			if (rs.next()) {
				ret = (Serializable) rs.getObject(1);
			}
			if (ret instanceof Long)
				return ((Long) ret).intValue();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return 0;
	}

	/**
	 * 返回查询结果集
	 * 
	 * @param SQL语句
	 * @param 附带参数
	 * @return 返回结果，用ArrayList包装Object数组
	 * @throws SQLException
	 * @example ArrayList list =
	 *          mysqlhelper.ExecuteReader("Select * from Documents",null); <br/>
	 *          for(int i = 0;i&lt;list.size();i++) { <br/>
	 *          &nbsp;&nbsp;Object[] obs = (Object[])list.get(i); <br/>
	 *          &nbsp;&nbsp;for(int j = 0;j&lt;obs.length;j++) { <br/>
	 *          &nbsp;&nbsp;&nbsp;&nbsp;out.print(obs[j].toString()); <br/>
	 *          &nbsp;&nbsp;} <br/>
	 *          &nbsp;&nbsp;out.print("&lt;br/&gt;"); <br/>
	 *          } <br/>
	 * 
	 */
	public ArrayList<Object> ExecuteReader(String cmdtext, Object[] parms)
			throws SQLException {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(cmdtext);

			prepareCommand(pstmt, parms);
			rs = pstmt.executeQuery();

			ArrayList<Object> al = new ArrayList<Object>();
			ResultSetMetaData rsmd = rs.getMetaData();
			int column = rsmd.getColumnCount();

			while (rs.next()) {
				Object[] ob = new Object[column];
				for (int i = 1; i <= column; i++) {
					ob[i - 1] = rs.getObject(i);
				}
				al.add(ob);
			}
			return al;

		} catch (Exception ex) {
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return null;
	}

	/**
	 * 返回第1行第1列数据，一般用来查询count值
	 * 
	 * @param SQL语句
	 * @param 带参数
	 * @return 值
	 * @throws SQLException
	 */
	public long ExecuteScalar(String cmdtext, Object[] parms)
			throws SQLException {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(cmdtext);
			prepareCommand(pstmt, parms);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getLong(1);
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return 0;
	}

	private void prepareCommand(PreparedStatement pstmt, Object[] parms)
			throws SQLException, UnsupportedEncodingException {
		if (parms != null && parms.length > 0) {
			for (int i = 1; i < parms.length + 1; i++) {
				Object item = parms[i - 1];
				String typeName = item.getClass().getSimpleName();
				if (typeName.equals("String")) {
					pstmt.setString(i, item.toString());
				} else if (typeName.equals("Integer")) {
					pstmt.setInt(i, Integer.parseInt(item.toString()));
				} else if (typeName.equals("Date")) {
					pstmt.setDate(i, Date.valueOf(item.toString()));
				} else {
					pstmt.setObject(i, item);
				}
			}
		}
	}

	public static void main(String[] args) throws SQLException {
		String sql = "insert into test(name) values('dsds')";
		int ab = new MySqlDBOperator().ExecuteNoneQuery(sql, null);
	}

	private void test1() throws SQLException {
		String sql = "select tname from trees";
		ArrayList<Object> list = new MySqlDBOperator().ExecuteReader(sql, null);
		for (int i = 0; i < list.size(); i++) {
			Object o = list.get(i);
			Object[] tname = (Object[]) (o);
			System.out.println(tname[0]);
		}
	}
}