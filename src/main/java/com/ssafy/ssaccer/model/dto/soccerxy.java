package com.ssafy.ssaccer.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "soccerxy DTO")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class soccerxy {

    private String ps;

    private int x;

    private int y;

    private String name;

    private String year;
}
