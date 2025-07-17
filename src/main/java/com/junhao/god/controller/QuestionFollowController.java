package com.junhao.god.controller;

import com.junhao.god.common.Result;
import com.junhao.god.service.implement.QuestionFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("follow")
public class QuestionFollowController {
    @Autowired
    private QuestionFollowService followService;

    @PostMapping
    public Result follow(@RequestBody Map<String, Long> data) {
        Long userId = data.get("userId");
        Long questionId = data.get("questionId");
        followService.followQuestion(userId, questionId);

        return Result.success("关注成功") ;
    }

}
