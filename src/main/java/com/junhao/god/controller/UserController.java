package com.junhao.god.controller;
import com.junhao.god.common.Result;
import com.junhao.god.entity.User;
import com.junhao.god.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public List<User> getUserById(@PathVariable Long id) {
        return userMapper.findUserById(id);
    }

    @PutMapping("/update/{id}")
    public Result updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        int row = userMapper.updateUser(user);
        return row > 0 ? Result.success("更新成功"): Result.warn("更新失败");
    }

    // 添加
    @PostMapping
    public Result addUser(@RequestBody User user) {
        int row = userMapper.insertUser(user);
        return row > 0 ? Result.success("添加成功"): Result.warn("添加失败");
    }
}
