package com.springboot.book.mapper;


import com.springboot.book.entity.Admin;
import com.springboot.book.entity.Cart;
import com.springboot.book.entity.LoSrc;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface LoSrcMapper {
    List<LoSrc> findAll();
    void setLogoImg(LoSrc losrc);
    void  deleteAllById(int id);
    LoSrc  findAllById(int id);
    int  updateAllById(LoSrc losrc);
    int saveAll(LoSrc losrc);
}
