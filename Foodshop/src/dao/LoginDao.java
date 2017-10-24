package dao;

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
	
	
	public int check(String uid,String pwd)
	{
		//execution come from check login controller 
		int x=0;//initialize the variable
		try {	
			 Connection con=start();//connection establishment
		    PreparedStatement ps=con.prepareStatement("select * from alogin where userid=? and password=?");//prepare the statement and create sql 
			ps.setString(1,uid);//set placeholder parameter for sql query
			ps.setString(2,pwd);
 	        ResultSet rs= ps.executeQuery();//execute the statement
			    if(rs.next())//check condition
			    	  x=1;//set when condition is true
			  }catch(SQLException  e)
			{
				System.out.println(e);//exception detail print
			}

	return x;//return integer..
	//execution go back to check login controller
	}
//	
//	public static void main(String args[])
//	{ System.out.println(LoginDao.start());}
//	

//execution come from adeditprofile controller to here
	public int changePwd(String cpass,String npass2,String userid) {

	
		int x=0;
		String pass="";
		try {
			//connection establishment
			Connection con=new ProductDao().start();//return the connection reference
			//prepare the statement 
			//create the sql query
			PreparedStatement ps1=con.prepareStatement("select password from alogin where userid=?");//placeholder
	   	    ps1.setString(1,userid);//set the placeholder value
	   	    //create resultset reference
	   	    //execute statement
	   	    ResultSet rs= ps1.executeQuery();//return the data to result set reference
			while(rs.next())//condition check
			{
				//get the data by result set reference
			  pass=rs.getString("password");	
			}
			if(pass.equalsIgnoreCase(cpass))//condition true if password match to current password 
			{
				//prepare statement
				//create sql query
			PreparedStatement ps=con.prepareStatement("update alogin set password=? where userid=?");//placeholder
			//set the value of placeholder   	    
			ps.setString(1,npass2);
			   	    ps.setString(2,userid);
			  //execute statement
			   	    x=ps.executeUpdate();//return the no. of rows affected
			}  	    
			     }catch(Exception e)//exception handling
			     {
			   	  System.out.println(e);//print exception in detail
			     }

		
		return x; //return the integer value
		//execution go to adeditpcontroller
	}

}
