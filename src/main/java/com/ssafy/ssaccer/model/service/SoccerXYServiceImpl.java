package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dao.SoccerXYDao;
import com.ssafy.ssaccer.model.dto.SoccerXY;
import io.swagger.annotations.ApiModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@ApiModel(value="SoccerXY Service Implementation")
@RequiredArgsConstructor
@Service
public class SoccerXYServiceImpl implements SoccerXYService {

    private final SoccerXYDao dao;

    @Override
    public List<SoccerXY> readLocationList() {
        return dao.selectLocationList();
    }
}
