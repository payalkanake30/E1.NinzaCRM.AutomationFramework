package ninzaCRM.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DBInsertTest {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			// Step 1: Register the MySQL Driver
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			System.out.println("Trying to create connection with MYSQL DB");

			// Step 2: Connect to the database
			String url = "jdbc:mysql://localhost:3306/ninzacrmtestdb";// connectionstring
			String username = "payalkanake30";// you can use "root" user also
			String password = "QspRaj@123";// Password is same for both

			conn = DriverManager.getConnection(url, username, password);

			System.out.println("Connection from MYSQL DB is created successfully ");

			// Step 3: Create Statement
			Statement stat = conn.createStatement();

			// Step 4: Execute Insert Query
			String query = "select * from leads";
			ResultSet rs = stat.executeQuery(query);

			// Step 5: Process Results
			System.out.println("Lead Id\t\tLead Name\t\tCompany");
			System.out.println("---------------------------------------------------------------");
			while (rs.next()) {
				int leadId = rs.getInt("lead_id");
				String leadName = rs.getString("lead_name");
				String companyName = rs.getString("company");
				
				System.out.println("  " + leadId + "\t\t" + leadName + "\t\t" + companyName);

			}
		
			System.out.println("SQL Select all data Query Executed Successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Step 6: Close the connection
			try {
				if (conn != null) {
					conn.close();

					System.out.println("Connection from MYSQL DB is closed. ");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
