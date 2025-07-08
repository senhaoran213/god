package com.junhao.god.mapper;
import com.junhao.god.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE id = #{id}")
    List<User> findUserById(Long id);

    @Insert("INSERT INTO user(username,password,phone,kaoyan_code,subject_codes) VALUES(#{username}, #{password},#{phone},#{kaoyanCode},#{subjectCodes})")
    int insertUser(User user);

    @Update("UPDATE user SET username = #{username}, password = #{password},phone = #{phone},kaoyan_code = #{kaoyanCode},subject_codes = #{subjectCodes} WHERE id = #{id}")
    int updateUser(User user);

}
