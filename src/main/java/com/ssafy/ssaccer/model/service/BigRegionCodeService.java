package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dto.BigRegionCode;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(value = "BigRegionCode Service")
public interface BigRegionCodeService {

    List<BigRegionCode> getAllBigRegionCodeList();

    List<BigRegionCode> searchPartBigRegionCodeList(String Bigregion);
}
