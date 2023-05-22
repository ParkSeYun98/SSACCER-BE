package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dao.RegionCodeDao;
import com.ssafy.ssaccer.model.dto.RegionCode;
import io.swagger.annotations.ApiModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@ApiModel(value="RegionCode Service Implementation")
@RequiredArgsConstructor
@Service
public class RegionCodeServiceImpl implements RegionCodeService{

    private final RegionCodeDao dao;

    @Override
    public List<RegionCode> getAllRegionCodeList() {
        return dao.selectAllRegionCodeList();
    }

    @Override
    public List<RegionCode> searchPartRegionCodeList(String region) {
        return dao.selectPartRegionCodeList(region);
    }
}
