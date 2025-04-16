package com.junhao.god.controller;

import com.junhao.god.entity.ValidateEntity;
import com.junhao.god.mapper.GodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("god")
public class ValidateController {
    @Autowired
    private GodMapper godMapper;

    @PostMapping("/manual-validate")
    public String manualValidate(@RequestBody ValidateEntity request) {

        // 字符串空判断
        if (request.getName() == null || request.getName().trim().isEmpty()) {
            return "名称不能为空";
        }

        // 集合为空判断
        if (request.getStringList() == null || request.getStringList().isEmpty()) {
            return "ID列表不能为空";
        }

        // 对象为 null 判断
        if (request == null) {
            return "inner 对象不能为空";
        }


        return "手动校验通过";
    }

    @PostMapping("/wonderful-validate")
    public String wonderfulValidate(@RequestBody ValidateEntity request) {

        // 字符串空判断
        if (StringUtils.hasText(request.getName())) {
            return "名称不能为空";
        }

        // 集合为空判断
        if (CollectionUtils.isEmpty(request.getStringList())) {
            return "ID列表不能为空";
        }

        // 对象为 null 判断
        if (Objects.isNull(request)) {
            return "inner 对象不能为空";
        }


        return "手动校验通过";
    }
    
}
