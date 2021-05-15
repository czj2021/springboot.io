package com.springboot.book.repository;

import com.springboot.book.entity.BookSrc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookSrcRepository extends JpaRepository<BookSrc,Integer> {

    BookSrc getById(Integer id);
}
