package com.myapp.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.mybatis.mapper.UserMapper;
import com.myapp.mybatis.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

	// userMapper 선언하고 생성자 주입
	@Autowired
	UserMapper userMapper;

	// 레스트api에서 주소는 "/users/{id}" 이런식으로 파라메타 안 쓰는 게 정석임
	// 레스트컨트롤러가 부트와 레거시 차이점이 다 같지만 boot에서 json형태로 변환이 이루어진다는 차이가 있음
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") String id) {
		User user = userMapper.getUser(id);
		return user;
	}

	// 모든 유저 정보 가져오기
	@GetMapping
	public List<User> getUserList() {
		List<User> userList = userMapper.getUserList();
		return userList;
	}

	@PostMapping
	public void createUser(@RequestParam("id") String id, @RequestParam("name") String name,
			@RequestParam("phone") String phone, @RequestParam("address") String address) {

		userMapper.insertUser(id, name, phone, address);
	}

	@PutMapping("/{id}")
	public void editUser(@PathVariable("id") String id, 
						@RequestParam("name") String name,
						@RequestParam("phone") String phone,
						@RequestParam("address") String address) {
		userMapper.updateUser(id, name, phone, address);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		userMapper.deleteUser(id);
	}

}
