package com.ssafy.ssaccer.controller;

import com.ssafy.ssaccer.model.dto.SoccerXY;
import com.ssafy.ssaccer.model.service.SoccerXYService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiModel(value="SoccerXY RestController")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET , RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor
@RestController
@RequestMapping("/soccerxy")
public class SoccerXYRestController {

    private final SoccerXYService sService;

    @ApiOperation(value = "soccerxy db 데이터 리스트 받기")
    @GetMapping("/list")
    public ResponseEntity<?> getSoccerXYList() {

        try {
            List<SoccerXY>  soccerXYList = sService.readLocationList();

            if(soccerXYList != null)
                return new ResponseEntity<List<SoccerXY>>(soccerXYList, HttpStatus.OK);
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
