package com.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public String home(Model m) {
		String str = ""
		m.addAttribute("name", "Talha Yaseen");
		return "home";
	}
}
