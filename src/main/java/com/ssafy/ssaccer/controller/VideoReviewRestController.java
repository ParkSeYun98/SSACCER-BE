package com.ssafy.ssaccer.controller;

import com.ssafy.ssaccer.model.service.VideoReviewService;
import io.swagger.annotations.ApiModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiModel(value="VideoReview RestController")
@RequiredArgsConstructor
@RestController
@RequestMapping("/VideoReview")
public class VideoReviewRestController {

    private final VideoReviewService videoReviewService;

    private final String SUCCESS = "SUCCESS";
    private final String FAIL = "FAIL";
}
