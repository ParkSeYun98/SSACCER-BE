package com.ssafy.ssaccer.controller;

import com.ssafy.ssaccer.model.service.VideoService;
import io.swagger.annotations.ApiModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiModel(value="Video RestController")
@RequiredArgsConstructor
@RestController
@RequestMapping("/Video")
public class VideoRestController {

    private final VideoService videoService;

    private final String SUCCESS = "SUCCESS";
    private final String FAIL = "FAIL";
}
