package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {

//	기본키(중복안됨) 매핑과 전략 (IDENTITY : 기본키 생성을 데이터 베이스에 위임)
//	데이터를 저장할 때 해당 속성에 값을 따로 세팅하지 않아도 1씩 자동으로 증가하여 저장된다
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
//	length는 컬럼의 길이를 설정
	@Column(length = 200)
	private String subject;

//	columnDefinition : 컬럼속성 정의 (원하는 column값으로 데이터 추출가능) TEXT : 글자수 제한 없음
	@Column(columnDefinition = "TEXT")
	private String content;
	
//createDate 의 실제 테이블의 컬럼명은 create_date가 됨. CamelCase가 소문자로 변경되고 언더바 구분이 됨
	private LocalDateTime createDate;
	
//	One : question(부모)
//	mappedBy : 참조 엔티티의 속성명
//	 Answer 엔티티에서 Question 엔티티를 참조한 속성명 question을 mappedBy에 전달해야 한다.
//	 CascadeType.REMOVE : 질문을 삭제하면 그에 달린 답변들도 모두 함께 삭제하기 

	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList;

}
