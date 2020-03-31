package sql;

import java.sql.*;

import org.testng.annotations.Test;

public class SqlTestHomework extends TestSuperClass {

	public SqlTestHomework() {
		super("sakila");
	}

	@Test(priority=1)
	public void canReturnFilmsInfo() {
		try {
			ResultSet rs = stmt.executeQuery(
					"SELECT film_id, title " +
					"FROM film " +
					"WHERE title LIKE '%airplane%';");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	@Test(priority=2)
	public void canReturnInventoryIds() {
		try {
			ResultSet film_idResult = stmt.executeQuery(
					"SELECT film_id " +
					"FROM film " +
					"WHERE title = 'ALIEN CENTER';");
			film_idResult.next();
			int film_id = film_idResult.getInt(1);
			CallableStatement cs = con.prepareCall("CALL film_in_stock(?,?,?);");
			cs.setInt(1, film_id);
			cs.setInt(2, 2);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.executeQuery();
			ResultSet rs = cs.getResultSet();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
			}
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	@Test(priority=3)
	public void canInsertNewStore() {
		try {
			String staffInsert = 
					"INSERT INTO staff (staff_id, first_name, last_name, address_id, picture, email, store_id, active, username, password, last_update) " +
					"VALUES (3, 'John', 'Doe', 5, NULL, 'John.Doe@sakilastaff.org', 2, 1, 'JOHN', NULL, NOW());";
			String storeInsert =
					"INSERT INTO store (store_id, manager_staff_id, address_id, last_update) " +
					"VALUES (3, 3, 5, NOW());";
			String staffUpdate =
					"UPDATE staff " +
					"SET store_id = 3 " +
					"WHERE staff_id = 3";
			stmt.execute(staffInsert);
			stmt.execute(storeInsert);
			stmt.execute(staffUpdate);
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	@Test(priority=4)
	public void canSetLast_Update() {
		try {
			String sql =
					"UPDATE store " +
					"SET last_update = NOW() " +
					"WHERE store_id = 3;";
			stmt.execute(sql);
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	@Test(priority=5)
	public void canDeleteFromStore() {
		try {
			String staffUpdate = 
					"UPDATE staff " +
					"SET store_id = 2 " +
					"WHERE staff_id = 3;";
			String storeDelete =
					"DELETE FROM store " +
					"WHERE store_id = 3;";
			String staffDelete =
					"DELETE FROM staff " +
					"WHERE staff_id = 3;";
			stmt.execute(staffUpdate);
			stmt.execute(storeDelete);
			stmt.execute(staffDelete);
		} catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

}
