package com.springboot.book.mapper;


import com.springboot.book.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    User findById(int id);
    User findByBookname(String bookname);
    User Sel(int id);
    String findPasswordByUsername(String username);
    int saveAll(User  user);
    int  updateAllById(User  user);
    User findAllByUsername(String username);

    void setUserAvatar(User user);

    List<User> findAll();

    void  deleteAllById(int id);
    void  deleteAllByUserName(String username);
    User findPassword(User user);
    String sdk(String phone);
    String isRegistered(String username);
    String isRetrieve(String phone);
    int  updatePasswordByUserName(User  user);

}
