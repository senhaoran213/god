package com.junhao.god.controller;

import com.junhao.god.entity.Team;
import com.junhao.god.service.implement.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/list")
    public List<Team> findRelatedTeams(@RequestParam Long userId) {
        return teamService.findRelatedTeams(userId);
    }
}

