package com.springboot.book.mapper;


import com.springboot.book.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface AddressMapper {
    List<Address> findAll();
    void  deleteAllById(int id);
    int  updateAllById(Address address);
    List<Address> findByuserId(int userid);
    Address findById(int id);

    int saveAll(Address address);
}
