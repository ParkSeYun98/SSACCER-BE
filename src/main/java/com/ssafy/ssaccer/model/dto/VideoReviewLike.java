package com.ssafy.ssaccer.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "VideoReviewLike DTO")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class VideoReviewLike {

    private int likeSeq;

    private int userSeq;

    private int reviewSeq;
}
