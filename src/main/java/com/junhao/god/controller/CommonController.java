package com.junhao.god.controller;

import com.junhao.god.common.R;
import com.junhao.god.common.Result;
import com.junhao.god.service.implement.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class CommonController {
    @Autowired
    private CommonService commonService;
    @PostMapping("login")
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password) {
        String result = commonService.login(username,password);
        return Result.success(result);
    }

}
