package com.myApp.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="membership_user")
public class MemberShipUser {
	
	@Id
	private String email;
	private String name;
	private Date createdDate;
	
//	1대 1 양방 관계 설정
	@OneToOne(mappedBy="owner")
	private MembershipCard card;

}
