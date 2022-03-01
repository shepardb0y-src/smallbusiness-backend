package com.fabiobenoit.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping("adduser")
	public User newStudent(@RequestBody User user) {
		return userRepo.save(user);
	}
	@PutMapping("user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User newUserInfo) {
		User foundUser = userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found."));
		
//		Update info of found student using setters with the new info from req.body using getters.
		foundUser.setFirstname(newUserInfo.getFirstname());
		foundUser.setLastname(newUserInfo.getLastname());
		foundUser.setStreetname(newUserInfo.getStreetname());
		foundUser.setState(newUserInfo.getState());
		foundUser.setZipcode(newUserInfo.getZipcode());
		foundUser.setComments(newUserInfo.getComments());
		
		User updatedUser = userRepo.save(foundUser);
		
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
//		Find user we want to delete
		userRepo.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("User not found."));
		
		String message =  "User has been deleted.";
		
//		Delete method from Jpa. Deletes entity from database.
		userRepo.deleteById(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
}