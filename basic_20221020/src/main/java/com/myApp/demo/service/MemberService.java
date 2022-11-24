package com.myApp.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myApp.demo.model.JpaMember;
import com.myApp.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
//생성자를 이용해서 자동주입하기 위해서
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;

//추가
	public void save(JpaMember member) {
		memberRepository.save(member);

	}

//전체보기
	public List<JpaMember> list() {
		return memberRepository.findAll();
	}

//	전체보기 페이징 리스트 쓰면 안 됨!! 페이지에 관련된걸로 해줘야 한다.
	public Page<JpaMember> list(Pageable pageable) {
		return memberRepository.findAll(pageable);
	}

// 상세보기(Optional)
// 옵셔널 널값을 처리하고 넣어줘야함 가장 쉬운 방법: .get(); 있는 값만 겟해서 리턴해줘라
// 원래는 이런식으로 처리하면 안됨...
	public JpaMember detail(Long id) {
		return memberRepository.findById(id).get();
	}

//	삭제
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}

//  수정(더티체킹)
	@Transactional
	public void update(JpaMember member) {
		JpaMember m = memberRepository.findById(member.getId()).get();
		m.setAddr(member.getAddr());
		m.setEmail(member.getEmail());
		m.setMemo(member.getMemo());
		m.setName(member.getName());
		m.setPassword(member.getPassword());
	}
}
