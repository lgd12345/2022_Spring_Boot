package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Question;

// 데이터베이스 테이블에 접근하는 메서드들을 사용하기 위한 인터페이스.
// 리포지터리는 crud를 어떻게 처리할 지 정의하는 계층이 리포지터리이다.
// Question 리포지터리

// JpaRepository를 상속해 리포지터리로 만든다.
// 적을 때는 엔티티 타입과(Question)과 엔티티의 PK속성타입을 지정해야한다.
// 해당 프라이머리키 속성타입은 Integer이니까 Integer를 적는다.
// 이제 테이블에 데이터 저장 조회 가능!
public interface QuestionRepository extends JpaRepository<Question, Integer> {
// findBySubject 메서드 사용위해서 추가
	Question findBySubject(String subject);
// subject,content 같이 조회
	Question findBySubjectAndContent(String subject, String contient);
// 특정문자열 포함된 데이터 조회 하기 위해 추가
	List<Question> findBySubjectLike(String subject);
}
