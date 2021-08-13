package com.medialog.InternProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medialog.InternProject.model.User;
import com.medialog.InternProject.repository.UserRepository;

@RestController
public class putController {

	@Autowired
	private UserRepository userRepository;

	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable String id, @RequestBody User user) {
		User userUpdate = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("해당 사용자가 없습니다.");
		});
		
		userUpdate.setAddr(user.getAddr());
		return userRepository.save(userUpdate);
	}
}
