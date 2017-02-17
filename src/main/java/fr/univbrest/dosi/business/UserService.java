package fr.univbrest.dosi.business;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.User;

@Service
public class UserService {

	private final Map<String, User> mapBouchonUser;
	
	public UserService(){
		this.mapBouchonUser = new HashMap<String, User>();
		this.mapBouchonUser.put("spiAdmin", new User("spiAdmin", "spiAdmin", Arrays.asList("Admin")));
		this.mapBouchonUser.put("spiVisit", new User("spiVisit", "spiVisit", Arrays.asList("visit")));
		this.mapBouchonUser.put("spiProf", new User("spiProf", "spiProf", Arrays.asList("Prof")));
	}
	
	public User authentification(final String login, final String password){
		final User user = this.mapBouchonUser.get(login);
		System.out.println("username : "+this.mapBouchonUser.get(login).getUsername()+ " /pwd : "+this.mapBouchonUser.get(login).getPwd());
		if(user != null && user.getPwd().equals(password)){
		
			return user;
		}
		return null;
	}

} 

