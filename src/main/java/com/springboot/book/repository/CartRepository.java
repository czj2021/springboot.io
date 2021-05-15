package com.springboot.book.repository;

import com.springboot.book.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<Cart,Integer> {



   Cart getById(Integer id);

}
