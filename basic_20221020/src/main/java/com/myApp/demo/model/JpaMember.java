package com.myApp.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.core.type.filter.AbstractClassTestingTypeFilter;

import lombok.Data;

//@Entity 디비랑 직접연관되어 있음
//@Data 게터와 세터 만들어주는..lombok
//jpa bilder 쓰게 된다면...여긴 없는데 순서에 상관없이 쓸 수 있다
// jpa_member로 자동으로 만들어지기 때문에 JpaMember 이런식으로 클래스명 지정해준다.
// 보드나 멤버를 했을 때 양방향 관계성을 만들지 마라.. json형태로 해줘야 할 수도 있는데 그렇게 되면 무한루프가 된다.

@Data
@Entity
public class JpaMember {
	
//	기본키라는 것을 알려줌 Id
//  @GeneratedValue(strategy=GenerationType.IDENTITY) 마이에스큐엘에 오토인크리먼트를 사용하는 것 과 같다
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String password;
	private String email;
	private String memo;
// 이름 바꾸기
	@Column(name="address")
	private String addr;

}
