package com.ssafy.ssaccer.controller;

import com.ssafy.ssaccer.model.service.VideoLikeService;
import io.swagger.annotations.ApiModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiModel(value="VideoLike RestController")
@RequiredArgsConstructor
@RestController
@RequestMapping("/VideoLike")
public class VideoLikeRestController {

    private final VideoLikeService videoLikeService;

    private final String SUCCESS = "SUCCESS";
    private final String FAIL = "FAIL";
}
