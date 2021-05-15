package com.springboot.book.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class UserOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String imgsrc;
    private String bookname;
    private String price;
    private Integer num;
    private Integer userid;
    private String address;
    private String name;
    private String phone;
    private String ordertime;
    private String orderstate;

}
