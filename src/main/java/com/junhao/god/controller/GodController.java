package com.junhao.god.controller;

import com.junhao.god.entity.GodTable;
import com.junhao.god.mapper.GodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("god")
public class GodController {
    @Autowired
    private GodMapper godMapper;

    // 查询所有
    @GetMapping
    public List<GodTable> getAllUsers() {
        return godMapper.findAll();
    }

    // 添加
    @PostMapping
    public void addUser(@RequestBody GodTable user) {
        godMapper.insertUser(user);
    }

    // 更新
    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody GodTable user) {
        user.setId(id);
        godMapper.updateUser(user);
    }

    // 删除
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        godMapper.deleteUser(id);
    }

}
