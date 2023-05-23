package com.ssafy.ssaccer.controller;

import com.ssafy.ssaccer.model.dto.Team;
import com.ssafy.ssaccer.model.service.TeamService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@ApiModel(value="VideoReviewLike RestController")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET , RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor
@RestController
@RequestMapping("/team")
public class TeamRestController {

    private final TeamService tService;

    @ApiOperation(value = "Team 등록")
    @PostMapping("/regist/{userSeq}/{articleSeq}")
    public ResponseEntity<?> join(@PathVariable int userSeq, @PathVariable int articleSeq) {

        try {
            HashMap<String, Integer> map = new HashMap<>();

            map.put("userSeq", userSeq);
            map.put("articleSeq", articleSeq);

            int result = tService.createMemberToTeam(map);

            if(result != 0)
                return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
            else
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "Team 객체 읽기")
    @GetMapping("/read/{userSeq}/{articleSeq}")
    public ResponseEntity<?> getTeam(@PathVariable int userSeq, @PathVariable int articleSeq) {

        try {
            HashMap<String, Integer> map = new HashMap<>();

            map.put("userSeq", userSeq);
            map.put("articleSeq", articleSeq);

            Team team = tService.readUserTeam(map);

            if(team != null)
                return new ResponseEntity<Team>(team, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "팀 리스트 읽기")
    @GetMapping("/read/list")
    public ResponseEntity<?> getTeamList() {

        try {
            List<Team> teamList = tService.readTeamList();

            if(teamList != null)
                return new ResponseEntity<List<Team>>(teamList, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "특정 팀에 속한 멤버들 읽기")
    @GetMapping("/readbyarticleseq/list/{articleSeq}")
    public ResponseEntity<?> getMemberListInTeam(@PathVariable int articleSeq) {

        try {
            List<Team> teamList = tService.readMemberListInTeam(articleSeq);

            if(teamList != null)
                return new ResponseEntity<List<Team>>(teamList, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "특정 유저가 속해있는 팀 읽기")
    @GetMapping("/readbyuserseq/list/{userSeq}")
    public ResponseEntity<?> getTeamListFromUser(@PathVariable int userSeq) {

        try {
            List<Team> teamList = tService.readTeamListFromUser(userSeq);

            if(teamList != null)
                return new ResponseEntity<List<Team>>(teamList, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "팀에서 나오기")
    @DeleteMapping("/delete/{userSeq}/{articleSeq}")
    public ResponseEntity<?> quitTeam(@PathVariable int userSeq, @PathVariable int articleSeq) {

        try {
            HashMap<String, Integer> map = new HashMap<>();

            map.put("userSeq", userSeq);
            map.put("articleSeq", articleSeq);

            int result = tService.removeMemberFromTeam(map);

            if(result != 0)
                return new ResponseEntity<Integer>(result, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    private ResponseEntity<String> exceptionHandling(Exception e) {

        e.printStackTrace();

        return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
