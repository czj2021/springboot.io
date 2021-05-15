package com.springboot.book.controller;

import com.springboot.book.component.SDK;
import com.springboot.book.component.SecureHashAlgorithm;
import com.springboot.book.entity.User;
import com.springboot.book.mapper.UserMapper;
import com.springboot.book.repository.UserRepository;
import com.springboot.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserHandler{
    @Autowired
    private UserRepository userRepository;

//    @GetMapping("/findAll")
//    public List<User> findAll(){
//        return userRepository.findAll();
//    }

//    @GetMapping("/findById/{id}")
//    public User findById(@PathVariable("id")Integer id){
//        return userRepository.getById(id);
//    }

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user){
        return  userRepository.save(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void  deleteById(@PathVariable("id")Integer id){
        userRepository.deleteById(id);
    }


    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUser/{id}")
    public String GetUser(@PathVariable int id){
        return userService.Sel(id).toString();
    }

    @RequestMapping("/findPasswordByUsername/{username}")
    public String findPasswordByUsername(@PathVariable("username") String username){

        return new SecureHashAlgorithm().SHAMD5(userMapper.findPasswordByUsername(username));
    }

    @RequestMapping("/findPassword")
    public boolean findPassword(@RequestBody User user){
        String password=userMapper.findPasswordByUsername(user.getUsername());
        String lopassword=new SecureHashAlgorithm().SHAMD5(user.getPassword());
        return lopassword.equals(password);
    }

    @RequestMapping("/isRegistered/{username}")
    public boolean isRegistered(@PathVariable("username") String username){
        String result = userMapper.isRegistered(username);
        return result != null;
    }

    @RequestMapping("/isRetrieve/{phone}")
    public boolean isRetrieve(@PathVariable("phone") String phone){
        String result = userMapper.isRetrieve(phone);
        return result != null;
    }

    @RequestMapping("/saveAll")
    public int saveAll(@RequestBody User user){

        user.setPassword(new SecureHashAlgorithm().SHAMD5(user.getPassword()));
        return userMapper.saveAll(user);
    }

    @RequestMapping("/updateAllById")
    public int updateAllById(@RequestBody User  user){
        user.setPassword(new SecureHashAlgorithm().SHAMD5(user.getPassword()));
        return  userMapper.updateAllById(user);
    }

    @RequestMapping("/updatePasswordByUserName")
    public int updatePasswordByUserName(@RequestBody User  user){
        user.setPassword(new SecureHashAlgorithm().SHAMD5(user.getPassword()));
        return  userMapper.updatePasswordByUserName(user);
    }

    @RequestMapping("/findAllByUsername/{username}")
    public User findAllByUsername(@PathVariable("username") String username){
        return userMapper.findAllByUsername(username);
    }

    @RequestMapping("/findAll")
    public List<User> findAll(){
        return  userMapper.findAll();
    }

    @RequestMapping("/deleteAllById/{id}")
    public void deleteAllById(@PathVariable("id") int id){   userMapper.deleteAllById(id); }

    @RequestMapping("/deleteAllByUserName/{username}")
    public void deleteAllByUserName(@PathVariable("username") String username){   userMapper.deleteAllByUserName(username); }

    @RequestMapping("/findById/{id}")
    public User findById(@PathVariable("id") int id){
        return userMapper.findById(id);
    }


    @RequestMapping("/sdk/{phone}")
    public String sdk(@PathVariable("phone") String phone){
        return new SDK().SendSms(phone);
    }
}
