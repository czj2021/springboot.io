package com.springboot.book.controller;


import com.springboot.book.entity.Classify;
import com.springboot.book.mapper.ClassifyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classify")
public class ClassifyHandler {



    @Autowired
    private ClassifyMapper classifyMapper;

    @RequestMapping("/findAll")
    public List<Classify> findAll(){
        return  classifyMapper.findAll();
    }

    @RequestMapping("/findById/{id}")
    public Classify findById(@PathVariable("id") int id){
        return classifyMapper.findById(id);
    }

    @RequestMapping("/saveAll")
    public int saveAll(@RequestBody Classify cart){
        return classifyMapper.saveAll(cart);
    }

    @RequestMapping("/deleteAllById/{userid}")
    public void deleteAllById(@PathVariable("userid") int id){   classifyMapper.deleteAllById(id); }

    @RequestMapping("/updateAllById")
    public int updateAllById(@RequestBody Classify classify){
        return   classifyMapper.updateAllById(classify);
    }

}
