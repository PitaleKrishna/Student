package com.crud.demo.service;

import java.util.List;

import com.crud.demo.entity.User;

public interface UserService {

	public User createUser(User user);

	public User updateUser(User user, Integer id);

	public void deleteUser(int id);

	public List<User> getUsers();

	public User getUserById(int id);

}
