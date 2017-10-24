package customerdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {


	//method for return the connection 
	public Connection start()
	{
		//connection reference creation
		Connection con=null;
		try {	
			//load jdbc suitable driver
			 Class.forName("com.mysql.jdbc.Driver");
			 //establish the connection and assign it into connection reference
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodshop","root","");
		}catch(ClassNotFoundException | SQLException e)//exception handling
		{
			System.out.println(e);//print exception
		}
		return con;//return connection object which contain connection
		
	}
	
	
}
