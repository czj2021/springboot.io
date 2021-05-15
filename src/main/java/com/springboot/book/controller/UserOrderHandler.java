package com.springboot.book.controller;


import com.springboot.book.entity.User;
import com.springboot.book.entity.UserOrder;
import com.springboot.book.mapper.UserOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userorder")
public class UserOrderHandler {

    @Autowired
    private UserOrderMapper userorderMapper;

    @RequestMapping("/findAll")
    public List<UserOrder> findAll(){
        return  userorderMapper.findAll();
    }

    @RequestMapping("/findById/{id}")
    public UserOrder findById(@PathVariable("id") int id){
        return userorderMapper.findById(id);
    }

    @RequestMapping("/findByuserId/{userid}")
    public List<UserOrder> findByuserId(@PathVariable("userid") int userid){
        return userorderMapper.findByuserId(userid);
    }

    @RequestMapping("/saveAll")
    public int saveAll(@RequestBody UserOrder userorder){
        return userorderMapper.saveAll(userorder);
    }

    @RequestMapping("/deleteAllById/{userid}")
    public void deleteAllById(@PathVariable("userid") int userid){   userorderMapper.deleteAllById(userid); }

    @RequestMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") int id){   userorderMapper.deleteById(id); }

    @RequestMapping("/saveAllList")
    public  List<Integer> saveAllList(@RequestBody List<UserOrder> userorders){

        List<Integer> order=new ArrayList<>();

        for(UserOrder userorder : userorders){

            userorderMapper.saveAllList(userorder);
            order.add(userorder.getId());
            System.out.println(userorder);
        }
        return  order;
//          return  orderformMapper.saveAllList(orderform);
    }

    @RequestMapping("/updateAddressById")
    public int updateAddressById(@RequestBody UserOrder userorder){
        return  userorderMapper.updateAddressById(userorder);
    }

    @RequestMapping("/updateOrderStateById")
    public int updateOrderStateById(@RequestBody UserOrder userorder){
        return  userorderMapper.updateOrderStateById(userorder);
    }
}
