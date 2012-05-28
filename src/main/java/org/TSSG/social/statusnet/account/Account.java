package org.TSSG.social.statusnet.account;

/**
 * 
 * @author Michael Treyvaud michael.treyvaud@gmail.com
 * 
 * Class used to stored users who access the main site contents
 *
 */


public class Account {
	private String password;
	private String userName;
	
	public Account(String userName, String password){
		this.userName = userName;
		this.password = password;
	}
	
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
}
