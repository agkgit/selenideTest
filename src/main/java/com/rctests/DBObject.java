package com.rctests;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import com.mysql.fabric.xmlrpc.base.Struct;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.StringUtils;

import java.sql.*;

public class DBObject {

	//db config
	private static final String URL			= "jdbc:mysql://rd1-2.redhelper.ru:3306/rc";
	private static final String LOGIN		= "krupenin";
	private static final String PASSWORD	= "5812G904hWjk";

	Connection	connection;
	Statement	statement;

//-------------------------------------------------------------------------------------------------
	DBObject() {
		try {
			Driver driver = new FabricMySQLDriver();
			DriverManager.registerDriver(driver);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {

			this.connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			this.statement = (Statement) this.connection.createStatement();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//исправить return
	public ResultSet getResult(String query) {
		try {
			ResultSet result = statement.executeQuery(query);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void close() {
		try {	this.connection.close();	}
		catch (SQLException e) {	e.printStackTrace();	}
	}

//-------------------------------------------------------------------------------------------------




//			while (result.next()) {
//		System.out.println(result.getString("id") + "\t\t" + result.getString("visitor_phone"));
//	}



}
