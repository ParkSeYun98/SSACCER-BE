package com.ssafy.ssaccer.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "Team DTO")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Team {

    private int teamSeq;

    private int userSeq;

    private int articleSeq;
}
