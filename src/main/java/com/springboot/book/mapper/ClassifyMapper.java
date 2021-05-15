package com.springboot.book.mapper;

import com.springboot.book.entity.Classify;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ClassifyMapper {

    List<Classify> findAll();
    Classify findById(int id);
    int saveAll(Classify classify);
    void  deleteAllById(int id);
    int  updateAllById(Classify classify);
}
