package customerdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CLoginDao {

	//execution come from custlogin controller
	public int check(String uid,String pwd)
	{
		int x=0;
		try {
			//object creation of logindao class
			LoginDao ld=new LoginDao();
			//by this object calling the method which give the connection object
			Connection con=ld.start();
			//prepare the statement
			//create sql query
		    PreparedStatement ps=con.prepareStatement("select * from customer where email=? and password=?");
			//set placeholder value
		    ps.setString(1,uid);
			ps.setString(2,pwd);
			//execute statement
 	        ResultSet rs= ps.executeQuery();//return result and assign it to result set reference
			    if(rs.next())//if data find then condition true
			    	  x=1;
			  }catch(SQLException  e)//exception handling
			{
				System.out.println(e);//exception print
			}

	return x;//return integer value
	//execution go to custlogin controller
	}
}
