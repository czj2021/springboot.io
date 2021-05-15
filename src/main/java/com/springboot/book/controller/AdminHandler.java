package com.springboot.book.controller;

import com.springboot.book.component.SecureHashAlgorithm;
import com.springboot.book.entity.Address;
import com.springboot.book.entity.Admin;
import com.springboot.book.entity.User;
import com.springboot.book.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/admin")
@RestController
public class AdminHandler {



    @Autowired
    private AdminMapper adminMapper;

    @RequestMapping("/findPasswordByUsername/{admin}")
    public String findPasswordByUsername(@PathVariable("admin") String admin){
        return adminMapper.findPasswordByUsername(admin);
//        return new SecureHashAlgorithm().SHAMD5(adminMapper.findPasswordByUsername(admin));
    }

    @RequestMapping("/saveAll")
    public int saveAll(@RequestBody Admin admin){
        admin.setPassword(new SecureHashAlgorithm().SHAMD5(admin.getPassword()));
        return adminMapper.saveAll(admin);
    }

    @RequestMapping("/findById/{id}")
    public Admin findById(@PathVariable("id") int id){
        return adminMapper.findById(id);
    }

    @RequestMapping("/updateAllById")
    public int updateAllById(@RequestBody Admin admin){

        admin.setPassword(new SecureHashAlgorithm().SHAMD5(admin.getPassword()));
        return adminMapper.updateAllById(admin);
    }

    @RequestMapping("/findAll")
    public List<Admin> findAll(){
        return  adminMapper.findAll();
    }

    @RequestMapping("/deleteAllById/{id}")
    public void deleteAllById(@PathVariable("id") int id){   adminMapper.deleteAllById(id); }

    @RequestMapping("/findAllByUsername/{admin}")
    public Admin findAllByUsername(@PathVariable("admin") String admin){
        return adminMapper.findAllByUsername(admin);
    }

    @RequestMapping("/findPassword")
    public boolean findPassword(@RequestBody Admin admin){
        String password=adminMapper.findPasswordByUsername(admin.getAdmin());
        String lopassword=new SecureHashAlgorithm().SHAMD5(admin.getPassword());
        return lopassword.equals(password);
    }
}
