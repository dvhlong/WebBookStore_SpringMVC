package org.o7planning.hellospringmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public ModelAndView hello(Model model,HttpSession session,HttpServletRequest request) {
    	if(request.getParameter("but1")!=null) {
	    	session.setAttribute("tam", "Xin chao Session");
	        String[] dsht= {"Nghin","Nhan","thien","Loan"};
	        
	        model.addAttribute("dsht", dsht);
	        model.addAttribute("test", "Passed");
        }
        return new ModelAndView("helloworld");
    }

}