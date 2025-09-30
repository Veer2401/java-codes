import java.sql.*;

public class OracleConnection{
	public static void main(String[] args) {
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection c = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","Veer@123");
			
			
			c.setAutoCommit(false);
			
			Statement s = c.createStatement();
			
			String query1 = "Insert into airlines (id,company,departure,arrival) values (3,'AirIndia','Delhi','Chigaco')";
			String query2 = "Select * from airlines";
			s.executeQuery(query1);
			
			c.commit();
			
			ResultSet r = s.executeQuery(query2);
			
			while(r.next()) {
				System.out.println(r.getInt(1) + " " + r.getString(2) + " " + r.getString(3) + " " + r.getString(4));
			}
			
			c.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
