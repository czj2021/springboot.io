package com.springboot.book.service;



import com.springboot.book.entity.BookSrc;
import com.springboot.book.mapper.BookSrcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class BookSrcService {
    @Autowired
    BookSrcMapper booksrcMapper;

    public void setImgSrc(int adminId, String imgPath){
        BookSrc booksrc=new BookSrc();
        booksrc.setId(adminId);
        booksrc.setImgsrc(imgPath);
        System.out.println(booksrc);
        booksrcMapper.setImgSrc(booksrc);
    }


}
