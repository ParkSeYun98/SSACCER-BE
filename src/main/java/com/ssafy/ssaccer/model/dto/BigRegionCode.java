package com.ssafy.ssaccer.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "BigRegionCode DTO")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class BigRegionCode {

    private int bigregioncodeSeq;

    private String bigRegion;

    private String bigCode;
}
