package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dao.BigRegionCodeDao;
import com.ssafy.ssaccer.model.dto.BigRegionCode;
import io.swagger.annotations.ApiModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@ApiModel(value="BigRegionCode Service Implementation")
@RequiredArgsConstructor
@Service
public class BigRegionCodeServiceImpl implements BigRegionCodeService{

    private final BigRegionCodeDao dao;

    @Override
    public List<BigRegionCode> getAllBigRegionCodeList() {
        return dao.selectAllBigRegionCodeList();
    }

    @Override
    public List<BigRegionCode> searchPartBigRegionCodeList(String Bigregion) {
        return dao.selectPartBigRegionCodeList(Bigregion);
    }
}
