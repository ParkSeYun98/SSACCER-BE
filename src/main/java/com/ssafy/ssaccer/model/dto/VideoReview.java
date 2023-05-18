package com.ssafy.ssaccer.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "VideoReview DTO")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class VideoReview {

    private int reviewSeq;

    private int userSeq;

    private int videoSeq;

    private String title;

    private String content;

    private int viewCnt;

    private String createdDate;
}
