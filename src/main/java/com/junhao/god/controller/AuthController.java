package com.junhao.god.controller;

import com.junhao.god.entity.User;
import com.junhao.god.mapper.UserMapper;
import com.junhao.god.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserMapper userMapper;
    @Autowired private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {
        User dbUser = userMapper.findByUsername(user.getUsername());
        if (dbUser == null || !dbUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("用户名或密码错误");
        }
        String token = jwtUtil.generateToken(dbUser.getUsername());
        return Map.of("token", token);
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if (userMapper.findByUsername(user.getUsername()) != null) {
            return "用户已存在";
        }
        userMapper.insert(user);
        return "注册成功";
    }
}