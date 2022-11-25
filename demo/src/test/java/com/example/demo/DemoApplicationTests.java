package com.example.demo;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;

// 로컬 서버 중지 후 실행
// H2 데이터베이스는 파일 기반의 데이터베이스이기 때문에 
// 이미 로컬서버가 점유하고 있기 때문에 이러한 오류가 발생하는 것이다.
// 따라서 테스트를 하기 위해서는 로컬 서버를 중지해야 한다.
// 콘솔 확인은 다시 로컬 서버 실행

// 빌드패스여부는 잘 모르겠다.. 이 프로젝트에서는 빌드패스 했다. JUnit5 빌드패스
// @SpringBootTest : DemoApplicationTests 클래스가 스프링부트 테스트 클래스임을 의미한다.
@SpringBootTest
class DemoApplicationTests {
// DI : Dependency Injection
	// @Autowired는 테스트에서만 사용!!! 실제 코드 작성시엔 생성자를 통해서 주입한다!!
	// @Autowired : 스프링 DI기능 : QuestionRepository 객체를 스프링이 자동생성해줌(객체주입)
	@Autowired
	private QuestionRepository qRepo;

//  @test : testJpa 메서드가 테스트 메서드임을 나타낸다.
	// JUnit 로 실행하면 @Test 애너테이션이 붙은 메서트 실행됨
	
	@Test
	void testJpa() {
		Question q1 = new Question();
        q1.setSubject("sbb가 무엇인가요?");
        q1.setContent("sbb에 대해서 알고 싶습니다.");
        q1.setCreateDate(LocalDateTime.now());
        this.qRepo.save(q1); // 첫번째 질문 저장
        
        Question q2 = new Question();
        q2.setSubject("점심 머 먹을 까요?");
        q2.setContent("한식 양식 중식 일식 중에 골라주세요!");
        q2.setCreateDate(LocalDateTime.now());
        this.qRepo.save(q2);
	}

}
