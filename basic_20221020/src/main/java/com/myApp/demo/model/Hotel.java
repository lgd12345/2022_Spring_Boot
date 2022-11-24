package com.myApp.demo.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Hotel")
public class Hotel {

//	@GeneratedValue(strategy=GenerationType.IDENTITY) 숫자 자동 증가
//  grade 상수로 저장되어 있음(변하지 않는 값)
//  Address 변수로 저장되어 있음

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
//	Enum타입이 스트링이라고 지정해줌
	@Enumerated(EnumType.STRING)
	private Grade grade;
	private Address address;
	
//	1 대 다수
	@OneToMany(mappedBy="hotel")
	private List<HotelReview> review;
	
	
	
}
