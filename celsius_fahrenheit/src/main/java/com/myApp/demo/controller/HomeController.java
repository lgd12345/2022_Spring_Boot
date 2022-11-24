package com.myApp.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/celsius")
	public String celsius() {
		return "celsius";
	}
	@PostMapping("/celsius")
	public String celsius(HttpServletRequest request,Model model) {
		
		System.out.println("**********************"+request.getParameter("Celsius"));
		double fahrenheit = 0;
		double Celsius = 0;
		try {
			Celsius = Double.parseDouble(request.getParameter("Celsius"));
			fahrenheit = (Celsius* 9/5) + 32;
			
			System.out.println("-----"+Double.parseDouble(request.getParameter("Celsius")));
			
		}catch (Exception e) {
			// alert 자바 스크립트
			model.addAttribute("msg", "숫자를 입력해주세요");
		}
			model.addAttribute("Celsius",Celsius);
			model.addAttribute("fahrenheit",fahrenheit);
			
		return "celsius";
	}
	

}
