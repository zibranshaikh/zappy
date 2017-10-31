package customerdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Product;
import customerbean.Customer;
import dao.ProductDao;

public class CustomerDao {

	//execution come from custcontroller
	public int insertCust(Customer e)
	{
		
		int x=0;
		
		try {
			//connection establishment
			 Connection con=new LoginDao().start();//return connection object
			 //prepare statement
			 //create sql query
		    PreparedStatement ps=con.prepareStatement("insert into customer values(?,?,?,?,?,?)");
			//set placeholder value
		    ps.setString(1,e.getIpadd());
            ps.setString(2,e.getName());
			ps.setString(3,e.getAddress());
			ps.setString(4,e.getEmail());
			ps.setLong(5,e.getMobile());
			ps.setString(6,e.getPassword());
			//execute statement
			x= ps.executeUpdate();//return no. of rows affected
			
			 con.close();//close connection
			  }catch(SQLException  ex)//exception handling
			{
				System.err.println(ex);//print exception detail
			}
		
		return x;//return integer value
		//execution go to custcontroller
	}
	
	//execution come here from view customer controller
	public ArrayList<Customer> viewCust()
	{
		//object creation of array list of customer type
		ArrayList<Customer> list=new ArrayList<>();
		try {	
			//connection establishment
		    Connection con=new LoginDao().start();//return the connection reference 
		    //prepare statement
		    //create sql query
		    PreparedStatement ps=con.prepareStatement("select * from customer");
			ResultSet rs= ps.executeQuery();//return the result and set to the result set reference
		while(rs.next())//condition true if there is data
		{
			//object creation of customer bean class
			Customer e=new Customer();
			//set the value of all field by setter method with result set reference
			e.setName(rs.getString("name"));
			e.setAddress(rs.getString("address"));
			e.setEmail(rs.getString("email"));
			e.setMobile(rs.getLong("mobile"));
			e.setPassword(rs.getString("password"));
			//add the object in array list
			list.add(e);
		}
			con.close();//connection close
			  }catch(SQLException  ex)//exception handling
			{
				System.err.println(ex);//exception detail print
			}
		
		return list;//return the list
		//execution go to view customer controller
		}
//execution come from edit profile controller
	public Customer viewProfileUpdate(String email)
	{
		//object creation of customer bean class
		Customer e=new Customer();
		try {	
			//connection establishment
			Connection con=new ProductDao().start();//return the connection object
			//prepare the statement
			//create sql query
		    PreparedStatement ps=con.prepareStatement("select * from Customer where email=?");
			//set the value of placeholder
		    ps.setString(1,email);
		    //execute statement
		    ResultSet rs= ps.executeQuery();//return the data and set the result in result set reference
		while(rs.next())//if data is there then condition true
		{
			//set the value to the fields by customer object
			e.setName(rs.getString("name"));
			e.setAddress(rs.getString("address"));
			e.setEmail(rs.getString("email"));
			e.setMobile(rs.getLong("mobile"));
			e.setPassword(rs.getString("password"));
			
		}
		System.out.println(e);
			con.close();//connection close
			  }catch(SQLException  ex)//exception handling
			{
				System.err.println(ex);//print exception detail
			}
		
		return e;//return the object of customer class 
		//execution go to  the editprofile controller
		}

	//execution come from orderplacecontroller 
	public Customer viewCust(String email)
	{
		//object creation of customer class
		Customer e=new Customer();
		try {	
			//connection establishment
			Connection con=new ProductDao().start();//return the connection object
			//prepare statement
			//create sql query
		    PreparedStatement ps=con.prepareStatement("select * from customer where email=?");
			//set the value of placeholder
		    ps.setString(1,email);
		    //execute statement
		    ResultSet rs= ps.executeQuery();//return the data and assign it to result set reference
		while(rs.next())//if data is there then condition true
		{
			//set the value in customer object
			e.setName(rs.getString("name"));
			e.setAddress(rs.getString("address"));
			e.setEmail(rs.getString("email"));
			e.setMobile(rs.getLong("mobile"));
			e.setPassword(rs.getString("password"));
			
		}
		
			con.close();//connection close
			  }catch(SQLException  ex)//exception handling
			{
				System.err.println(ex);//print detail exception
			}
		
		return e;//return the customer object which contain data
	//execution go to orderplacecontroller...	
	}

	//execution come from edit profile controller post method 
	public int editProfile(String email1,String name,String address,String email,String mobile) {
		int x=0;
		try {	
			//connection establishment
			Connection con=new ProductDao().start();//return the connection object
		//prepare statement
			//prepare sql query
			PreparedStatement ps=con.prepareStatement("update customer set name=?,address=?,email=?,mobile=? where email=?");
			//set placeholder value
			ps.setString(1,name);
			ps.setString(2,address);
			ps.setString(3,email);
			ps.setString(4,mobile);
			ps.setString(5,email1);
		       //execute statement
			x=ps.executeUpdate();//return number of rows affected
		    con.close();//connection close
			  }catch(SQLException  ex)//exception handling
			{
				System.err.println(ex);//print exception in detail
			}
		
		return x;//return integer value
		//execution go to edit profile controller
	}

	public int changeCpwd(String cpass, String npass2, String user) {

		int x=0;
		String pass="";
		try {
			//connection establishment
			Connection con=new ProductDao().start();//return the connection reference
			//prepare the statement 
			//create the sql query
			PreparedStatement ps1=con.prepareStatement("select password from customer where email=?");//placeholder
	   	    ps1.setString(1,user);//set the placeholder value
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
			PreparedStatement ps=con.prepareStatement("update customer set password=? where email=?");//placeholder
			//set the value of placeholder   	    
			ps.setString(1,npass2);
			ps.setString(2,user);
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

	public Customer getPass(String email) {

      Customer c=new Customer();
		try {
			//connection establishment
			Connection con=new ProductDao().start();//return the connection reference
			//prepare the statement 
			//create the sql query
			PreparedStatement ps1=con.prepareStatement("select password from customer where email=?");//placeholder
	   	    ps1.setString(1,email);//set the placeholder value
	   	    //create resultset reference
	   	    //execute statement
	   	    ResultSet rs= ps1.executeQuery();//return the data to result set reference
			while(rs.next())//condition check
			{
				//get the data by result set reference
			  c.setPassword(rs.getString("password"));	
			}
	}catch(Exception e)//exception handling
	     {
	   	  System.out.println(e);//print exception in detail
	     }

  return c;	
}
}