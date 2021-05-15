package com.springboot.book.controller;


import com.springboot.book.entity.Cart;
import com.springboot.book.entity.LoSrc;
import com.springboot.book.mapper.LoSrcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/losrc")
public class LoSrcHandler {
    @Autowired
    private LoSrcMapper losrcMapper;

    @RequestMapping("/findAll")
    public List<LoSrc> findAll(){
        return  losrcMapper.findAll();
    }

    @RequestMapping("/deleteAllById/{id}")
    public void deleteAllById(@PathVariable("id") int id){   losrcMapper.deleteAllById(id); }

    @RequestMapping("/findAllById/{id}")
    public LoSrc findAllById(@PathVariable("id") int id){  return losrcMapper.findAllById(id); }

    @RequestMapping("/updateAllById")
    public int updateAllById(@RequestBody LoSrc losrc){
        return   losrcMapper.updateAllById(losrc);
    }

    @RequestMapping("/saveAll")
    public int saveAll(@RequestBody LoSrc losrc){
        return losrcMapper.saveAll(losrc);
    }
}
