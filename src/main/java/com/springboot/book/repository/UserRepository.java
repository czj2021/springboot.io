package com.springboot.book.repository;

import com.springboot.book.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {


   User getById(Integer id);








}
