package com.junhao.god.service;
import com.junhao.god.entity.Team;
import com.junhao.god.mapper.TeamMapper;
import com.junhao.god.service.implement.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamMapper teamMapper;

    @Override
    public List<Team> findRelatedTeams(Long userId) {
        //从数据里拿数据
        List<Team> team = teamMapper.getTeam(userId);
        //排序
        //stream
        team.sort(Comparator.comparing(Team::getMemberCount));
        return team;
    }
}
