package com.patternfly.web.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping("login")
	public ModelAndView details(@RequestParam("mail") String email, @RequestParam("pass") String pwd) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("email", email);
		mv.addObject("password", pwd);
		mv.setViewName("details.jsp");
		
		return mv;
	}
}
