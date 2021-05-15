package com.springboot.book.mapper;


import com.springboot.book.entity.BookHeader;
import com.springboot.book.entity.LoSrc;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookHeaderMapper {

    BookHeader findById(int id);
    List<BookHeader> findAll();
    int updateAllById(BookHeader bookheader);
    int saveAll(BookHeader bookheader);
    void  deleteAllById(int id);
    BookHeader findAllById(int id);
    void setHeaderSrc(BookHeader bookheader);
}
