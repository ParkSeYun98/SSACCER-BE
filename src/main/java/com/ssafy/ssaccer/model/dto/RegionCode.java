package com.ssafy.ssaccer.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "RegionCode DTO")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class RegionCode {

    private int regioncodeSeq;

    private String region;

    private String code;
}
