package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dto.Team;
import com.ssafy.ssaccer.model.dto.TeamDTO;
import io.swagger.annotations.ApiModel;

import java.util.HashMap;
import java.util.List;

@ApiModel(value = "Team Service")
public interface TeamService {

    int createMemberToTeam(HashMap<String, Integer> map);

    TeamDTO readUserTeam(HashMap<String, Integer> map);

    List<TeamDTO> readTeamList();

    List<TeamDTO> readMemberListInTeam(int articleSeq);

    List<TeamDTO> readTeamListFromUser(int userSeq);

    int removeMemberFromTeam(HashMap<String, Integer> map);
}
