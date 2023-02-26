package com.crud.demo.service;

import java.util.List;

import com.crud.demo.entity.Student;

public interface StudentService {

	public Student createUser(Student user);

	public Student updateUser(Student user, Integer id);

	public void deleteUser(int id);

	public List<Student> getUsers();

	public Student	 getUserById(int id);

}
