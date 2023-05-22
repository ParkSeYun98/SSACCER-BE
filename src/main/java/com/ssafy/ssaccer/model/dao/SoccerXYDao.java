package com.ssafy.ssaccer.model.dao;

import com.ssafy.ssaccer.model.dto.SoccerXY;
import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@ApiModel(value = "SoccerXY DAO")
@Repository
public interface SoccerXYDao {

    List<SoccerXY> selectLocationList();
}
