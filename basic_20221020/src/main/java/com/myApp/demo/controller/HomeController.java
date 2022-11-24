package com.myApp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myApp.demo.model.JpaMember;
import com.myApp.demo.service.MemberService;

//home 파일명 같은 소문자인지 확인하기
@Controller
public class HomeController {

//	만들어진 객체 주입
	@Autowired
	private MemberService memberService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/join")
	public String join() {
		return "join";
	}

// redirect:list : "redirect:list" 관계성이 유지 되어서 유지를 끊기게 해서 list 로 redirect 처리
// default 값이 forward 라서 그 (전)앞으로 돌아감 이전 값이 들어가짐 (관계유지)
	@PostMapping("/join")
	public String join(JpaMember member) {
		memberService.save(member);
		return "redirect:list";
	}

// 전체보기
//	@GetMapping("/list")
//	public String list(Model model) {
//		List<JpaMember> members = memberService.list();
//		model.addAttribute("lists", members);
//		return "list";
//	}

// 전체보기 (페이징 버전) 3개씩 띄우고 size = 3, sort = "id" direction=Sort.Direction.DESC 정렬
	@GetMapping("/list")
	public String list(Model model, @PageableDefault(size = 3, sort = "id", direction=Sort.Direction.DESC) Pageable pageable) {
	System.out.println("pageable:"+ pageable);
	Page<JpaMember>lists = memberService.list(pageable);
	model.addAttribute("lists",lists);
		return "list";
	}

//	상세보기
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable Long id, Model model) {
		model.addAttribute("member", memberService.detail(id));
		return "detail";
	}
	
//	상세보기 밑에서 보기 바로 2 
//  뷰로가는게 아니라서 	@ResponseBody로 데이터만
	@ResponseBody
	@GetMapping("/detail2/{id}")
	public JpaMember detail2(@PathVariable Long id) {
		return memberService.detail(id);
	}
//	삭제하기
//	뷰에 객체를 담을 때 model 하는 것임 지금은 몇번 성공만 하라고..
//  뷰랑 연결 할 때는 public void delete보이드 쓰면 안됨
// 실질적인 값이기 때문에 이걸 쓴다. @ResponseBody 실질적인 데이터일 때 넘기겠다
// @ResponseBody가 포함된 게 레스트컨트롤러다... 데이터만 넘기는 것.
// 레스트컨트롤러를 쓰려면 모두가 레스트 컨트롤러로 해줘야한다.

	@DeleteMapping("delete/{id}")
	@ResponseBody
	public Long delete(@PathVariable Long id) {
		memberService.delete(id);
		return id;
	}

// 수정하기로 가기
	@GetMapping("/update/{id}")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("member", memberService.detail(id));
		return "update";
	}

//	수정하기
//	폼이 아닌 제이슨형태로 받아온다.
	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody JpaMember member) {
		System.out.println("addr" + member.getAddr());
		System.out.println("memo" + member.getMemo());
		System.out.println("name" + member.getName());
		System.out.println("email" + member.getEmail());
		memberService.update(member);
		return "success";
	}

}
