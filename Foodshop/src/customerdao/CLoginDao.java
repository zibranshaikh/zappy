package customerdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CLoginDao {

	public int check(String uid,String pwd)
	{
		int x=0;
		try {	 
			LoginDao ld=new LoginDao();
			Connection con=ld.start();
		    PreparedStatement ps=con.prepareStatement("select * from customer where email=? and password=?");
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
}
