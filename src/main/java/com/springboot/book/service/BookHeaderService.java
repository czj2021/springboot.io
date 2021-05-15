package com.springboot.book.service;


import com.springboot.book.entity.BookHeader;
import com.springboot.book.mapper.BookHeaderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookHeaderService {
    @Autowired
    BookHeaderMapper bookheaderMapper;

    public void setHeaderSrc(int adminId, String imgPath){
        BookHeader bookheader=new BookHeader();
        bookheader.setId(adminId);
        bookheader.setImgsrc(imgPath);
        System.out.println(bookheader);
        bookheaderMapper.setHeaderSrc(bookheader);
    }

}
