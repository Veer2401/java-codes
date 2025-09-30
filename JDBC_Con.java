
import java.sql.*;
public class JDBC_Con {
	public static void main(String[] args) throws Exception{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded");
			
			Connection c = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","Veer@123");
			
			System.out.println("Connection with Oracle is successful");
			
			
			Statement s = c.createStatement();
			
		
			ResultSet rs = s.executeQuery("select * from airlines");
			
			System.out.println("Fetching table...");
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+ " " + rs.getString(2)+ " " + rs.getString(3));
			}
			
			c.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
