package com.patternfly.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SubController {
	@RequestMapping("subtract") 
	public ModelAndView multiply(@RequestParam("t1") int num1, @RequestParam("t2") int num2) {
		ModelAndView mv = new ModelAndView();
		int k = num1-num2;
		mv.addObject("answer", k);
		mv.addObject("result", "laato");
		mv.setViewName("result.jsp");
		
		return mv;
	}
}