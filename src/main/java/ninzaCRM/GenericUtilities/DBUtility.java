package ninzaCRM.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DBUtility {
	/**
	 * This class consists of generic methods related to database
	 * 
	 * @author Payal
	 *
	 */
	/**
	 * This method will read data from excel file and return the value to caller
	 */

	public void readAllDataFromDatabase(String URL, String userName, String password, String query) {
		Connection conn = null;
		try {
			// Step 1: Register the MySQL Driver
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			System.out.println("Trying to create connection with MYSQL DB");

			/* Step 2: Connect to the database
			String url = URL;// connectionstring
			String username = userName;// you can use "root" user also
			String password1 = password;// Password is same for both*/

			conn = DriverManager.getConnection(URL, userName, password);

			System.out.println("Connection from MYSQL DB is created successfully ");

			// Step 3: Create Statement
			Statement stat = conn.createStatement();

			// Step 4: Execute Insert Query
		//	String query = "select * from leads";
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
			//System.out.println("Hi my name is PAyal");
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


	public void readCompanyDataFromDatabase(String URL, String userName, String password, String query) {
		Connection conn = null;
		try {
			// Step 1: Register the MySQL Driver
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			System.out.println("Trying to create connection with MYSQL DB");

			/* Step 2: Connect to the database
			String url = URL;// connectionstring
			String username = userName;// you can use "root" user also
			String password1 = password;// Password is same for both*/

			conn = DriverManager.getConnection(URL, userName, password);

			System.out.println("Connection from MYSQL DB is created successfully ");

			// Step 3: Create Statement
			Statement stat = conn.createStatement();

			// Step 4: Execute Insert Query
		//	String query = "select * from leads";
			ResultSet rs = stat.executeQuery(query);

			// Step 5: Process Results
			System.out.println("\tCompany");
			System.out.println("---------------------------------------------------------------");
			while (rs.next()) {
				//int leadId = rs.getInt("lead_id");
				//String leadName = rs.getString("lead_name");
				String companyName = rs.getString("company");
				
				
				System.out.println("  " +  "\t\t" + companyName);

			}
		
			System.out.println("SQL Select all data Query Executed Successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//System.out.println("Hi my name is PAyal");
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


	public void readLeadNameDataFromDatabase(String URL, String userName, String password, String query) {
		Connection conn = null;
		try {
			// Step 1: Register the MySQL Driver
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			System.out.println("Trying to create connection with MYSQL DB");

			/* Step 2: Connect to the database
			String url = URL;// connectionstring
			String username = userName;// you can use "root" user also
			String password1 = password;// Password is same for both*/

			conn = DriverManager.getConnection(URL, userName, password);

			System.out.println("Connection from MYSQL DB is created successfully ");

			// Step 3: Create Statement
			Statement stat = conn.createStatement();

			// Step 4: Execute Insert Query
		//	String query = "select * from leads";
			ResultSet rs = stat.executeQuery(query);

			// Step 5: Process Results
			System.out.println("\tLead Name");
			System.out.println("---------------------------------------------------------------");
			while (rs.next()) {
				//int leadId = rs.getInt("lead_id");
				String leadName = rs.getString("lead_name");
				//String companyName = rs.getString("company");
				
				
				System.out.println("  " +  "\t\t" + leadName);

			}
		
			System.out.println("SQL Select all data Query Executed Successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//System.out.println("Hi my name is PAyal");
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


	public void readLeadIdFromDatabase(String URL, String userName, String password, String query) {
		Connection conn = null;
		try {
			// Step 1: Register the MySQL Driver
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			System.out.println("Trying to create connection with MYSQL DB");

			/* Step 2: Connect to the database
			String url = URL;// connectionstring
			String username = userName;// you can use "root" user also
			String password1 = password;// Password is same for both*/

			conn = DriverManager.getConnection(URL, userName, password);

			System.out.println("Connection from MYSQL DB is created successfully ");

			// Step 3: Create Statement
			Statement stat = conn.createStatement();

			// Step 4: Execute Insert Query
		//	String query = "select * from leads";
			ResultSet rs = stat.executeQuery(query);

			// Step 5: Process Results
			System.out.println("\tLead Id");
			System.out.println("---------------------------------------------------------------");
			while (rs.next()) {
				int leadId = rs.getInt("lead_id");
				//String leadName = rs.getString("lead_name");
				//String companyName = rs.getString("company");
				
				
				System.out.println("  " +  "\t\t" + leadId);

			}
		
			System.out.println("SQL Select all data Query Executed Successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//System.out.println("Hi my name is PAyal");
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
