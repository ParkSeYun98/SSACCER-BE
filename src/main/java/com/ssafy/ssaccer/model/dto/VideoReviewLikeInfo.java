package com.ssafy.ssaccer.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "VideoReviewLikeInfo DTO")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class VideoReviewLikeInfo {

    // rlikes 테이블
    private int likeSeq;

    private int userSeq;

    private int reviewSeq;


    // users 테이블
//    private String


    // reviews 테이블

}
