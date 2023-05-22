package com.ssafy.ssaccer.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "User DTO")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class WeatherDTO {

    private String baseDate;

    private String baseTime;

    private String nx;

    private String ny;
}
