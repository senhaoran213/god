package com.junhao.god.controller;

import com.junhao.god.common.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class CommonController {
    @PostMapping("login")
    public R login(@RequestParam("username") String username, @RequestParam("password") String password) {
        Object token = null;
        return R.ok("登录成功",token);
    }

}
