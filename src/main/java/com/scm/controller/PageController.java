package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@GetMapping("/home")
	public String home(Model model) {
							//attribute name, attribute value
		model.addAttribute("name","Shashank landole");
		model.addAttribute("technology","Java");
		model.addAttribute("number","9823321819");
		model.addAttribute("github","https://github.com/ShashankLandole");
		return "home";
	}
	
	@RequestMapping("/about")
	public String aboutPage() {
		return "about";
	}
	
	@RequestMapping("/service")
	public String servicePage() {
		return "service";
	}
	@RequestMapping("/contact")
	public String contactPage() {
		return "contact";
	}
	
	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping("/signup")
	public String registerPage() {
		return "register";
	}
	
}
