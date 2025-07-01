package com.junhao.god.controller;

import com.junhao.god.entity.Question;
import com.junhao.god.service.implement.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("problem")
public class ProblemController {
    @Autowired
    private ProblemService problemService;
    // 查询所有
    @GetMapping
    public List<Question> getProblem() {
        return problemService.getProblem();
    }

}
