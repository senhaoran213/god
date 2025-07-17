package com.junhao.god.service;
import com.junhao.god.common.exception.BusinessException;
import com.junhao.god.entity.Team;
import com.junhao.god.mapper.TeamMapper;
import com.junhao.god.service.implement.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamMapper teamMapper;

    /**
     * 先查用户的 kaoyan_code；
     * 去 subject_mapping 查所有科目；
     * 查询匹配 subject_code 的所有队伍；
     * 按当前人数从少到多排序
     * @param userId
     * @return
     */
    @Override
    public List<Team> findRelatedTeams(Long userId) {
        //subject_mapping、team、user
        //查询当前用户关联科目相关队伍
//        + 先查用户的 `kaoyan_code`；
        
        String koayanCode = teamMapper.getkaoyanCode(userId);
//        + 去 `subject_mapping` 查所有科目；
        List<Long> subjectCodes = teamMapper.getSubjects(koayanCode);
//        + 查询匹配 `subject_code` 的所有队伍；
        //从数据里拿数据
        if (subjectCodes == null || subjectCodes.isEmpty()) {
            throw new BusinessException("没有对应的队伍");
        }

        List<Team> team = teamMapper.getTeamsBySubjects(subjectCodes);
//        + 按当前人数从少到多排序
        //排序
        //stream
        team.sort(Comparator.comparing(Team::getMemberCount));
        return team;
    }
}
