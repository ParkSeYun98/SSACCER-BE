package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dto.SoccerXY;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(value = "SoccerXY Service")
public interface SoccerXYService {

    List<SoccerXY> readLocationList();
}
