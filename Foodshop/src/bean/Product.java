//package name
package bean;
//class declaration
public class Product {
//instance variable 
private int pid;
private String pname;
private String price;
private String weight;
private String details;
private String image;
private int quantity;
private String tamount;
private int status;
//default constructor
public Product()
{
	}
//parameterized constructor
public Product(int status) {
	super();
	this.status = status;
}
//setter getter method
public int getStatus() {
	return status;
}

public void setStatus(int i) {
	this.status = i;
}
//parameterized constructor
public Product(int quantity, String tamount) {
	super();
	this.quantity = quantity;
	this.tamount = tamount;
}
//setter getter method
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
//parameterized constructor
public Product(int pid, String pname, String price, String weight, String details, String image) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.price = price;
	this.weight = weight;
	this.details = details;
	this.image = image;
}
//setter getter method
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


}
