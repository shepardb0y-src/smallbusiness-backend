package com.fabiobenoit.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabiobenoit.backend.models.User;
import com.fabiobenoit.backend.repositories.UserRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class UsersControllers {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("allusers")
	public List<User> getAllStudents() {
//		You can pass on some sorting logic inside findAll() 
		return userRepo.findAll();
	}
	@PostMapping("addstudent")
	public User newStudent(@RequestBody User user) {
		return userRepo.save(user);
	}
}
