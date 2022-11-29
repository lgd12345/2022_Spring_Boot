package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;

@Controller
public class QuestionConteroller {
	
	@Autowired
	private QuestionRepository qRepo;

// 리턴의 글자 나오게 하기 : @ResponseBody
//	@ResponseBody
	
//	타임리프 쓴 탬플릿(templates) 사용할 것 임
	@RequestMapping("/question/list")
	public String list(Model model) {
		List<Question> all = this.qRepo.findAll();
		model.addAttribute("qList",all);
		return "question_list";
	}
	
	
}
