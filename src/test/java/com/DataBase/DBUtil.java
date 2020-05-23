package com.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.Generic.remedyPage.Baseclass;
import com.DataBase.NamedParameterStatement;

//import DBTablePrinter;

public class DBUtil extends Baseclass {
	
	boolean size = false;

	String arsys_jdbc_url = q.getProperty("arsys.jdbc.url");
	String arsys_jdbc_username = q.getProperty("arsys.jdbc.username");
	String arsys_jdbc_password = q.getProperty("arsys.jdbc.password");
	String mdm_jdbc_url = q.getProperty("mdm.jdbc.url");
	String mdm_jdbc_username = q.getProperty("mdm.jdbc.username");
	String mdm_jdbc_password = q.getProperty("mdm.jdbc.password");

	public void validationWithDatabase(String searchString,
			String SearchAttribute, String query) throws Exception {
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		Connection con = DriverManager.getConnection(arsys_jdbc_url,
				arsys_jdbc_username, arsys_jdbc_password);
		Reporter.log(getTimeStamp() +": Connected to Remedy DB", true);
		NamedParameterStatement p = new NamedParameterStatement(con, query,
				false);
		p.setString(SearchAttribute, searchString);
		ResultSet rs = p.executeQuery();	
	
		DBTablePrinter.printResultSet(rs);
		con.close();
	}
	
	public boolean validateStagingTable(String searchString,
			String SearchAttribute, String query) throws Exception {
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		Connection con = DriverManager.getConnection(arsys_jdbc_url,
				arsys_jdbc_username, arsys_jdbc_password);		
		NamedParameterStatement p = new NamedParameterStatement(con, query,
				false);
		p.setString(SearchAttribute, searchString);
		ResultSet rs = p.executeQuery();		
		size = (!rs.isBeforeFirst() && rs.getRow() == 0);
		con.close();		
		return size;
	}
	
	public void validationWithDatabaseWithZeroParameter(
			 String query) throws Exception {
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		Connection con = DriverManager.getConnection(arsys_jdbc_url,
				arsys_jdbc_username, arsys_jdbc_password);
		Reporter.log(getTimeStamp() +": Connected to Remedy DB", true);
		NamedParameterStatement p = new NamedParameterStatement(con, query,
				false);
		ResultSet rs = p.executeQuery();
		DBTablePrinter.printResultSet(rs);
		con.close();
	}

	public void validationWithDatabasewithMultipleparameter(
			String searchString, String SearchAttribute,
			String SearchAttribute1, String searchString1, String query)
			throws Exception {
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		Connection con = DriverManager.getConnection(arsys_jdbc_url,
				arsys_jdbc_username, arsys_jdbc_password);
		Reporter.log(getTimeStamp() +": Connected to Remedy DB", true);
		NamedParameterStatement p = new NamedParameterStatement(con, query,
				false);

		p.setString(SearchAttribute, searchString);
		p.setString(SearchAttribute1, searchString1);
		ResultSet rs = p.executeQuery();
		DBTablePrinter.printResultSet(rs);
		con.close();
	}

	public void validationUsingMultipleTableInSameDatabase(String searchString,
			String SearchAttribute, String query1, String StringValue,
			String query2, String SearchAttribute1) throws Exception {
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		Connection con = DriverManager.getConnection(arsys_jdbc_url,
				arsys_jdbc_username, arsys_jdbc_password);
		Reporter.log(getTimeStamp() +": Connected to Remedy DB", true);
		NamedParameterStatement p = new NamedParameterStatement(con, query1,
				false);
		p.setString(SearchAttribute, searchString);
		ResultSet rs = p.executeQuery();
		while (rs.next()) {
			String Value = rs.getString(StringValue);
			NamedParameterStatement p1 = new NamedParameterStatement(con,
					query2, false);
			p1.setString(SearchAttribute1, Value);
			ResultSet rs1 = p1.executeQuery();
			DBTablePrinter.printResultSet(rs1);

		}
		con.close();
	}
		
		public void validationWithMDMDatabase(String searchString,
				String SearchAttribute, String query) throws Exception {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Connection con = DriverManager.getConnection(mdm_jdbc_url,
					mdm_jdbc_username, mdm_jdbc_password);
			Reporter.log(getTimeStamp() +": Connected to MDM DB", true);
			NamedParameterStatement p = new NamedParameterStatement(con, query,
					false);
			p.setString(SearchAttribute, searchString);
			ResultSet rs = p.executeQuery();
			DBTablePrinter.printResultSet(rs);
			con.close();
		}
		
		public void validationWithMDMDatabaseWithZeroParameter(
				 String query) throws Exception {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Connection con = DriverManager.getConnection(mdm_jdbc_url,
					mdm_jdbc_username, mdm_jdbc_password);
			Reporter.log(getTimeStamp() +": Connected to MDM DB", true);
			NamedParameterStatement p = new NamedParameterStatement(con, query,
					false);
			ResultSet rs = p.executeQuery();
			DBTablePrinter.printResultSet(rs);
			con.close();
		}

		public void validationWithMDMDatabasewithMultipleparameter(
				String searchString, String SearchAttribute,
				String searchString1, String SearchAttribute1, String query)
				throws Exception {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Connection con = DriverManager.getConnection(mdm_jdbc_url,
					mdm_jdbc_username, mdm_jdbc_password);
			Reporter.log(getTimeStamp() +": Connected to MDM DB", true);
			NamedParameterStatement p = new NamedParameterStatement(con, query,
					false);

			p.setString(SearchAttribute, searchString);
			p.setString(SearchAttribute1, searchString1);
			ResultSet rs = p.executeQuery();
			DBTablePrinter.printResultSet(rs);
			con.close();
		}

		public void validationUsingMultipleTableInSameMDMDatabase(String searchString,
				String SearchAttribute, String query1, String StringValue,
				String query2, String SearchAttribute1) throws Exception {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Connection con = DriverManager.getConnection(mdm_jdbc_url,
					mdm_jdbc_username, mdm_jdbc_password);
			Reporter.log(getTimeStamp() +": Connected to MDM DB", true);
			NamedParameterStatement p = new NamedParameterStatement(con, query1,
					false);
			p.setString(SearchAttribute, searchString);
			ResultSet rs = p.executeQuery();
			while (rs.next()) {
				String Value = rs.getString(StringValue);
				NamedParameterStatement p1 = new NamedParameterStatement(con,
						query2, false);
				p1.setString(SearchAttribute1, Value);
				ResultSet rs1 = p1.executeQuery();
				DBTablePrinter.printResultSet(rs1);

			}
		con.close();
	}
		
		public void checkSMUCompanyEditRecordTable(String searchString,
				String SearchAttribute, String query) throws Exception {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Connection con = DriverManager.getConnection(arsys_jdbc_url,
					arsys_jdbc_username, arsys_jdbc_password);
			Reporter.log(getTimeStamp() +": Connected to Remedy DB", true);
			NamedParameterStatement p = new NamedParameterStatement(con, query,
					false);
			p.setString(SearchAttribute, searchString);
			ResultSet rs = p.executeQuery();
			DBTablePrinter.printResultSet(rs);
			con.close();
		}
}
