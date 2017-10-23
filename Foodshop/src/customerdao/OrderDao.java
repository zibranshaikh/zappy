package customerdao;

    import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;

import bean.Product;
import customerbean.Customer;
import dao.ProductDao;

public class OrderDao {

      //execution come from buy product controller
		public int buyProduct(String email,String ipadd,String pin,String pmode)
		{   
			Connection con=new LoginDao().start();
			int y=0,x=0,z=0;
			try {	
			    
			    PreparedStatement ps=con.prepareStatement("select pid,pname,details,price,image,quantity,tamount from cart where ipaddress=?");
				ps.setString(1,ipadd);
							
			    ResultSet rs= ps.executeQuery();
			     
			while(rs.next())
			{   
				PreparedStatement ps1=con.prepareStatement("insert into order1 (pid,pname,details,price,image,quantity,tamount,email,pin,pmode) values(?,?,?,?,?,?,?,?,?,?)");//placeholder
					
				ps1.setInt(1,rs.getInt("pid"));
				ps1.setString(2,rs.getString("pname"));
				ps1.setString(3,rs.getString("details"));
				ps1.setString(4,rs.getString("price"));
				ps1.setString(5,rs.getString("image"));
				ps1.setInt(6,rs.getInt("quantity"));
				ps1.setString(7,rs.getString("tamount"));
	            ps1.setString(8,email);	
	            ps1.setString(9,pin);
	            ps1.setString(10,pmode);
	            

	            PreparedStatement ps2=con.prepareStatement("delete from cart where ipaddress=?");//placeholder
			   	 ps2.setString(1, ipadd);   
		   	   con.setAutoCommit(false);
			   	 y=ps1.executeUpdate();
		   	     z=ps2.executeUpdate();
		   	     con.commit();
		   	     
			}    

			       }catch(Exception ex)
				     {
				   	  System.out.println(ex);
				     }
			
			System.out.println("y ="+y+"z="+z);
			if(y!=0&&z!=0)
			{
				x=1;
			}
			else if(y!=0&&z==0)
			{
				x=1;
						
			}
			   return x;

		}

		public ArrayList<Product> showOrder(String email)
		{  
			ArrayList<Product> list=new ArrayList<>();
			try {	
			    Connection con=new LoginDao().start();
			    PreparedStatement ps=con.prepareStatement("select * from order1 where email=?");
				ps.setString(1,email);
			    ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				Customer c=new Customer();
			    Product e=new Product();
				e.setPid(rs.getInt("pid"));
				e.setPname(rs.getString("pname"));
				e.setDetails(rs.getString("details"));
				e.setPrice(rs.getString("price"));
				e.setImage(rs.getString("image"));
				e.setQuantity(rs.getInt("quantity"));
				e.setTamount(rs.getString("tamount"));
				e.setStatus(rs.getInt("status"));
				c.setEmail(rs.getString("email"));
				
				list.add(e);
				//list.add(p);
			}
				con.close();
				  }catch(SQLException  ex)
				{
					System.err.println(ex);
				}
			
			return list;
			}
		//execution come from view today order controller
	public ArrayList<Product>	showTodayOrder(int status)
		{  
		//array list creation of type product
		ArrayList<Product> list=new ArrayList<>();
		try {	
			//connection establishment
		    Connection con=new LoginDao().start();//return the connection reference
		    //prepare the statement
		    //create the sql query
		    PreparedStatement ps=con.prepareStatement("select * from order1 where status=?");
			ps.setInt(1,status);//set the value of placeholder
			//execute statement
		    ResultSet rs= ps.executeQuery();//return the result and assign it to the result set reference 
		while(rs.next())//if data is there condition true
		{
			//object creation of customer class
			Customer c=new Customer();
			//object creation of product class 
		    Product e=new Product();
		    //set the value to product class object
			e.setPid(rs.getInt("pid"));
			e.setPname(rs.getString("pname"));
			e.setDetails(rs.getString("details"));
			e.setPrice(rs.getString("price"));
			e.setImage(rs.getString("image"));
			e.setQuantity(rs.getInt("quantity"));
			e.setTamount(rs.getString("tamount"));
			e.setStatus(rs.getInt("status"));
			//set the value to customer class object
			c.setEmail(rs.getString("email"));
			
			list.add(e);//add the object in list
			//list.add(p);
		}
		
			con.close();//close connection
			  }catch(SQLException  ex)//exception handling
			{
				System.err.println(ex);//print exception detail
			}
		
		return list;//return array list which contain data
	//execution go to view today order controller
		}

	//execution come here from viewphistorycontroller
	public ArrayList<Product> showOrderHistory()
	{
		//creation of array list of type product
		ArrayList<Product> list=new ArrayList<>();
		try {	
			//connection establishment
		    Connection con=new LoginDao().start();//return the connection reference
		    //prepare the statement
		    //create sql query
		    PreparedStatement ps=con.prepareStatement("select * from order1");
		    //execute statement
		    ResultSet rs= ps.executeQuery();//return the data and assign it to the result set reference
		while(rs.next())//condition if data is there
		{
			//object creation of customer class
			Customer c=new Customer();
			//object creation of product class
		    Product e=new Product();
		    //set the value to the object of product class
			e.setPid(rs.getInt("pid"));
			e.setPname(rs.getString("pname"));
			e.setDetails(rs.getString("details"));
			e.setPrice(rs.getString("price"));
			e.setImage(rs.getString("image"));
			e.setQuantity(rs.getInt("quantity"));
			e.setTamount(rs.getString("tamount"));
			e.setStatus(rs.getInt("status"));
			//set the value to the object of customer class
			c.setEmail(rs.getString("email"));
			
			list.add(e);//add the object to the list
			//list.add(p);
		}
			con.close();//close connection
			  }catch(SQLException  ex)//exception handling
			{
				System.err.println(ex);//detail print of exception
			}
		
		return list;//return the list
		//execution go to viewphistorycontroller
		}

	public int dispatchProduct(int pid) {
		int x=0;
		int status=1;
		 try {
			   Connection con=new ProductDao().start();
			PreparedStatement ps=con.prepareStatement("update order1 set status=? where pid=?");//placeholder
			   	    ps.setInt(1,status);
			   	    ps.setInt(2,pid);
			   	    x=ps.executeUpdate();
			   	    
			     }catch(Exception e)
			     {
			   	  System.out.println(e);
			     }

		
		return x; 
	}

	public ArrayList<Product> showOrderStatus(String email) {

		ArrayList<Product> list=new ArrayList<>();
		try {	
		    Connection con=new LoginDao().start();
		    PreparedStatement ps=con.prepareStatement("select * from order1 where email=?");
		    ps.setString(1,email);
		    ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
			Customer c=new Customer();
		    Product e=new Product();
			e.setPid(rs.getInt("pid"));
			e.setPname(rs.getString("pname"));
			e.setDetails(rs.getString("details"));
			e.setPrice(rs.getString("price"));
			e.setImage(rs.getString("image"));
			e.setQuantity(rs.getInt("quantity"));
			e.setTamount(rs.getString("tamount"));
			e.setStatus(rs.getInt("status"));
			c.setEmail(rs.getString("email"));
			
			list.add(e);
			//list.add(p);
		}
			con.close();
			  }catch(SQLException  ex)
			{
				System.err.println(ex);
			}
		
		return list;
	
	}
	
}
