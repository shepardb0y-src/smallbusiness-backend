package com.fabiobenoit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabiobenoit.backend.models.User;
import com.fabiobenoit.backend.repositories.UserRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class UsersController {
	@Autowired
	private UserRepository usersRepo;
	
	@GetMapping("allusers")
	public List<User> getAllStudents() {
//		You can pass on some sorting logic inside findAll() 
		return usersRepo.findAll();
	}
	
}
