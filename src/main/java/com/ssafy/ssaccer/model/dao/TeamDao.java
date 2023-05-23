package com.ssafy.ssaccer.model.dao;

import com.ssafy.ssaccer.model.dto.Team;
import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@ApiModel(value = "Team DAO")
@Repository
public interface TeamDao {

    int insertMemberToTeam(HashMap<String, Integer> map);

    Team selectUserTeam(HashMap<String, Integer> map);

    List<Team> selectTeamList();

    List<Team> selectMemberListInTeam(int articleSeq);

    List<Team> selectTeamsListFromUser(int userSeq);

    int removeMemberFromTeam(HashMap<String, Integer> map);
}
