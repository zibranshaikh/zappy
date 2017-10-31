package customerdao;

    import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Product;
import customerbean.Customer;
import dao.ProductDao;

public class OrderDao {

      //execution come from buy product controller
		public int buyProduct(String email,String ipadd,String pin,String pmode)
		{   
			//connection establishment
			Connection con=new LoginDao().start();//return the connection object
			int y=0,x=0,z=0;
			try {	
			    //prepare the statement
				//create sql query
			    PreparedStatement ps=con.prepareStatement("select pid,pname,details,price,image,quantity,tamount from cart where ipaddress=?");
				//set the placeholder value
			    ps.setString(1,ipadd);
							//execute statement
			    ResultSet rs= ps.executeQuery();//return the data and set it to the result set reference
			    Statement st=con.createStatement();
				
			    ResultSet rss=st.executeQuery("select max(oid) from order1");
				int oid=1;
				if(rss.next())
				 oid=rss.getInt(1)+1;
			while(rs.next())//if data there condition true
			{   
					
				
				//prepare the statement
				//create sql query
			    PreparedStatement ps1=con.prepareStatement("insert into order1 (oid,pid,pname,details,price,image,quantity,tamount,email,pin,pmode) values(?,?,?,?,?,?,?,?,?,?,?)");//placeholder
			  //set the placeholder value
			    
			    ps1.setInt(1,oid);
				ps1.setInt(2,rs.getInt("pid"));
				ps1.setString(3,rs.getString("pname"));
				ps1.setString(4,rs.getString("details"));
				ps1.setString(5,rs.getString("price"));
				ps1.setString(6,rs.getString("image"));
				ps1.setInt(7,rs.getInt("quantity"));
				ps1.setString(8,rs.getString("tamount"));
	            ps1.setString(9,email);	
	            ps1.setString(10,pin);
	            ps1.setString(11,pmode);

	            
	            //prepare the statement
				//create sql query
	           PreparedStatement ps2=con.prepareStatement("delete from cart where ipaddress=?");//placeholder
	           //set the placeholder value	 
	           ps2.setString(1, ipadd);   
	           //set the transaction for insert in one table and delete in another
//this will execute as either both execute or no one execute...
	           con.setAutoCommit(false);
	           //execute statement
			   	 y=ps1.executeUpdate();//return integer no. of rows affected
		   	     z=ps2.executeUpdate();//return integer no. of rows affected
		   	     con.commit();//commit the transaction
		   	     
			}    

			       }catch(Exception ex)//exception handling
				     {
				   	  System.out.println(ex);//exception print detail
				     }
			
			System.out.println("y ="+y+"z="+z);
			if(y!=0&&z!=0)//if both true then assign value to x
			{
				x=1;
			}
			else if(y!=0&&z==0)//if condition true assign value to x
			{
				x=1;
						
			}
			   return x;//return the integer value
			   //execution go to buy product controller

		}

		//execution come from show order controller
		public ArrayList<Product> showOrder(String email)
		{  
			//creation of arraylist
			ArrayList<Product> list=new ArrayList<>();
			try {	
				//connection establishment
			    Connection con=new LoginDao().start();//return connection object
			    //prepare statement
			    //create sql query
			    PreparedStatement ps=con.prepareStatement("select * from order1 where email=?");
				//set placeholder value
			    ps.setString(1,email);
			    //execute statement
			    ResultSet rs= ps.executeQuery();//return result and assign it to resultset reference
			while(rs.next())
			{
				//object creation of product class
				Product e=new Product();
				//set value to the object product class
			    e.setOrderid(rs.getInt("oid"));
				e.setPid(rs.getInt("pid"));
				e.setPname(rs.getString("pname"));
				e.setDetails(rs.getString("details"));
				e.setPrice(rs.getString("price"));
				e.setImage(rs.getString("image"));
				e.setQuantity(rs.getInt("quantity"));
				e.setTamount(rs.getString("tamount"));
				e.setStatus(rs.getInt("status"));
				e.setEmail(rs.getString("email"));
				
				list.add(e);//add the object in list
				
			}
				con.close();//close the connection
				  }catch(SQLException  ex)//exception handling
				{
					System.err.println(ex);//print exception 
				}
			
			return list;//return the list which contain data
		//execution go to show order controller	
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
			Product e=new Product();
		    //set the value to product class object
			e.setOrderid(rs.getInt("oid"));
		    e.setPid(rs.getInt("pid"));
			e.setPname(rs.getString("pname"));
			e.setDetails(rs.getString("details"));
			e.setPrice(rs.getString("price"));
			e.setImage(rs.getString("image"));
			e.setQuantity(rs.getInt("quantity"));
			e.setTamount(rs.getString("tamount"));
			e.setStatus(rs.getInt("status"));
			e.setEmail(rs.getString("email"));
			
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
			//object creation of product class
			Product e=new Product();
		    //set the value to the object of product class
			
		    e.setOrderid(rs.getInt("oid"));
		    e.setPid(rs.getInt("pid"));
			e.setPname(rs.getString("pname"));
			e.setDetails(rs.getString("details"));
			e.setPrice(rs.getString("price"));
			e.setImage(rs.getString("image"));
			e.setQuantity(rs.getInt("quantity"));
			e.setTamount(rs.getString("tamount"));
			e.setStatus(rs.getInt("status"));
			e.setEmail(rs.getString("email"));
			
			list.add(e);//add the object to the list
			
		}
			con.close();//close connection
			  }catch(SQLException  ex)//exception handling
			{
				System.err.println(ex);//detail print of exception
			}
		
		return list;//return the list
		//execution go to viewphistorycontroller
		}

	//execution come from admin operation controller
	public int dispatchProduct(int pid) {
		int x=0;
		int status=1;
		 try {
			 //connection establishment
			   Connection con=new ProductDao().start();//return the connection reference
			    //prepare the statement
			    //create sql query
			    PreparedStatement ps=con.prepareStatement("update order1 set status=? where pid=?");//placeholder
			   	//set value of placeholder    
			    ps.setInt(1,status);
			   	    ps.setInt(2,pid);
			   	//execute statement
			   	    x=ps.executeUpdate();//return no. of rows affected
			   	    
			     }catch(Exception e)//exception handling
			     {
			   	  System.out.println(e);//print exception
			     }

		
		return x; //return integer value
		//execution go to admin operation controller
	}

	//execution come from show order status controller
	public ArrayList<Product> showOrderStatus(String email) {
		//creation of array list of type product
		ArrayList<Product> list=new ArrayList<>();
		try {	
			//connection establishment
		    Connection con=new LoginDao().start();//return the connection reference
		    //prepare the statement
		    //create sql query
		    PreparedStatement ps=con.prepareStatement("select * from order1 where email=?");
		   	//set value of placeholder    
		    ps.setString(1,email);
		    //execute statement
		    ResultSet rs= ps.executeQuery();//return the data and assign it to the result set reference

			while(rs.next())//condition if data is there
			{
				//object creation of product class
			
		    Product e=new Product();
		
		    //set the value to the object of product class
			e.setOrderid(rs.getInt("oid"));
		    e.setPid(rs.getInt("pid"));
			e.setPname(rs.getString("pname"));
			e.setDetails(rs.getString("details"));
			e.setPrice(rs.getString("price"));
			e.setImage(rs.getString("image"));
			e.setQuantity(rs.getInt("quantity"));
			e.setTamount(rs.getString("tamount"));
			e.setStatus(rs.getInt("status"));
			e.setEmail(rs.getString("email"));
			
			list.add(e);//add the object to the list
		
			}
			con.close();//close connection
			  }catch(SQLException  ex)//exception handling
			{
				System.err.println(ex);//detail print of exception
			}
		
		return list;//return the list
		//execution go to show order status controller
		
	}

	public Product getOid(String email) {

		//execution come from buy product controller
		Product e=new Product();//object creation of product class
		try {	
			//connection establishment
		    Connection con=new ProductDao().start();
		    //prepare the statement
		    //create the sql query
		    PreparedStatement ps=con.prepareStatement("select max(oid) from order1 where email=?");
			//set placeholder value
		    ps.setString(1,email);
		    //execute statement
		    ResultSet rs= ps.executeQuery();//return the value with result set reference
		if(rs.next())//condition check
		{
			//set the value in product class object
			e.setOrderid(rs.getInt(1));
			
		}
		System.out.println(e);
			con.close();//connection close
			  }catch(SQLException  ex)//exception handling
			{
				System.err.println(ex);//print exception detail
			}
		
		return e;//return the product class object
		//execution go  to buyproduct controller
		
	}


}