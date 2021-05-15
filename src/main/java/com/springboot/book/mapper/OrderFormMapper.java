package com.springboot.book.mapper;

import com.springboot.book.entity.OrderForm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderFormMapper {

    List<OrderForm> findAll();
    OrderForm findById(int id);
    List<OrderForm> findByuserId(int userid);
    int saveAll(OrderForm orderform);
    void  deleteAllById(int userid);
    void  deleteById(int id);
    int  saveAllList(OrderForm orderforms);
}
