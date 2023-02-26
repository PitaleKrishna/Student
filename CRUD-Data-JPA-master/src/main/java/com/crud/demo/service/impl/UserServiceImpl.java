package com.crud.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.crud.demo.entity.User;
import com.crud.demo.repo.UserRepo;
import com.crud.demo.service.UserService;
import com.crud.demo.util.Utils;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User createUser(User user) {

		User savedUser = userRepo.save(user);
		return savedUser;
	}

	@Override
	public User updateUser(User user, Integer id) {

		User updatedUser = new User();
		Optional<User> savedUser = userRepo.findById(id);
		User updateUser = savedUser.get();
		if (savedUser.isPresent()) {
			BeanUtils.copyProperties(user, updateUser, Utils.getNullPropertyNames(user));
		}
		updatedUser = userRepo.save(updateUser);
		return updatedUser;
	}

	@Override
	public void deleteUser(int id) {

		Optional<User> savedUser = userRepo.findById(id);
		if (savedUser.isPresent()) {
			User deletedUser = savedUser.get();
			userRepo.delete(deletedUser);
		}
	}

	@Override
	public List<User> getUsers() {

		List<User> users = userRepo.findAll();
		return users;
	}

	@Override
	public User getUserById(int id) {

		User user = new User();
		Optional<User> savedUser = userRepo.findById(id);
		if (savedUser.isPresent())
			return savedUser.get();
		return user;
	}

}
