package com.junhao.god.mapper;

import com.junhao.god.entity.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeamMapper {

    @Select("""
             SELECT t.*
             FROM team t
             JOIN (
                 SELECT sm.subject_code
                 FROM user u
                 JOIN subject_mapping sm ON u.kaoyan_code = sm.kaoyan_code
                 WHERE u.id = #{userId}
             ) AS related_subjects
             ON t.subject_code = related_subjects.subject_code
            """)
    List<Team> getRelatedTeam(@Param("userId") Long userId);

    @Select("""
                select kaoyan_code from user_info where id = #{userId}
            """)
    String getkaoyanCode(@Param("userId") Long userId);

    List<Long> getSubjects(@Param("kaoyanCode") String kaoyanCode);

    List<Team> getTeamsBySubjects(@Param("list") List<Long> subjectsCode);

}
