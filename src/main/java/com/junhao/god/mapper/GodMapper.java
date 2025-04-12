package com.junhao.god.mapper;

import com.junhao.god.entity.GodTable;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GodMapper {

    @Select("SELECT * FROM god_table")
    List<GodTable> findAll();

    @Insert("INSERT INTO god_table(name, god_column) VALUES(#{name}, #{god_column})")
    void insertUser(GodTable user);

    @Update("UPDATE god_table SET name = #{name}, god_column = #{god_column} WHERE id = #{id}")
    void updateUser(GodTable user);

    @Delete("DELETE FROM god_table WHERE id = #{id}")
    void deleteUser(Long id);
} 