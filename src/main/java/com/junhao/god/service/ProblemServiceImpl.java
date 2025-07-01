package com.junhao.god.service;

import com.junhao.god.entity.Question;
import com.junhao.god.mapper.ProblemMapper;
import com.junhao.god.service.implement.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemMapper problemMapper;

    @Override
    public List<Question> getProblem() {
        //从数据里拿数据
        List<Question> problem = problemMapper.getProblem();
        //排序
        //stream
        problem.sort(Comparator.comparing(Question::getHeat));
        return problem;
    }
}
