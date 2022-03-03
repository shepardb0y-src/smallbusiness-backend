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
import com.fabiobenoit.backend.models.Client;
import com.fabiobenoit.backend.repositories.ClientRepository;



@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class ClientsControllers {

	@Autowired
	private ClientRepository clientRepo;
	
	@GetMapping("allclients")
	public List<Client> getAllClients() {
		return clientRepo.findAll();
	}
	@GetMapping("client/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable int id) {
		Client client = clientRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found."));
				return ResponseEntity.ok(client);
}
	
	@PostMapping("addclients")
	public Client newStudent(@RequestBody Client client) {
		return clientRepo.save(client);
	}
	@PutMapping("client/{id}")
	public ResponseEntity<Client> updateUser(@PathVariable int id, @RequestBody Client newClientInfo) {
		Client foundClient = clientRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found."));
		
//		Update info of found student using setters with the new info from req.body using getters.
		foundClient.setUsername(newClientInfo.getUsername());

		Client updatedClient = clientRepo.save(foundClient);
		
		return ResponseEntity.ok(updatedClient);
	}
	
	
}