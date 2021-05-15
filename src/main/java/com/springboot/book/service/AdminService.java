package com.springboot.book.service;


import com.springboot.book.entity.Admin;
import com.springboot.book.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    public void setAdminAvatar(int adminId, String imgPath){
        Admin admin=new Admin();
        admin.setId(adminId);
        admin.setAdminavatar(imgPath);
        System.out.println(admin);
        adminMapper.setAdminAvatar(admin);
    }
}
