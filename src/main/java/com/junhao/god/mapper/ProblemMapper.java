package com.junhao.god.mapper;

import com.junhao.god.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProblemMapper {
    @Select("select * from question;")
    List<Question> getProblem();
}
