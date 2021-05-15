package com.springboot.book.controller;

import com.springboot.book.entity.BookHeader;
import com.springboot.book.mapper.BookHeaderMapper;
import com.springboot.book.repository.BookHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bookheader")
@RestController
public class BookHeaderHandler {
    @Autowired
    private BookHeaderRepository bookheaderRepository;

//    @GetMapping("/findAll")
//    public List<BookSrc> findAll(){
//        return booksrcRepository.findAll();
//    }
//
//    @GetMapping("/findById/{id}")
//    public BookSrc findById(@PathVariable("id")Integer id){
//        return booksrcRepository.getById(id);
//    }

    @PostMapping("/save")
    public BookHeader save(@RequestBody BookHeader bookheader) {
        return bookheaderRepository.save(bookheader);
    }

    @RequestMapping("/update")
    public BookHeader update(@RequestBody BookHeader bookheader){
        return  bookheaderRepository.save(bookheader);
    }

    @DeleteMapping("/deleteById/{id}")
    public void  deleteById(@PathVariable("id")Integer id){
        bookheaderRepository.deleteById(id);
    }



    @Autowired
    private BookHeaderMapper bookheaderMapper;

    @RequestMapping("/findById/{id}")
    public BookHeader findById(@PathVariable("id") int id){
        return bookheaderMapper.findById(id);
    }

    @RequestMapping("/findAll")
    public List<BookHeader>  findAllI(){
        return  bookheaderMapper.findAll();
    }

    @RequestMapping("/updateAllById")
    public int updateAllById(@RequestBody BookHeader bookheader){
        return  bookheaderMapper.updateAllById(bookheader);
    }

    @RequestMapping("/saveAll")
    public int saveAll(@RequestBody BookHeader bookheader){
        return bookheaderMapper.saveAll(bookheader);
    }

    @RequestMapping("/deleteAllById/{id}")
    public void deleteAllById(@PathVariable("id") int id){   bookheaderMapper.deleteAllById(id); }

    @RequestMapping("/findAllById/{id}")
    public BookHeader findAllById(@PathVariable("id") int id){  return bookheaderMapper.findAllById(id); }
}
