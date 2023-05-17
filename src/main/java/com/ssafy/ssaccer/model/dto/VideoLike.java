package com.ssafy.ssaccer.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "VideoLike DTO")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class VideoLike {

    private int reviewSeq;

    private int userSeq;
}
