package com.crud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.entity.User;
import com.crud.demo.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@PostMapping("/save-user")
	public ResponseEntity<?> createUser(@RequestBody User user) {

		User userResponse = userService.createUser(user);
		return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
	}

	@PutMapping("/update-user/{id}")
	public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable("id") Integer id) {

		User userResponse = userService.updateUser(user, id);
		return new ResponseEntity<>(userResponse, HttpStatus.OK);
	}

	@DeleteMapping("/delete-user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {

		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<?> getUsers() {

		List<User> users = userService.getUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Integer id) {

		User user = userService.getUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}
