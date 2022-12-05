package com.example.demo.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.repository.AnswerRepository;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository aRepo;

// 답변 생성 create 메서드
	// 어떤 질문의 답변인지 알기 위해 question의 객체가 필요 (연결!)
	public void create(Question question, String content) {
		Answer answer = new Answer();
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		answer.setQuestion(question);
		this.aRepo.save(answer);
	}

}
