package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dto.Team;
import io.swagger.annotations.ApiModel;

import java.util.HashMap;
import java.util.List;

@ApiModel(value = "Team Service")
public interface TeamService {

    int createMemberToTeam(HashMap<String, Integer> map);

    Team readUserTeam(HashMap<String, Integer> map);

    List<Team> readTeamList();

    List<Team> readMemberListInTeam(int articleSeq);

    List<Team> readTeamListFromUser(int userSeq);

    int removeMemberFromTeam(HashMap<String, Integer> map);
}
