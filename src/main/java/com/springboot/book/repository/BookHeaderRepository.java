package com.springboot.book.repository;

import com.springboot.book.entity.BookHeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookHeaderRepository extends JpaRepository<BookHeader,Integer> {

    BookHeader getById(Integer id);
}
