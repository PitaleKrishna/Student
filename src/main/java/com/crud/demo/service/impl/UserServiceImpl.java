package com.crud.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.entity.Student;
import com.crud.demo.repo.StudentRepo;
import com.crud.demo.service.StudentService;


@Service
public class UserServiceImpl implements StudentService {

	@Autowired
	private StudentRepo userRepo;

	@Override
	public Student createUser(Student student) {

		Student savedUser = userRepo.save(student);
		return savedUser;
	}

	@Override
	public Student updateUser(Student student, Integer id) {

		Student updatedUser = new Student();
		Optional<Student> savedUser = userRepo.findById(id);
		Student updateUser = savedUser.get();
		if (savedUser.isPresent()) {
			BeanUtils.copyProperties(student, updateUser);
		}
		updatedUser = userRepo.save(updateUser);
		return updatedUser;
	}

	@Override
	public void deleteUser(int id) {

		Optional<Student> savedUser = userRepo.findById(id);
		if (savedUser.isPresent()) {
			Student deletedUser = savedUser.get();
			userRepo.delete(deletedUser);
		}
	}

	@Override
	public List<Student> getUsers() {

		List<Student> users = userRepo.findAll();
		return users;
	}

	@Override
	public Student getUserById(int id) {

		Student student = new Student();
		Optional<Student> savedUser = userRepo.findById(id);
		if (savedUser.isPresent())
			return savedUser.get();
		return student;
	}

}
