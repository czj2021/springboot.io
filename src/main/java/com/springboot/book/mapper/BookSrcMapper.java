package com.springboot.book.mapper;


import com.springboot.book.entity.BookSrc;
import com.springboot.book.entity.ListInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookSrcMapper {

    BookSrc findById(int id);
    BookSrc findByBookname(String bookname);
    List<BookSrc> findAll();
    List<BookSrc> findOrderByNums();
    List<BookSrc> findOrderByDesc();
    int updateAllById(BookSrc booksrc);
    int saveAll(BookSrc booksrc);
    void setImgSrc(BookSrc booksrc);
    void  deleteAllById(int id);
    List<BookSrc> findAllByPage(ListInfo listInfo);
    List<BookSrc> findAllByKeyword(String keyword);
    List<BookSrc> findAllByTitleKey(String keyword);
}
