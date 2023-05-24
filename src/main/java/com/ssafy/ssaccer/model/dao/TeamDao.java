package com.ssafy.ssaccer.model.dao;

import com.ssafy.ssaccer.model.dto.Team;
import com.ssafy.ssaccer.model.dto.TeamDTO;
import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@ApiModel(value = "Team DAO")
@Repository
public interface TeamDao {

    int insertMemberToTeam(HashMap<String, Integer> map);

    TeamDTO selectUserTeam(HashMap<String, Integer> map);

    List<TeamDTO> selectTeamList();

    List<TeamDTO> selectMemberListInTeam(int articleSeq);

    List<TeamDTO> selectTeamsListFromUser(int userSeq);

    int removeMemberFromTeam(HashMap<String, Integer> map);
}
