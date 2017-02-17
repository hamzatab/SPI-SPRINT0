package fr.univbrest.dosi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.User;
import fr.univbrest.dosi.business.UserService;
import fr.univbrest.dosi.exceptions.SpiException;



@RestController
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping(value = "/auth", method = RequestMethod.POST, headers = "Accept=application/json")
	public void authentification(final HttpServletRequest request,@RequestBody final User user) {
		final User users = service.authentification(user.getUsername(),user.getPwd());
		
		if (users != null) {
			
			request.getSession().setAttribute("user", users);
		} else {
			
			request.getSession().removeAttribute("user");
			throw new SpiException("impossible de s'authentifier");
		}
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public User users(final HttpServletRequest request) {
		final User user = (User) request.getSession().getAttribute("user");
		return user;
	}

	@RequestMapping(value = "/disconnect",method = RequestMethod.GET)
	public void disconnect(final HttpServletRequest request) {
		request.getSession().removeAttribute("user");
	}
	
	

}