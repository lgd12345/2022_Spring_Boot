package com.myApp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myApp.demo.model.JpaMember;

// jpaMember의 기본키 : Long
public interface MemberRepository 
		extends JpaRepository<JpaMember, Long>{

}
