package com.junhao.god.controller;

import com.junhao.god.entity.GodTable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("demo")
public class DemoController {
    // 查询所有
    @GetMapping
    public String getAllUsers(String test) {
        System.out.println("拿到了参数"+test);
        method();
        return "HelloWorld!";
    }

    private void method() {
        System.out.println("方法执行了...");
    }
}
