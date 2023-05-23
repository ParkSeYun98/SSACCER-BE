package com.ssafy.ssaccer.controller;

import com.ssafy.ssaccer.model.dto.RegionCode;
import com.ssafy.ssaccer.model.service.RegionCodeService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiModel(value="RegionCode RestController")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET , RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor
@RestController
@RequestMapping("/regioncode")
public class RegionCodeRestController {

    private final RegionCodeService rcService;

    @ApiOperation(value = "RegionCode db 데이터 리스트 받기")
    @GetMapping("/list")
    public ResponseEntity<?> getRegionCodeList() {

        try {
            List<RegionCode> regionCodeList = rcService.getAllRegionCodeList();

            if(regionCodeList != null)
                return new ResponseEntity<List<RegionCode>>(regionCodeList, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "입력받은 String 값과 유사한 RegionCode db 데이터 리스트 받기")
    @GetMapping("/list/{region}")
    public ResponseEntity<?> searchPartRegionCodeList(@PathVariable String region) {

        try {
            List<RegionCode> regionCodeList = rcService.searchPartRegionCodeList(region);

            if(regionCodeList != null)
                return new ResponseEntity<List<RegionCode>>(regionCodeList, HttpStatus.OK);
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
