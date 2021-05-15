package com.springboot.book.mapper;

import com.springboot.book.entity.Cart;
import com.springboot.book.entity.OrderForm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CartMapper {

    List<Cart> findAll();
    Cart findById(int id);
    List<Cart> findByuserId(int userid);
    int saveAll(Cart cart);
    void  deleteAllById(int userid);
}
