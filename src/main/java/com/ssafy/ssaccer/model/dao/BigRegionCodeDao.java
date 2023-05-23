package com.ssafy.ssaccer.model.dao;

import com.ssafy.ssaccer.model.dto.BigRegionCode;
import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@ApiModel(value = "BigRegionCode DAO")
@Repository
public interface BigRegionCodeDao {

    List<BigRegionCode> selectAllBigRegionCodeList();

    List<BigRegionCode> selectPartBigRegionCodeList(String bigRegion);
}
