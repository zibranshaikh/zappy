package customerdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

	public Connection start()
	{
		Connection con=null;
		try {	
			 Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodshop","root","");
					}catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
		}
		return con;
	}
	
	
	public int check(String uid,String pwd)
	{
		int x=0;
		try {	
			 Connection con=start();
		    PreparedStatement ps=con.prepareStatement("select * from login where email=? and password=?");
			ps.setString(1,uid);
			ps.setString(2,pwd);
 	        ResultSet rs= ps.executeQuery();
			    if(rs.next())
			    	  x=1;
			  }catch(SQLException  e)
			{
				System.out.println(e);
			}

	return x;
	}
	public static void main(String[] args) {
		System.out.println(new LoginDao().start());
	}
	
}
