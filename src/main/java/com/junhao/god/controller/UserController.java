package com.junhao.god.controller;

import com.junhao.god.common.R;
import com.junhao.god.entity.UserTable;
import com.junhao.god.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    // 🔍 查询所有用户
    @GetMapping
    public List<UserTable> getAllUsers() {
        return userMapper.findAll();
    }

    // ✅ 添加新用户
    @PostMapping
    public String createUser(@RequestBody UserTable user) {
        user.setCreateTime(new Date());
        user.setDelFlag("0");
        userMapper.insertUser(user);
        return "用户添加成功";
    }

    // ✏️ 更新用户信息
    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody UserTable user) {
        user.setId(id);
        user.setUpdateTime(new Date());
        userMapper.updateUser(user);
        return "用户更新成功";
    }

    // ❌ 逻辑删除用户
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userMapper.softDeleteUser(id);
        return "用户已删除";
    }

    // 🔐 登录接口
    @PostMapping("/login")
    public R login(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");
        List<UserTable> users = userMapper.findAll();
        for (UserTable u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return R.ok("登录成功", u);
            }
        }
        return R.fail("账号或密码错误");
    }
}
