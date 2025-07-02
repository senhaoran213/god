package com.junhao.god.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    //restful风格的接口
    
    @Autowired

    @PostMapping("/follow")
    public String followQuestion(@RequestParam("question_id") String questionId) {
        return "成功关注问题 ID：" + questionId;
    }

    @GetMapping("/latest-questions")
    public List<String> getLatestQuestions() {
        return List.of();
    }
}
