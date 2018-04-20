package com.spring_security.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller  
public class HelloController {

	@RequestMapping("/user")
	public String hello() {
		return "index";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	//custom logout page
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("logout method is called");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
	
	@RequestMapping(value="/author", method=RequestMethod.GET)
	public String checkAuthor() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String role = auth.getAuthorities().toString();
		System.out.println(role);
		if(role.equals("[ROLE_ADMIN]")) {
			return "redirect:/admin";
		}
//		else if(role.equals("[ROLE_USER]")) {
//			return "redirect:/user";
//		}
		return "redirect:/user";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(@RequestParam(name="error", required=false) String error, 
								@RequestParam(name="logout", required=false) String logout) {
		ModelAndView model = new ModelAndView();
		
		String msg = "";
		if(error != null) {
			msg = "User name and password is not matched! Tri Again!!";
		} 
		if(logout != null) {
			msg = "You have successfully logged out!";
		}
		model.addObject("message", msg);
		
		model.setViewName("login");
		return model;
	}
	
	
	
}
