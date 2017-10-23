//package declaration
package customerbean;
//class declaration 
public class Customer {

//instance variable
	private String name;
	private String address;
	private String email;
	private long mobile;
	private String password;
	private String ipadd;
//default constructor
public Customer()
{
	}

//parameterized constructor

public Customer(String ipadd,String name, String address, String email,long mobile, String password) {
	super();
	
	this.name = name;
	this.address = address;
	this.email = email;
	this.mobile = mobile;
    this.password = password;
    this.ipadd = ipadd;
	
}
//setter and getter method of all the instance variable
public String getIpadd() {
	return ipadd;
}



public void setIpadd(String ipadd) {
	this.ipadd = ipadd;
}



public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getMobile() {
	return mobile;
}
public void setMobile(long mobile) {
	this.mobile = mobile;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
