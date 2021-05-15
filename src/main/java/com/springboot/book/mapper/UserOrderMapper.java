package com.springboot.book.mapper;

import com.springboot.book.entity.User;
import com.springboot.book.entity.UserOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserOrderMapper {

    List<UserOrder> findAll();
    UserOrder findById(int id);
    List<UserOrder> findByuserId(int userid);
    int saveAll(UserOrder userorder);
    void  deleteAllById(int userid);
    void  deleteById(int id);
    int  saveAllList(UserOrder userorder);
    int  updateAddressById(UserOrder userorder);
    int  updateOrderStateById(UserOrder userorder);
}
