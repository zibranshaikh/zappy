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

	
	public int insertCust(Customer e)
	{
		int x=0;
		
		try {	
			 Connection con=new LoginDao().start();
		    PreparedStatement ps=con.prepareStatement("insert into customer values(?,?,?,?,?,?)");
			ps.setString(1,e.getIpadd());
            ps.setString(2,e.getName());
			ps.setString(3,e.getAddress());
			ps.setString(4,e.getEmail());
			ps.setLong(5,e.getMobile());
			ps.setString(6,e.getPassword());
			x= ps.executeUpdate();
			 con.close();
			  }catch(SQLException  ex)
			{
				System.err.println(ex);
			}
		
		return x;
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

	public Customer viewProfileUpdate(String email)
	{
		Customer e=new Customer();
		try {	
			System.out.println(email);
		    Connection con=new ProductDao().start();
		    PreparedStatement ps=con.prepareStatement("select * from Customer where email=?");
			ps.setString(1,email);
		    ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
			
			e.setName(rs.getString("name"));
			e.setAddress(rs.getString("address"));
			e.setEmail(rs.getString("email"));
			e.setMobile(rs.getLong("mobile"));
			e.setPassword(rs.getString("password"));
			
		}
		System.out.println(e);
			con.close();
			  }catch(SQLException  ex)
			{
				System.err.println(ex);
			}
		
		return e;
		}

	public Customer viewCust(String email)
	{
		Customer e=new Customer();
		try {	
			System.out.println(email);
		    Connection con=new ProductDao().start();
		    PreparedStatement ps=con.prepareStatement("select * from customer where email=?");
			ps.setString(1,email);
		    ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
			
			e.setName(rs.getString("name"));
			e.setAddress(rs.getString("address"));
			e.setEmail(rs.getString("email"));
			e.setMobile(rs.getLong("mobile"));
			e.setPassword(rs.getString("password"));
			
		}
		System.out.println(e);
			con.close();
			  }catch(SQLException  ex)
			{
				System.err.println(ex);
			}
		
		return e;
		}

	public int editProfile(String email1,String name,String address,String email,String mobile,String pwd) {
		int x=0;
		Customer e=new Customer();
		try {	
			System.out.println(email1);
			System.out.println(name);
			
		    Connection con=new ProductDao().start();
		    PreparedStatement ps=con.prepareStatement("update customer set name=?,address=?,email=?,mobile=?,password=? where email=?");
			ps.setString(1,name);
			ps.setString(2,address);
			ps.setString(3,email);
			ps.setString(4,mobile);
			ps.setString(5,pwd);
			ps.setString(6,email1);
		       
			x=ps.executeUpdate();
		    con.close();
			  }catch(SQLException  ex)
			{
				System.err.println(ex);
			}
		
		return x;
	}

	
}
