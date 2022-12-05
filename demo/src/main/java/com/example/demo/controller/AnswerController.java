package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Question;
import com.example.demo.notFound.DataNotFoundException;
import com.example.demo.service.AnswerService;
import com.example.demo.service.QuestionService;

@Controller
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	private QuestionService qService;
	@Autowired
	private AnswerService aService;
	
	
//	content라는 이름으로 변수명을 사용하는 이유는 templates의 textarea의 name의 속성명이 content이기 때문에
//  post 요청만 받아 들일 것이라서 PostMapping
	@PostMapping("/create/{id}")
	public String createAnswer(Model model, @PathVariable("id") Integer id,
								@RequestParam String content) throws DataNotFoundException {
//		답변을 저장하기 위해서는 어떤 질문인지 아는 것이 필요하다.
		Question question = this.qService.getQuestion(id);
		
// 		답변저장 (question랑 연동 시켰다.)
		this.aService.create(question, content);
		
		System.out.println("content+---++----++"+content);
//		String.format를 쓰면 : id가 항상 달라지니깐 %s로 들어가서 값을 넣어주게 되고
//		redirect:/ 할 때 반영된다.(동적인 페이지 이동)
		return String.format("redirect:/question/detail/%s", id);
	}
	
	
}
