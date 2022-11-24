package com.myApp.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="hotel_review")
public class HotelReview {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private int rate;
	private String comment;
	private Date rating_date;
	
	// 다수 대 일
	@ManyToOne
	@JoinColumn(name="hotel_id")
	private Hotel hotel;
}
