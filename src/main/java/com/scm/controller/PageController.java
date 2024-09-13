package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.scm.entities.User;
import com.scm.form.SignupForm;
import com.scm.services.UserService;

import jakarta.validation.Valid;

@Controller
public class PageController {
	
	@Autowired
	private UserService service;
	
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
	
	@GetMapping("/register")
	public String registerPage(Model model) {
		
		SignupForm  signupForm = new SignupForm();
		
		model.addAttribute("signupForm",signupForm);
		
		return "register";
	}
	
	@PostMapping("/do-register")
	public String processRegistration(@Valid @ModelAttribute SignupForm signupForm, BindingResult bindingResult) {
		
		System.out.println("in processRegistration form");
		System.out.println(signupForm);
		
		if(bindingResult.hasErrors()) {
			return "register";
		}
		
		
		User user = new User();
		
		user.setName(signupForm.getName());
		user.setEmail(signupForm.getEmail());
		user.setPassword(signupForm.getPassword());
		user.setAbout(signupForm.getAbout());
		
		service.saveUser(user);
		
		System.out.println("user saved");
		
		return "redirect:/register";
	}
	
}
