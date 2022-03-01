package com.fabiobenoit.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabiobenoit.backend.exceptions.ResourceNotFoundException;
import com.fabiobenoit.backend.models.User;
import com.fabiobenoit.backend.repositories.UserRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class UsersControllers {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("allusers")
	public List<User> getAllUsers() {

		return userRepo.findAll();
	}


	@GetMapping("user/{id}")
	public ResponseEntity<User> getStudentById(@PathVariable int id) {
		User user = userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found."));
				return ResponseEntity.ok(user);
}
}