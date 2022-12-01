package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Question;
import com.example.demo.notFound.DataNotFoundException;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.service.QuestionService;

@Controller
public class QuestionConteroller {

// 이제는 서비스를 만들어서 사용하겠습니다.
// 보안상 서비스를 사용하지 않고 컨트롤러에서 리포지터리로 데이터베이스에 접근하도록 구현하는 것은 좋지 않습니다.
// 또한 모듈화를 위해서도 서비스가 필요합니다. 서비스는 동일한 기능의 중복구현을 줄일 수 있습니다.

//	@Autowired
//	private QuestionRepository qRepo;
//
//// 리턴의 글자 나오게 하기 : @ResponseBody
////	@ResponseBody
//	
////	타임리프 쓴 탬플릿(templates) 사용할 것 임
//	@RequestMapping("/question/list")
//	public String list(Model model) {
//		List<Question> all = this.qRepo.findAll();
//		model.addAttribute("qList",all);
//		return "question_list";
//	}

//서비스 의존성 주입
	@Autowired
	private QuestionService qService;

//getList메소드 호출	
	@RequestMapping("/question/list")
	public String list(Model model) {
		List<Question> qList = this.qService.getList();
		model.addAttribute("qList", qList);
		return "question_list";
	}

//  경로에서 {id}를 적어줘도 번호가 넘어가지만
//	@PathVariable("id") Integer id 경로 변수를 따로 적어주는 편이 좋다. (보일러플레이트의)코드량 증가등등의 이유
//  id 없을 때 뜨는 화면 404 throws exception 설정 (서비스)
	@RequestMapping("/question/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) throws DataNotFoundException {
		Question question = this.qService.getQuestion(id);
		model.addAttribute("question", question);

		return "question_detail";
	}
}
