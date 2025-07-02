package com.junhao.god.mapper;

import com.junhao.god.entity.GodTable;
import com.junhao.god.entity.QuestionFollow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface QuestionFollowMapper {
    @Insert("INSERT INTO question_follow(user_id,question_id,follow_time) VALUES( #{userId},#{questionId},now())")
    int insertUser(@Param("userId") Long userId, @Param("questionId") Long questionId);

    @Select("""
    select * from question_follow where user_id=#{userId} and question_id=#{questionId}
""")
    int hasFollow(@Param("userId") Long userId, @Param("questionId") Long questionId);
}
