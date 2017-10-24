//package name
package bean;
//class declaration
public class Product {
//instance variable 
private int cartid;
private int orderid;
private int pid;
private String pname;
private String price;
private String weight;
private String details;
private String image;
private int quantity;
private String tamount;
private int status;
private String email;
//default constructor
public Product()
{
	}
//parameterized constructor for all fields
public Product(int cartid, int orderid, int pid, String pname, String price, String weight, String details,
		String image, int quantity, String tamount, int status, String email) {
	super();
	this.cartid = cartid;
	this.orderid = orderid;
	this.pid = pid;
	this.pname = pname;
	this.price = price;
	this.weight = weight;
	this.details = details;
	this.image = image;
	this.quantity = quantity;
	this.tamount = tamount;
	this.status = status;
	this.email = email;
}
//setter getter method of all field
public int getCartid() {
	return cartid;
}
public void setCartid(int cartid) {
	this.cartid = cartid;
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getWeight() {
	return weight;
}
public void setWeight(String weight) {
	this.weight = weight;
}
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getTamount() {
	return tamount;
}
public void setTamount(String tamount) {
	this.tamount = tamount;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


}

