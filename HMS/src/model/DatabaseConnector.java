/**
 * 
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Rohit
 * 
 */
public class DatabaseConnector {

	Connection con = null;
	String driverClassName = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/hospital_database";
	String dbUser = "root";
	String dbPwd = "zxcvbnm";

	public DatabaseConnector() {

	}

	public Connection getDatabaseConnetion(){
		try {
			Class.forName(driverClassName).newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost/hospital_database?user=root&password=zxcvbnm");
		} catch (Exception e) {
			System.out.print("" + e);
		}
		return con;
	}

	public void closeDatabaseConnection() {
		try {
			con.close();
		} catch (Exception ex) {
			System.out.println("" + ex);
		}
	}

}