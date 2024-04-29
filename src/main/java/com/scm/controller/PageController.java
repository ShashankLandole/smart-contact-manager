package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
}
