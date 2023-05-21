package com.ssafy.ssaccer.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "Video DTO")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Video {

    private int videoSeq;

    private String youtubeId;

    private String title;

    private String url;

    private String channelName;

    private String thumbnail;
}
