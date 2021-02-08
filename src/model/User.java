package model;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fName;
	private String lName;
	private String email;
	private String userName;
	private String pass;
	public User() {
		
	}
	public User(String f,String l,String e,String u,String p) {
		this.fName=f;
		this.lName=l;
		this.email=e;
		this.userName= u;
		this.pass=p;
		
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
//	}
//	public boolean setDiscount(boolean b) {
//		return b;
//	}
//	public int getDiscount() {
//		if(d) {
//			return 20;
//		}
//		else 
//			return 0;
	}
	
	
}
