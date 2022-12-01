package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Question;
import com.example.demo.notFound.DataNotFoundException;
import com.example.demo.repository.QuestionRepository;

//@Entity나 @Controller처럼 @Service 애너테이션을 붙여서 서비스로 인식시킨다. 

@Service
public class QuestionService {

//QuestionRepository 의존성 주입	
	@Autowired
	private QuestionRepository qRepo;

// getList 메서트를 추가하고 저장된 모든 데이터 조회를 위해 findAll메서드를 사용한다.
// 여기서 findAll은 리포지토리에서 자동으로 구현된 findAll
	public List<Question> getList() {
		return this.qRepo.findAll();
	}

//	디테일 출력부분
//	런타임 예외 처리 DataNotFoundException(404페이지) class 만들어서 질문 못 찾으면 실행시킨다.
	public Question getQuestion(Integer id) throws DataNotFoundException {
		Optional<Question> question = this.qRepo.findById(id);
		if (question.isPresent()) {
			return question.get();
		} else {
			throw new DataNotFoundException("question not found");
		}
	}
}
