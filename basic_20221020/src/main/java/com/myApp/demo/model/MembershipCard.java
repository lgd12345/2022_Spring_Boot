package com.myApp.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="membership_card")
public class MembershipCard {
	
	@Id
	@Column(name="card_number")
	private String cardNumber;
	private Date expiryDate;
	private boolean enabled;
	
//	1대 1 양방 관계 설정 (기본전략은 즉시전략) (조인을 해야지 왜래키가 설정된다.)
	@OneToOne
	@JoinColumn(name="user_email")
	private MemberShipUser owner;

}
