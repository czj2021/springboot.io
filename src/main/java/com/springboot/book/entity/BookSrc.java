package com.springboot.book.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class BookSrc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String imgsrc;
    private String bookname;
    private float price;
    private String author;
    private String publish;
    private Integer pages;
    private Integer num;
    private Integer nums;
    private String titlekey;
}
