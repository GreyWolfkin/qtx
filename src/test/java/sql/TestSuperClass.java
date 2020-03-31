package sql;

import java.sql.*;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestSuperClass {
	
	protected String database;
	protected Connection con;
	protected Statement stmt;
	
	public TestSuperClass(String database) {
		this.database = database;
	}
	
	@BeforeTest
	public void beforeTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" + database
					, "root"
					, "74k37H!$");
			stmt = con.createStatement();
		} catch(ClassNotFoundException ex) {
			System.out.println(ex);
		} catch(SQLException ex) {
			System.out.println(ex);
		}
	}
	
	@AfterTest
	public void afterTest() throws SQLException {
		try {
			con.close();
		} catch(SQLException ex) {
			System.out.println(ex);
		}
	}

}
