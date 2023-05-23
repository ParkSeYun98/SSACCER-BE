package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dao.TeamDao;
import com.ssafy.ssaccer.model.dto.Team;
import io.swagger.annotations.ApiModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;

@ApiModel(value="Team Service Implementation")
@RequiredArgsConstructor
@Service
public class TeamServiceImpl implements TeamService {

    private final TeamDao dao;

    @Override
    public int createMemberToTeam(HashMap<String, Integer> map) {
        return dao.insertMemberToTeam(map);
    }

    @Override
    public Team readUserTeam(HashMap<String, Integer> map) {
        return dao.selectUserTeam(map);
    }

    @Override
    public List<Team> readTeamList() {
        return dao.selectTeamList();
    }

    @Override
    public List<Team> readMemberListInTeam(int articleSeq) {
        return dao.selectMemberListInTeam(articleSeq);
    }

    @Override
    public List<Team> readTeamListFromUser(int userSeq) {
        return dao.selectTeamsListFromUser(userSeq);
    }

    @Override
    public int removeMemberFromTeam(HashMap<String, Integer> map) {
        return dao.removeMemberFromTeam(map);
    }
}
