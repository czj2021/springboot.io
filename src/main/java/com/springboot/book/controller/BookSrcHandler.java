package com.springboot.book.controller;

import com.springboot.book.entity.BookSrc;
import com.springboot.book.entity.ListInfo;
import com.springboot.book.mapper.BookSrcMapper;
import com.springboot.book.repository.BookSrcRepository;
import com.springboot.book.service.BookSrcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping("/booksrc")
@RestController
public class BookSrcHandler {
    @Autowired
    private BookSrcRepository booksrcRepository;

    //    @GetMapping("/findAll")
//    public List<BookSrc> findAll(){
//        return booksrcRepository.findAll();
//    }
//
//    @GetMapping("/findById/{id}")
//    public BookSrc findById(@PathVariable("id")Integer id){
//        return booksrcRepository.getById(id);
//    }
//    @GetMapping("/findAll/{page}/{size}")
//    public Page<BookSrc> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
//        PageRequest request = PageRequest.of(page,size);
//        return booksrcRepository.findAll(request);
//    }

    @PostMapping("/save")
    public BookSrc save(@RequestBody BookSrc booksrc) {
        return booksrcRepository.save(booksrc);
    }

    @RequestMapping("/update")
    public BookSrc update(@RequestBody BookSrc booksrc){
        return  booksrcRepository.save(booksrc);
    }

    @DeleteMapping("/deleteById/{id}")
    public void  deleteById(@PathVariable("id")Integer id){
        booksrcRepository.deleteById(id);
    }



    @Autowired
    private BookSrcMapper booksrcMapper;

    @Autowired
    private BookSrcService booksrcService;

    @RequestMapping("/findById/{id}")
    public BookSrc findById(@PathVariable("id") int id){
        return booksrcMapper.findById(id);
    }

    @RequestMapping("/findByBookname/{bookname}")
    public BookSrc findByBookname(@PathVariable("bookname") String bookname){
        return booksrcMapper.findByBookname(bookname);
    }

    @RequestMapping("/findAll")
    public List<BookSrc>  findAll(){
        return  booksrcMapper.findAll();
    }

    @RequestMapping("/findOrderByNums")
    public List<BookSrc>  findOrderByNums(){
        return  booksrcMapper.findOrderByNums();
    }

    @RequestMapping("/findOrderByDesc")
    public List<BookSrc>  findOrderByDesc(){
        return  booksrcMapper.findOrderByDesc();
    }

    @RequestMapping("/updateAllById")
    public int updateAllById(@RequestBody BookSrc booksrc){
        return  booksrcMapper.updateAllById(booksrc);
    }

    @RequestMapping("/saveAll")
    public int saveAll(@RequestBody BookSrc booksrc){
        return booksrcMapper.saveAll(booksrc);
    }

    @RequestMapping("/deleteAllById/{id}")
    public void deleteAllById(@PathVariable("id") int id){   booksrcMapper.deleteAllById(id); }

    @RequestMapping("/findAllByKeyword/{keyword}")
    public List<BookSrc> findAllByKeyword(@PathVariable("keyword") String keyword){
        return booksrcMapper.findAllByKeyword(keyword);
    }

    @RequestMapping("/findAllByTitleKey/{keyword}")
    public List<BookSrc> findAllByTitleKey(@PathVariable("keyword") String keyword){
        return booksrcMapper.findAllByTitleKey(keyword);
    }

    @RequestMapping("/findAllByPage")
    public List<BookSrc> findAllByPage(@RequestBody ListInfo listInfo){
        return booksrcMapper.findAllByPage(listInfo);
    }

//    @RequestMapping("/findAllClass/{page}/{size}")
//    public Page<BookSrc>  findAllClass(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
////        PageRequest request = PageRequest.of(page,size);
//        return  booksrcMapper.findAllClass(page,size);
//    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<BookSrc> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return booksrcRepository.findAll(request);
    }

}
