package com.ssafy.ssaccer.controller;

import com.ssafy.ssaccer.model.dto.BigRegionCode;
import com.ssafy.ssaccer.model.service.BigRegionCodeService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiModel(value="BigRegionCode RestController")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET , RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor
@RestController
@RequestMapping("/bigregioncode")
public class BigRegionCodeRestController {

    private final BigRegionCodeService brcService;

    @ApiOperation(value = "BigRegionCode db 데이터 리스트 받기")
    @GetMapping("/list")
    public ResponseEntity<?> getBigRegionCodeList() {

        try {
            List<BigRegionCode> bigRegionCodeList = brcService.getAllBigRegionCodeList();

            if(bigRegionCodeList != null)
                return new ResponseEntity<List<BigRegionCode>>(bigRegionCodeList, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "입력받은 String 값과 유사한 BigRegionCode db 데이터 리스트 받기")
    @GetMapping("/list/{bigregion}")
    public ResponseEntity<?> searchPartBigRegionCodeList(@PathVariable String bigregion) {

        try {
            List<BigRegionCode> bigRegionCodeList = brcService.searchPartBigRegionCodeList(bigregion);

            if(bigRegionCodeList != null)
                return new ResponseEntity<List<BigRegionCode>>(bigRegionCodeList, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    private ResponseEntity<String> exceptionHandling(Exception e) {

        e.printStackTrace();

        return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
