package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dto.RegionCode;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(value = "RegionCode Service")
public interface RegionCodeService {

    List<RegionCode> getAllRegionCodeList();

    List<RegionCode> searchPartRegionCodeList(String region);
}
