package com.springboot.book;

import com.springboot.book.component.SDK;
import com.springboot.book.controller.UserHandler;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test(){
        new SDK().SendSms("17350756083");
    }

    @Test
    void sdk(){
        new UserHandler().sdk("17350756083");
    }

}
