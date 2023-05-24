package com.ssafy.ssaccer.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "Team DTO")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class TeamDTO {

    // Team

    private int teamSeq;

    private int userSeq;

    private int articleSeq;

    // User

    private String name;

    private String nickname;

    private Role role;

    private Position position;

    private String phoneNumber;

    private String img;

    // Article

    private Ability ability;

    private Status status;

    private Gender gender;
}
