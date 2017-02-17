package fr.univbrest.dosi.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class User {

	private String username;
	private String pwd;
	private final List<String> roles;
	
	public User(){
		roles = new ArrayList<String>();
	}
	
	public List<String> getRoles(){
		return roles;
	}
	
	public User(final String username, final String pwd, final List<String> roles){
		this.username = username;
		this.pwd = pwd;
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	
	
	
	
}
