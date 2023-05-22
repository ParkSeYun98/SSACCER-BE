package com.ssafy.ssaccer.model.dao;

import com.ssafy.ssaccer.model.dto.RegionCode;
import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@ApiModel(value = "RegionCode DAO")
@Repository
public interface RegionCodeDao {

    List<RegionCode> selectAllRegionCodeList();

    List<RegionCode> selectPartRegionCodeList(String region);
}
