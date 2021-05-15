package com.springboot.book.service;


import com.springboot.book.entity.LoSrc;
import com.springboot.book.mapper.LoSrcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoSrcService {
    @Autowired
    LoSrcMapper losrcMapper;

    public void setLogoImg(int adminId, String imgPath){
        LoSrc losrc=new LoSrc();
        losrc.setId(adminId);
        losrc.setLogoimg(imgPath);
        System.out.println(losrc);
        losrcMapper.setLogoImg(losrc);
    }
}
