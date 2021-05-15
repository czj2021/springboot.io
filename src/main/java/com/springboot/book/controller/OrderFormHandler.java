package com.springboot.book.controller;


import com.springboot.book.entity.OrderForm;
import com.springboot.book.mapper.OrderFormMapper;
import com.springboot.book.repository.OrderFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orderform")
public class OrderFormHandler {
    @Autowired
    private OrderFormRepository orderformRepository;

//    @GetMapping("/findAll")
//    public List<OrderForm> findAll(){
//        return orderformRepository.findAll();
//    }

//    @GetMapping("/findById/{id}")
//    public OrderForm findById(@PathVariable("id")Integer id){
//        return orderformRepository.getById(id);
//    }

    @PostMapping("/save")
    public OrderForm save(@RequestBody OrderForm orderform) {
        return orderformRepository.save(orderform);
    }

    @PutMapping("/update")
    public OrderForm update(@RequestBody OrderForm orderform){
        return  orderformRepository.save(orderform);
    }

//    @DeleteMapping("/deleteById/{id}")
//    public void  deleteById(@PathVariable("id")Integer id){
//        orderformRepository.deleteById(id);
//    }



    @Autowired
    private OrderFormMapper orderformMapper;

    @RequestMapping("/findAll")
    public List<OrderForm> findAll(){
        return  orderformMapper.findAll();
    }

    @RequestMapping("/findById/{id}")
    public OrderForm findById(@PathVariable("id") int id){
        return orderformMapper.findById(id);
    }

    @RequestMapping("/findByuserId/{userid}")
    public List<OrderForm> findByuserId(@PathVariable("userid") int userid){
        return orderformMapper.findByuserId(userid);
    }

    @RequestMapping("/saveAll")
    public int saveAll(@RequestBody OrderForm orderform){
        return orderformMapper.saveAll(orderform);
    }

    @RequestMapping("/deleteAllById/{userid}")
    public void deleteAllById(@PathVariable("userid") int userid){   orderformMapper.deleteAllById(userid); }

    @RequestMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") int id){   orderformMapper.deleteById(id); }

    @RequestMapping("/saveAllList")
    public  List<Integer> saveAllList(@RequestBody List<OrderForm> orderforms){

        List<Integer> order=new ArrayList<>();

        for(OrderForm orderform : orderforms){

            orderformMapper.saveAllList(orderform);
            order.add(orderform.getId());
            System.out.println(orderform);
        }
        return  order;
//          return  orderformMapper.saveAllList(orderform);
    }
}
