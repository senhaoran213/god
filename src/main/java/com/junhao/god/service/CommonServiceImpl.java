package com.junhao.god.service;

import com.junhao.god.common.Result;
import com.junhao.god.common.exception.BusinessException;
import com.junhao.god.entity.User;
import com.junhao.god.mapper.UserMapper;
import com.junhao.god.service.implement.CommonService;
import com.junhao.god.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtUtil jwtUtil;
    @Override
    public String login(String username, String password) {
        User user = userMapper.findUserByUserName(username);

        // 1. 校验账号密码
        if(user == null || !user.getPassword().equals(password)) {
            throw new BusinessException("用户名或密码错误");
        }
        // 2. 登录成功后生成 JWT
        // 3. 返回 token 给前端

        return jwtUtil.generateToken(user);
    }
}
