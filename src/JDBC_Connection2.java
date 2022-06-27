import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class JDBC_Connection2 {

	public static void main(String[] args) throws SQLException {
		//Connection url
		
		String host="localhost";
		String port="3306";
		
		Connection  con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/Amazon_22", "root", "Adi@rockstar5");
		                                                  //String url             //User        //Password
		Statement s=con.createStatement();
		
		ResultSet rs=s.executeQuery("select * from AmazeTAb_22 where 50s=10");
		
		while(rs.next())
		{
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("place"));
			System.out.println(rs.getInt("50s"));
			
			
			
		
			
		
		}

	}

}
