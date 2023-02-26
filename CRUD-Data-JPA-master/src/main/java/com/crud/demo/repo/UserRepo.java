package com.crud.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.demo.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
