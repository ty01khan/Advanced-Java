package com.patternfly.web.operation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SubController {
	@RequestMapping("sub")
	public ModelAndView sub(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
		ModelAndView mv = new ModelAndView();
		int res = num1 - num2;
		mv.addObject("result", res);
		mv.setViewName("sub.jsp");
		
		return mv;
	}
}
