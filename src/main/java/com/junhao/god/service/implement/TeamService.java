package com.junhao.god.service.implement;
import com.junhao.god.entity.Team;
import java.util.List;
public interface TeamService {
    List<Team> findRelatedTeams(Long userId) throws Exception;
}
