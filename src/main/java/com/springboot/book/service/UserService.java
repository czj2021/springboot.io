package com.springboot.book.service;


import com.springboot.book.entity.User;
import com.springboot.book.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User Sel(int id){
        return userMapper.Sel(id);
    }

    public void setUserAvatar(int userId,String imgPath){
        User user=new User();
        user.setId(userId);
        user.setAvatar(imgPath);
        System.out.println(user);
        userMapper.setUserAvatar(user);
    }
}
