package com.springboot.book.mapper;


import com.springboot.book.entity.Admin;
import com.springboot.book.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface AdminMapper {

    int saveAll(Admin admin);
    int  updateAllById(Admin admin);
    String findPasswordByUsername(String admin);
    Admin findById(int id);
    void setAdminAvatar(Admin admin);
    Admin findAllByUsername(String admin);

    List<Admin> findAll();

    void  deleteAllById(int id);
    Admin findPassword(Admin admin);

}
