package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("/sbb")
	@ResponseBody
	public String index() {
		return "index";
	}
//	/question/list URL페이지를 리다이렉트 하라는 명령어다.
//	redirect:/URL : URL로 리다이렉트(리다이렉는 완전히 새로운 URL로의 요청이 됨)
//	forward:/URL : URL로 포워드 (포워드는 기존 요청 값들이 유지된 상태로 URL전환됨)
	@RequestMapping("/")
	public String root() {
		return "redirect:/question/list";
	}
}
