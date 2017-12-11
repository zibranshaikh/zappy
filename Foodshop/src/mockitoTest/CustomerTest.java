package mockitoTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import bean.Product;
import customerbean.Customer;
import customerdao.CLoginDao;
import customerdao.CustomerDao;

public class CustomerTest {

	 CLoginDao ld;
	 CustomerDao cd;
		
	@Before
	public void setUp()
	{
		
		ld=mock(CLoginDao.class);
		cd=mock(CustomerDao.class);
	}

	@Test
	public void login()
	{
		when(ld.check("zibranshaikh81@gmail.com", "9300")).thenReturn(1);
	    Assert.assertEquals(ld.check("zibranshaikh81@gmail.com", "9300"), 1);
	}
	@Test
	public void insertCust()
	{
		Customer c=new Customer();
		    c.setIpadd("192.168.2.109");
            c.setName("zibran");
			c.setAddress("indore");
			c.setEmail("zibranshaikh81@gmail.com");
			c.setMobile(909858796);
			c.setPassword("9300");
		when(cd.insertCust(c)).thenReturn(1);
	    Assert.assertEquals(cd.insertCust(c), 1);
	}
	
	
	@Test
	public void viewCust()
	{
	//ArrayList<Customer> list=new ArrayList<>();
		when(cd.viewCust()).thenReturn(new ArrayList<Customer>() );
	    Assert.assertEquals(cd.viewCust(),new ArrayList<Customer>() );
	}

	@Test
	public void viewProfileUpdate()
	{
		
		String email="zibranshaikh81@gmail.com";
		when(cd.viewProfileUpdate(email)).thenReturn(new Customer());
	    Assert.assertEquals(cd.viewProfileUpdate(email),new Customer());
	}

	@Test
	public void viewCust2()
	{
		Customer c=new Customer();
		
		String email="zibranshaikh81@gmail.com";
		c.setEmail(email);
		when(cd.viewCust(email)).thenReturn(c);
	    Assert.assertEquals(cd.viewCust(email),c);
	}

	

}
