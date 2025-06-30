package com.junhao.god.mapper;

import com.junhao.god.entity.UserTable;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE del_flag = '0'")
    List<UserTable> findAll();

    @Insert("""
        INSERT INTO user (username, password, phone, wechat, subject, major, status, create_by, create_time, update_by, update_time, del_flag)
        VALUES (#{username}, #{password}, #{phone}, #{wechat}, #{subject}, #{major}, #{status}, #{createBy}, #{createTime}, #{updateBy}, #{updateTime}, #{delFlag})
    """)
    void insertUser(UserTable user);

    @Update("""
        UPDATE user SET 
            username = #{username},
            password = #{password},
            phone = #{phone},
            wechat = #{wechat},
            subject = #{subject},
            major = #{major},
            status = #{status},
            update_by = #{updateBy},
            update_time = #{updateTime}
        WHERE id = #{id}
    """)
    void updateUser(UserTable user);

    @Delete("UPDATE user SET del_flag = '2' WHERE id = #{id}")
    void softDeleteUser(Long id);  // 逻辑删除

    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteUserPermanently(Long id);  // 真删除（不推荐）
}
