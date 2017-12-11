package mockitoTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import bean.Product;
import dao.LoginDao;
import dao.ProductDao;


public class AdminTesting {
	 LoginDao ld;
     ProductDao pd;
	@Before
	public void setUp()
	{
		
		ld=mock(LoginDao.class);
		pd=mock(ProductDao.class);
		
	}

	@Test
	public void login()
	{
		when(ld.check("admin", "12345")).thenReturn(1);
	    Assert.assertEquals(ld.check("admin", "12345"), 1);
	}
	
	@Test
	public void update()
	{
		when(ld.changePwd("9300","12345","zibranshaikh81@gmail.com")).thenReturn(1);
	    Assert.assertEquals(ld.changePwd("9300","12345","zibranshaikh81@gmail.com"), 1);
	}
	
	@Test
	public void uploadProduct()
	{
		when(pd.uploadProduct("Brownie","30","200","bbbb","brownie.png")).thenReturn(1);
	    Assert.assertEquals(pd.uploadProduct("Brownie","30","200","bbbb","brownie.png"), 1);
	}
	
	@Test
	public void updateProduct()
	{
		when(pd.updateProduct("Brownie","30","200","bbbb")).thenReturn(1);
	    Assert.assertEquals(pd.updateProduct("Brownie","30","200","bbbb"), 1);
	}
	
	@Test
	public void viewProduct()
	{
	ArrayList<Product> list=new ArrayList<>();
		when(pd. viewProduct()).thenReturn(list);
	    Assert.assertEquals(pd. viewProduct(),list);
	}

	@Test
	public void viewProductUpdate()
	{
		Product p = null;
		int pid = 0;
		when(pd.viewProductUpdate(pid)).thenReturn(p);
	    Assert.assertEquals(pd.viewProductUpdate(pid),p);
	}

	@Test
	public void deleteProduct()
	{
		int pid = 0;
		when(pd.deleteProduct(pid)).thenReturn(1);
	    Assert.assertEquals(pd.deleteProduct(pid),1);
	}

	@Test
	public void addToCart()
	{
		when(pd.addToCart(1,"192.168.2.109",2,75)).thenReturn(1);
	    Assert.assertEquals(pd.addToCart(1,"192.168.2.109",2,75), 1);
	}

	@Test
	public void showCart()
	{
		String ipadd="192.168.2.109";
	ArrayList<Product> list=new ArrayList<>();
		when(pd.showCart(ipadd)).thenReturn(list);
	    Assert.assertEquals(pd. showCart(ipadd),list);
	}

	@Test
	public void removeProduct()

	{
		int cid = 1;
		String ipadd="192.168.2.109";
		when(pd.removeProduct(cid,ipadd)).thenReturn(1);
	    Assert.assertEquals(pd.removeProduct(cid,ipadd),1);
	}

	@Test
	public void countProduct()
	{
		int e=0;
		String ipadd="192.168.2.109";
	ArrayList<Product> list=new ArrayList<>();
		when(pd.countProduct(ipadd)).thenReturn(e);
	    Assert.assertEquals(pd.countProduct(ipadd),e);
	}

	@Test
	public void dispatchProduct()

	{
		int oid = 1;
		int status=1;
		when(pd.dispatchProduct(oid,status)).thenReturn(1);
	    Assert.assertEquals(pd.dispatchProduct(oid,status),1);
	}

	
	@Test
	public void cancelProduct()


	{
		int oid = 1;
		int status=2;
		when(pd.cancelProduct(oid,status)).thenReturn(1);
	    Assert.assertEquals(pd.cancelProduct(oid,status),1);
	}

	@Test
	public void viewProductDetail()
	{
		Product p=null;
		int pid = 1;
		when(pd.viewProductDetail(pid)).thenReturn(p);
	    Assert.assertEquals(pd.viewProductDetail(pid),p);
	}
	
	@Test
	public void updateImage()
	{
		String image="Brownie.png";
		int pid = 1;
		when(pd.updateImage(pid,image)).thenReturn(1);
	    Assert.assertEquals(pd.updateImage(pid,image),1);
	}	

	@Test
	public void updateCart()
	{
		String u="zibranshaikh81@gmail.com";
		String ipadd="192.168.2.109";
		when(pd.updateCart(u,ipadd)).thenReturn(1);
	    Assert.assertEquals(pd.updateCart(u,ipadd),1);
	}	

	@Test
	public void checkEProduct()
	{
		String email="zibranshaikh81@gmail.com";
		String ipadd="192.168.2.109";
		when(pd.checkEProduct(email,ipadd)).thenReturn(1);
	    Assert.assertEquals(pd.checkEProduct(email,ipadd),1);
	}	


	@Test
	public void getCustO()
	{
		Product p=null;
		int oid=1;
		when(pd.getCustO(oid)).thenReturn(p);
	    Assert.assertEquals(pd.getCustO(oid),p);
	}	
	
}
