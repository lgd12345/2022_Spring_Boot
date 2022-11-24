package com.myApp.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="tbl_user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userid;
	private String address;
	private String nickname;
	private String username;

//	1 대 다수 (유저보다 주문이 많음)
	@OneToMany(mappedBy="user") // (mappedBy="user") 바라본다.
	private List<Order> orders;
}
