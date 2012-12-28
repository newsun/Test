package com.symbio.sbtm.dbo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IDBO {
	Connection getConnection() throws SQLException;

	int ExecuteNoneQuery(String cmdtext, Object[] parms) throws SQLException;

	ArrayList<Object> ExecuteReader(String cmdtext, Object[] parms)
			throws SQLException;

	long ExecuteScalar(String cmdtext, Object[] parms) throws SQLException;
}
