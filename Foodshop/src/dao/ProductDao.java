//package name
package dao;
//import all the packages which is needed
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import bean.Product;

//class declaration
public class ProductDao {
	//function which return Connection reference which contain the connection to database
	public Connection start()
	{
		Connection con=null;//Connection reference creation
		try {	
			 Class.forName("com.mysql.jdbc.Driver");//Driver load for database
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodshop","root","");//create the connection 
					}catch(ClassNotFoundException | SQLException e)//exception handling
		{
			System.out.println(e);//print the exception detail
		}
		return con;//return the connection reference
	}
	
	public int uploadProduct(String productname,String productprice,String productweight,String productdetails,String filename)
	{ 
		//execution come there from upload product controller
	 int y=0;
		   try {
			   Connection con=new ProductDao().start();//connection establishment by start method of productdao class.. 
			   	  PreparedStatement ps=con.prepareStatement("insert into product(pname,price,weight,details,image) values(?,?,?,?,?)");//statement creation and sql query creation
			   	  //set the placeholder value with parameter  
			   	  ps.setString(1,productname);
			   	    ps.setString(2,productprice);
			   	    ps.setString(3,productweight);
			   	    ps.setString(4,productdetails);
			   	    ps.setString(5,filename);
			   	    
			   	    y=ps.executeUpdate();//execute statement
			   	    
			     }catch(Exception e)
			     {
			   	  System.out.println(e);//print the exception detail
			     }

		   return y;//return integer value 
		   //execution go back to the upload product controller

	}
	public int updateProduct(String productname,String productprice,String productweight,String productdetails)
	{    
		//execution come here from the updatedelcontroller
		int y=0;
		   try {
			   //connection establishment
			   Connection con=new ProductDao().start();
			   //create statement 
			   //prepare the sql statement..
			   	  PreparedStatement ps=con.prepareStatement("update product set pname=?,price=?,weight=?,details=? where pname=?");//placeholder
			   	  //  set the placeholder values
			   	  ps.setString(1,productname);
			   	    ps.setString(2,productprice);
			   	    ps.setString(3,productweight);
			   	    ps.setString(4,productdetails);
			   	    ps.setString(5,productname);
			   	//execute statement
				   	    y=ps.executeUpdate();//return the integer value number of rows affected
			   	    
			     }catch(Exception e)//exception handling
			     {
			   	  System.out.println(e);//print the exception detail
			     }

		   return y;//return the integer value
		   // execution go to update del controller
	}
	
	//execution come from viewcustproductcontroller to there...
	//one more execution come to there for view the product to admin 
	public ArrayList<Product> viewProduct()//this method return the arraylist which only contain the product class object
	{     
		//list creation by arraylist class which is generic based which contain the product class type object..
		ArrayList<Product> list=new ArrayList<>();//object creation of Arraylist class..
		try {	//for exception handling to monitor the statement which come under exception..
			//Connection establishment to the database.. 
		    Connection con=new LoginDao().start();//this function defined in LoginDao class which gives the connection to database..
		    PreparedStatement ps=con.prepareStatement("select * from product");//Statement creation and sql..
			ResultSet rs= ps.executeQuery();//execution of statemnt and this method returns the data.. which is fatched by sql statement from data base
		while(rs.next())//check the condition...
		{
			Product e=new Product();//object creation of product class which is also called as bean class..
			e.setPid(rs.getInt("pid"));//by product class object its setter method is called to set value and the value come by the resultset reference..
			e.setPname(rs.getString("pname"));
			e.setPrice(rs.getString("price"));
			e.setWeight(rs.getString("weight"));
			e.setDetails(rs.getString("details"));
			e.setImage(rs.getString("image"));
			list.add(e);//all the value set in the object and that object is add to list..
		}
			con.close();//Database Connection is close here
			  }catch(SQLException  ex)//exception handling
			{
				System.err.println(ex);//printing of exception description
			}
		
		return list;//return the list which contain the data..
		//execution return to the view cust product controller
		//after come there from view product to admin it will go back to the view product controller which shown to the admin..
		
		}

	public Product viewProductUpdate(int pid)
	{  
		//execution come here from updatedelproduct
		Product e=new Product();//object creation of product class
		try {	
			System.out.println(pid);
		    Connection con=new ProductDao().start();//connection establishment method return connection reference 
		    //statement creation and sql query creation..
		    PreparedStatement ps=con.prepareStatement("select * from product where pid=?");
			ps.setInt(1,pid);//set the value of placeholder
		    ResultSet rs= ps.executeQuery();//execute the statement..
		while(rs.next())//condition check
		{
			//fetch the data with resultset reference and set the value of each field with object of product class
			e.setPid(rs.getInt("pid"));
			e.setPname(rs.getString("pname"));
			e.setPrice(rs.getString("price"));
			e.setWeight(rs.getString("weight"));
			e.setDetails(rs.getString("details"));
			e.setImage(rs.getString("image"));
			
		}
		
			con.close();//connection close
			  }catch(SQLException  ex)
			{
				System.err.println(ex);//print the detail of exception
			}
		
		return e;//return the object of product class
		//execution go to the update delete controller
		}

	public int deleteProduct(int pid)
	{    
		//execution come here from the updatedeleteproduct controller for delete or remove the product from cart
		int y=0;
		   try {
			   Connection con=new ProductDao().start();//connection establishment
			   //statement creation and and sql statement prepration
			   	  PreparedStatement ps=con.prepareStatement("delete from product where pid=?");//placeholder
			   	    ps.setInt(1,pid);//set the parameter for the placeholder
			   	    
			   	    y=ps.executeUpdate();//execute the statement and it will return no. of rows affected
			   	    //integer value
			     }catch(Exception e)
			     {
			   	  System.out.println(e);//print the exception
			     }

		   return y;//return the integer value
		   //execution go to the update delete product controller 
	}
	public int addToCart(int pid,String ipadd,int quantity,double tamount)
	{
		
		//execution come there from the Add to cart controller 
	
		int y=0;//initialize a variable
		Product e=new Product();//object creation of product class which is bean class
		try {	
			//connection establishment to database
		    Connection con=new ProductDao().start();//returns connection reference
		    System.out.println("pid in add to cart dao "+pid);
			PreparedStatement ps=con.prepareStatement("select * from product where pid=?");//statement creation
			ps.setInt(1,pid);//set the parameter to the sql query
		    ResultSet rs= ps.executeQuery();//execute the statement
		while(rs.next())
		{
			//fetch data from product table by column name with result reference
			e.setPid(rs.getInt("pid"));
			e.setPname(rs.getString("pname"));
			e.setPrice(rs.getString("price"));
			e.setWeight(rs.getString("weight"));
			e.setDetails(rs.getString("details"));
			e.setImage(rs.getString("image"));
			
		}
		System.out.println(e);
			con.close();//connection close
			  }catch(SQLException  ex)
			{
				System.err.println(ex);//exception description print
			}
		//now it will fetch the existing product detail
		int pid1=0;
		String ipadd1="";
		try {   
			
			//connection establishment
			   Connection con=new ProductDao().start();
			   //create the statement and sql query	  
		
			   PreparedStatement ps1=con.prepareStatement("select pid,ipaddress from cart where pid=?");//statement creation
				ps1.setInt(1,pid);//set the parameter to the sql query
			
			    ResultSet rs= ps1.executeQuery();//execute the statement
				while(rs.next())
				{
					pid1=rs.getInt("pid");
					ipadd1=rs.getString("ipaddress");
					
				}
			
		 		if(pid1==pid && ipadd1.equals(ipadd))
				{
				      //prepare the statement
		              //create the sql query
			       	   PreparedStatement ps=con.prepareStatement("update cart set quantity=?,tamount=? where pid=? and ipaddress=?");//placeholder
					   //set the value of placeholder	
			       	   ps.setInt(1,quantity);
			       	   ps.setDouble(2,tamount);
			       	   ps.setInt(3,pid1);
			       	   ps.setString(4,ipadd);

			       	   //execute statement
					   y=ps.executeUpdate();//return the no. of rows affected
				
				}
				else
				{
			   PreparedStatement ps=con.prepareStatement("insert into cart(pid,ipaddress,pname,weight,quantity,details,image,price,tamount) values(?,?,?,?,?,?,?,?,?)");//statement for insert the product in cart table
			   	
			   	  //set the value of the placeholder by setter method
			      ps.setInt(1,e.getPid());
			   	   ps.setString(2,ipadd);
		   	        ps.setString(3,e.getPname());
		   	        ps.setString(4,e.getWeight());
				    ps.setInt(5,quantity);
				    ps.setString(6,e.getDetails());
				    ps.setString(7,e.getImage());
					ps.setString(8,e.getPrice());
			   	    ps.setDouble(9,tamount);
			    	   		    
			   	    y=ps.executeUpdate();//execute the statement
			   	    
				}
		       }catch(Exception ex)//exception handling
			     {
			   	  System.out.println(ex);//exception detail print
			     }
		
		
		   return y;//return the integer value
//execution go back to add to cart contoller
	}

	public ArrayList<Product> showCart(String ipadd)
	{
		//execution come from show cart contoller to here
		//arraylist creation 
		ArrayList<Product> list=new ArrayList<>();
		try {	
		    Connection con=new ProductDao().start();//connection establishment
		    //create statement
		    //prepare sql
		    PreparedStatement ps=con.prepareStatement("select * from cart where ipaddress=?");
			ps.setString(1, ipadd);//set the placeholder value
		    ResultSet rs= ps.executeQuery();//execute statement which return the value to resultset reference 
		while(rs.next())//condition check
		{
			Product e=new Product();//object creation of product class
			//set the value in the product class object
			e.setCartid(rs.getInt("cid"));
			e.setPid(rs.getInt("pid"));
			e.setPname(rs.getString("pname"));
			e.setWeight(rs.getString("weight"));
			e.setQuantity(rs.getInt("quantity"));
			e.setDetails(rs.getString("details"));
			e.setImage(rs.getString("image"));
			e.setPrice(rs.getString("price"));
			e.setTamount(rs.getString("tamount"));
			list.add(e);//add the object in arraylist
		}
			con.close();//close the connection
			  }catch(SQLException  ex)//exception handle
			{
				System.err.println(ex);//print the exception detail
			}
		
		return list;//return the list which contain all the product 
	//execution go to showcart controller	
	}
	
	public int removeProduct(int cid,String ipadd)
	{    
		//execution come from remove product controller
		int y=0;
		   try {
			   Connection con=new ProductDao().start();//connection establishment
			   //prepare statement
			   //create sql query
			   	  PreparedStatement ps=con.prepareStatement("delete from cart where cid=? and ipaddress=?");//placeholder
			   	  //set the placeholder value  
			   	  ps.setInt(1,cid);
			   	    ps.setString(2,ipadd);
			   	    //execute the statement
			   	    y=ps.executeUpdate();//return the integer value no. of rows affected
			   	    
			     }catch(Exception e)//exception handling
			     {
			   	  System.out.println(e);//print exception detail
			     }

		   return y;//return the integer value
	//execution go to the remove product controller
	}

	public int countProduct(String ipadd)
	{
		//execution come from show cart jsp 
		int e=0;
		try {	
			//connection establishment
		    Connection con=new ProductDao().start();
		    //prepare statement
		    //create sql query
		    PreparedStatement ps=con.prepareStatement("select count(*) from cart where ipaddress=?");
			//set the placeholder value
		    ps.setString(1,ipadd);
		    //execute statement
		    ResultSet rs= ps.executeQuery();//method return the value with resultset reference
		while(rs.next())//condition check
		{
			e=rs.getInt(1);//return the integer value set it to variable
		}
		System.out.println(e);
			con.close();//close connection
			  }catch(SQLException  ex)//exception handling
			{
				System.err.println(ex);//print exception detail
			}
		
		return e;//return the integer value
		//execution go to show cart jsp 
		}

	public int dispatchProduct(int oid, int status) {
	//execution come from admin operation controller
		int y=0;
		   try {
			   //connection establishment
			   Connection con=new ProductDao().start();
			   //prepare statement
			   //create sql statement 
			   PreparedStatement ps1=con.prepareStatement("select email from order1 where oid=?");
			   ps1.setInt(1,oid);
			   ResultSet rs=ps1.executeQuery();
			   String email=null;
			   if(rs.next())
			   {
				   email=rs.getString("email");
			   }
				   
			   	  PreparedStatement ps=con.prepareStatement("update order1 set status=? where oid=? and email=?");//placeholder
			   	  //set the placeholder value  
			   	  ps.setInt(1,status);
			   	  ps.setInt(2,oid);
			   	  ps.setString(3,email);
			   	  
			   	    //execute statement
				    y=ps.executeUpdate();//return the integer value no. of rows affected
				   	   
		         }catch(Exception e)//exception handling
			     {
			   	  System.out.println(e);//print exception detail
			     }

		   return y;//return the integer value
	//execution go to view todays order controller
	}

	public int cancelProduct(int oid, int status) {
		//execution come from admin operation controller
		int y=0;
		   try {
			   //connection establishment
			   Connection con=new ProductDao().start();
			   //prepare the statement
               //create the sql query
			   PreparedStatement ps1=con.prepareStatement("select email from order1 where oid=?");
			   ps1.setInt(1,oid);
			   ResultSet rs=ps1.executeQuery();
			   String email=null;
			   if(rs.next())
			   {
				   email=rs.getString("email");
			   }
	  PreparedStatement ps=con.prepareStatement("update order1 set status=? where oid=? and email=?");//placeholder
			   	  //set the placeholder value  
			   	  ps.setInt(1,status);
			   	   ps.setInt(2,oid);
			   	   ps.setString(3,email); 
			   	   //execute statement
				    y=ps.executeUpdate();//return the no. of rows affected 
				   	   
		         }catch(Exception e)//exception handling
			     {
			   	  System.out.println(e);//print the exception detail
			     }

		   return y;//return the integer value
		   //execution go to admin operation controller
		}
	public Product viewProductDetail(int pid)
	{
		//execution come from show product detail jsp
		Product e=new Product();//object creation of product class
		try {	
			System.out.println("pid in Product detail "+pid);
			//connection establishment
		    Connection con=new ProductDao().start();
		    //prepare the statement
		    //create the sql query
		    PreparedStatement ps=con.prepareStatement("select * from product where pid=?");
			//set placeholder value
		    ps.setInt(1,pid);
		    //execute statement
		    ResultSet rs= ps.executeQuery();//return the value with result set reference
		while(rs.next())//condition check
		{
			//set the value in product class object
			e.setPid(rs.getInt("pid"));
			e.setPname(rs.getString("pname"));
			e.setPrice(rs.getString("price"));
			e.setWeight(rs.getString("weight"));
			e.setDetails(rs.getString("details"));
			e.setImage(rs.getString("image"));
			
		}
		System.out.println(e);
			con.close();//connection close
			  }catch(SQLException  ex)//exception handling
			{
				System.err.println(ex);//print exception detail
			}
		
		return e;//return the product class object
		//execution go  to show product detail jsp
		}

	public int updateImage(int pid, String image) {

		//execution come from update image controller
		int y=0;
		   try {
			   System.out.println("pid in update image dao "+pid+"  and image "+image);
			 //connection establishment
			   Connection con=new ProductDao().start();
			   //create statement
			   //create sql statement
			   	  PreparedStatement ps=con.prepareStatement("update product set image=? where pid=?");//placeholder
			   	//set the placeholder value
			   	  ps.setString(1,image);
			   	ps.setInt(2,pid);
			   	//execute statement
			   	        y=ps.executeUpdate();//return the integer value no. of rows affected
			   	    
			     }catch(Exception e)//exception handling
			     {
			   	  System.out.println(e);//print exception detail
			     }
       System.out.println("y in update image dao "+y);
		   return y;//return integer value
		   
		   //execution go to update image controller
	
	}

	public int updateCart(String u,String ipadd) {
		//execution come from customer login controller
		//after successful login the cart now maintain by userid of customer
		int y=0;
		   try {
              System.out.println("user in update cart dao "+u);
			  //connection establishment
              Connection con=new ProductDao().start();
              //prepare the statement
              //create the sql query
	       	   PreparedStatement ps=con.prepareStatement("update cart set ipaddress=? where ipaddress=?");//placeholder
			   //set the value of placeholder	
	       	   ps.setString(1,u);
	           ps.setString(2,ipadd);
	       	   
	       	   //execute statement
			   	        y=ps.executeUpdate();//return the no. of rows affected
			   	    
			     }catch(Exception e)//exception handling
			     {
			   	  System.out.println(e);//excpetion detail print
			     }
    System.out.println("y in update cart dao "+y);
		   return y;//integer value return
		   //execution go to the customer login controller
		
	}

	public int checkEProduct(String ipadd,String email) {

		//execution come from customer login controller
				//after successful login the cart now maintain by userid of customer
				int y=0;
				   try {
		              //connection establishment
		              Connection con=new ProductDao().start();
		              //prepare the statement
		              //create the sql query
			       	   PreparedStatement ps=con.prepareStatement("select pid from cart where ipaddress=?");//placeholder
					   //set the value of placeholder	
			       	   ps.setString(1,email);
			       	   //execute statement
			       	 PreparedStatement ps1=con.prepareStatement("select pid from cart where ipaddress=?");//placeholder
					   //set the value of placeholder	
			       	   ps1.setString(1,ipadd);
			       	   //execute statement
			       	   ResultSet rs =ps.executeQuery();
			       	   
			           int epid=0;
			           int ipid=0;
			       	   while(rs.next())
					   	    {
					   	    	epid=rs.getInt("pid");
					   	    	
					   	    	ResultSet rs1 =ps1.executeQuery();
					   	    	while(rs1.next())
						   	    {
					   	    	
						   	    	ipid=rs1.getInt("pid");
		         	if(epid==ipid)
						       	{
						       	//prepare the statement
						        //create the sql query
			   	   PreparedStatement ps3=con.prepareStatement("delete from cart where ipaddress=? and pid=?");//placeholder
					   //set the value of placeholder	
				    	   ps3.setString(1,email);
				    	   ps3.setInt(2,epid);
							       	   //execute statement
					  y=ps3.executeUpdate();//return the no. of rows affected
									        		
						       	}
						   	    }
					   	    }
			       	     }catch(Exception e)//exception handling
					     {
					   	  System.out.println(e);//excpetion detail print
					     }
		    System.out.println("y in delete product cart dao "+y);
				   return y;//integer value return
				   //execution go to the customer login controller
					}

	public Product getCustO(int oid) {

		//execution come from show product detail jsp
		Product e=new Product();//object creation of product class
		try {	
			//connection establishment
		    Connection con=new ProductDao().start();
		    //prepare the statement
		    //create the sql query
		    PreparedStatement ps=con.prepareStatement("select email from order1 where oid=?");
			//set placeholder value
		    ps.setInt(1,oid);
		    //execute statement
		    ResultSet rs= ps.executeQuery();//return the value with result set reference
		if(rs.next())//condition check
		{
			//set the value in product class object
			e.setEmail(rs.getString("email"));
			
		}
		System.out.println(e);
			con.close();//connection close
			  }catch(SQLException  ex)//exception handling
			{
				System.err.println(ex);//print exception detail
			}
		
		return e;//return the product class object
		//execution go  to show product detail jsp
		
	}

}
