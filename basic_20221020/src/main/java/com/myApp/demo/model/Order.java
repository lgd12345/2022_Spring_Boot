package com.myApp.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Entity(name="tbl_order") entity 자체 이름도 바뀜
@Entity(name="tbl_order")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderid;
	private String note;
	private String ordername;
	private int prince;
	
// 다 대 일 (주문이 많음 유저보다.)
//  @JoinColumn(name="user_id") 셀렉트한 애를 가져온다. 왜래키 가지고 있는 애가 왜래키의 주인이다.
//  왜래키가지고 있는애가 왜래키 관리자! 하위 관계의 기본키가 들어가게된다.
//  연관관계의 주인만이 (외래 키를) 등록, 수정, 삭제할 수 있으며, 주인이 아닌 쪽은 오직 읽기만 가능
//  (fetch=FetchType.LAZY): 지연전략
//	(fetch=FetchType.EAGER) : 즉시전략
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
}
