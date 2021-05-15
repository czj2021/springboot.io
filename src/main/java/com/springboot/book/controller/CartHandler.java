package com.springboot.book.controller;


import com.springboot.book.entity.Cart;
import com.springboot.book.mapper.CartMapper;
import com.springboot.book.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartHandler{
    @Autowired
    private CartRepository cartRepository;

//    @GetMapping("/findAll")
//    public List<Cart> findAll(){
//        return cartRepository.findAll();
//    }

//    @GetMapping("/findById/{id}")
//    public Cart findById(@PathVariable("id")Integer id){
//        return cartRepository.getById(id);
//    }

    @PostMapping("/save")
    public Cart save(@RequestBody Cart cart) {
        return cartRepository.save(cart);
    }

    @PutMapping("/update")
    public Cart update(@RequestBody Cart cart){
        return  cartRepository.save(cart);
    }

    @DeleteMapping("/deleteById/{id}")
    public void  deleteById(@PathVariable("id")Integer id){
        cartRepository.deleteById(id);
    }



    @Autowired
    private CartMapper cartMapper;

    @RequestMapping("/findAll")
    public List<Cart> findAll(){
        return  cartMapper.findAll();
    }

    @RequestMapping("/findById/{id}")
    public Cart findById(@PathVariable("id") int id){
        return cartMapper.findById(id);
    }

    @RequestMapping("/saveAll")
    public int saveAll(@RequestBody Cart cart){
        return cartMapper.saveAll(cart);
    }

    @RequestMapping("/deleteAllById/{userid}")
    public void deleteAllById(@PathVariable("userid") int userid){   cartMapper.deleteAllById(userid); }

    @RequestMapping("/findByuserId/{userid}")
    public List<Cart> findByuserId(@PathVariable("userid") int userid){
        return cartMapper.findByuserId(userid);
    }


}
