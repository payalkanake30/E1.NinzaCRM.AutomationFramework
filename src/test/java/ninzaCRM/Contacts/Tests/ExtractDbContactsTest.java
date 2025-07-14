package ninzaCRM.Contacts.Tests;

import ninzaCRM.GenericUtilities.DBUtility;

public class ExtractDbContactsTest {
	public static void main(String[] args) {
		DBUtility dbUtil=new DBUtility();
		dbUtil.readAllDataFromDatabase("jdbc:mysql://localhost:3306/ninzacrmtestdb", "payalkanake30", "QspRaj@123", "select * from leads where Company='TCS'");
		dbUtil.readAllDataFromDatabase("jdbc:mysql://localhost:3306/ninzacrmtestdb", "payalkanake30", "QspRaj@123", "select * from leads where lead_id='1'");
		dbUtil.readAllDataFromDatabase("jdbc:mysql://localhost:3306/ninzacrmtestdb", "payalkanake30", "QspRaj@123", "select * from leads where lead_name='Candy'");
		dbUtil.readCompanyDataFromDatabase("jdbc:mysql://localhost:3306/ninzacrmtestdb", "payalkanake30", "QspRaj@123", "select company from leads where lead_name='Candy'");
		dbUtil.readAllDataFromDatabase("jdbc:mysql://localhost:3306/ninzacrmtestdb", "payalkanake30", "QspRaj@123", "select * from leads");
		dbUtil.readLeadNameDataFromDatabase("jdbc:mysql://localhost:3306/ninzacrmtestdb", "payalkanake30", "QspRaj@123", "select lead_name from leads where Company='Infosys'");
		dbUtil.readLeadIdFromDatabase("jdbc:mysql://localhost:3306/ninzacrmtestdb", "payalkanake30", "QspRaj@123", "select lead_id from leads where Company='TCS'");
	}

}
