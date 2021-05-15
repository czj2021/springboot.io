package com.springboot.book.repository;

import com.springboot.book.entity.OrderForm;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderFormRepository extends JpaRepository<OrderForm,Integer> {



   OrderForm getById(Integer id);

}
