package com.springboot.book.controller;


import com.springboot.book.entity.Address;
import com.springboot.book.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/address")
public class AddressHandler {
    @Autowired
    private AddressMapper addressMapper;

    @RequestMapping("/findAll")
    public List<Address> findAll(){
        return  addressMapper.findAll();
    }

    @RequestMapping("/deleteAllById/{id}")
    public void deleteAllById(@PathVariable("id") int id){   addressMapper.deleteAllById(id); }

    @RequestMapping("/updateAllById")
    public int updateAllById(@RequestBody Address address){
        return  addressMapper.updateAllById(address);
    }

    @RequestMapping("/findByuserId/{userid}")
    public List<Address> findByuserId(@PathVariable("userid") int userid){
        return addressMapper.findByuserId(userid);
    }

    @RequestMapping("/findById/{id}")
    public Address findById(@PathVariable("id") int id){
        return addressMapper.findById(id);
    }

    @RequestMapping("/saveAll")
    public int saveAll(@RequestBody Address address){
        return addressMapper.saveAll(address);
    }
}
