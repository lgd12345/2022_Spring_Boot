package com.example.demo;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.repository.AnswerRepository;
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
	@Autowired
	private AnswerRepository aRepo;

//  @test : testJpa 메서드가 테스트 메서드임을 나타낸다.
	// JUnit 로 실행하면 @Test 애너테이션이 붙은 메서트 실행됨
	@Transactional
	@Test
	void testJpa() {
//	입력 끝난 후 조회 연습 하기위해 주석처리!

//		Question q1 = new Question();
//        q1.setSubject("sbb가 무엇인가요?");
//        q1.setContent("sbb에 대해서 알고 싶습니다.");
//        q1.setCreateDate(LocalDateTime.now());
//        this.qRepo.save(q1); // 첫번째 질문 저장
//        
//        Question q2 = new Question();
//        q2.setSubject("점심 머 먹을 까요?");
//        q2.setContent("한식 양식 중식 일식 중에 골라주세요!");
//        q2.setCreateDate(LocalDateTime.now());
//        this.qRepo.save(q2);

//데이터 조회
// findAll
//		저장된 모든 데이터 조회를 위해 findAll메서드 사용
//		3개 데이터가 저장되어 있기 때문에 데이터 사이즈는 3
// 		데이터 사이즈 확인을 위해 JUnit의 assertEquals메서드 사용 (기대값 , 실제값) 동일한지 조사
		// assertEquals여기에 맞지 않으면 Failures에 걸리게 된다.	
		
//		List<Question> all = this.qRepo.findAll();
//		assertEquals(3, all.size());
		
//		데이터 제목값 확인을 위해 JUnit의 assertEquals메서드 사용 (기대값 , 실제값) 동일한지 조사
		
//		Question q = all.get(0);
//		assertEquals("sbb가 무엇인가요?", q.getSubject());
		
//		로컬 서버 중지 JUnit 실행
//		System.out.println(q.getSubject());
		
//findById Question엔티티의 Id 값으로 데이터 조회하기
//		findById의 리턴타입은 Optional이다. isPresent로 널 확인을 한 후 get으로 실제 데이터 값 얻음

//		Optional<Question> oq = this.qRepo.findById(1);
//		if(oq.isPresent()) {
//			Question q = oq.get();
//			System.out.println(q.getContent());
//			assertEquals("sbb가 무엇인가요?", q.getSubject());
//		}
		
//findBySubject 엔티티의 subject 값으로 데이터를 조회한다.
//		사용하려면 QuestionRepository 인터페이스를 변경후  사용해야함
//		제목으로 데이터 조회 가능!
		
//		Question q = this.qRepo.findBySubject("sbb가 무엇인가요?");
//		assertEquals(1, q.getId());
		
//subject, content 둘다 조회 and 조건으로 where 문에서 사용됨
		
//		Question q1 = this.qRepo.findBySubjectAndContent(
//				"sbb가 무엇인가요?","sbb에 대해서 알고 싶습니다.");
//		assertEquals(1, q1.getId());

//특정문자열이 포함된 데이터 조회하기
//sbb%: sbb로 시작하는 문자열, %sbb로 끝나는 문자열 , %sbb%를 포함하는 문자열
//		List<Question> qList = this.qRepo.findBySubjectLike("sbb%");
//		Question q = qList.get(0);
//		assertEquals("sbb가 무엇인가요?", q.getSubject());
		
//데이터 수정
//		Optional<Question> oq = this.qRepo.findById(1);
		
		//assertTure: 값이 true인지 테스트
		// 조회 수정 저장
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		q.setSubject("수정된 제목!!!!");
//		this.qRepo.save(q);
//데이터 삭제
//		assertEquals(3, this.qRepo.count());
//		
//		Optional<Question> oq = this.qRepo.findById(2);
//		
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		this.qRepo.delete(q);
//		assertEquals(2, qRepo.count());
		
//Answer 입력
//		Optional<Question> oq = this.qRepo.findById(3);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		
//		Answer a = new Answer();
//		a.setContent("한식이요!");
//		a.setQuestion(q); // 어떤 질문의 답변인지 알기 위해 question의 객체가 필요 (연결!)
//		a.setCreateDate(LocalDateTime.now());
//		this.aRepo.save(a);
//Answer 데이터 조회 (id값을 이용한 조회) 답변조회
//		답변에 연결된 질문 찾기 : Answer엔티티에 question 속성이 정의 되어 있어서 쉽다.		

//		Optional<Answer> oa = this.aRepo.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(1, a.getQuestion().getId());
// assertEquals여기에 맞지 않으면 Failures에 걸리게 된다.	
		
//		System.out.println("oa++++++++++++"+oa);
//		System.out.println("oa.get++++++++++"+oa.get());
//		System.out.println("a.getQuestion().getId+++++"+ a.getQuestion().getId());
		
		
//		질문에 달린 답변 찾기 : answerList를 사용하면 쉽게 구할 수 있다.
		Optional<Question> oq = this.qRepo.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		List<Answer> answerList = q.getAnswerList();
		
		assertEquals(1, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
		
		System.out.println("answerList.get(0).getContent()++++++"+answerList.get(0).getContent());
//		Question객체를 조회하고 나면 DB세션이 끊어져서 오류가 발생한다.
//		답변데이터 리스트는 q.getAnswerList()메서드를 호출하는 시점에서 가져오기 때문이다.
//		테스트 코드에서는 DB세션이 종료되기 때문에 @Transactional 애너테이션을 사용한다.
//		@Transactional : 메서드가 종료될 때 까지 DB세션이 유지된다.


	}

}
