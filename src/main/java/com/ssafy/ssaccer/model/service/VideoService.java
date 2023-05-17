package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dto.Video;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(value = "Video Service")
public interface VideoService {

    int createVideo(Video video);

    Video readVideoByYoutubeId(String youtubeId);

    Video readVideoByVideoSeq(int videoSeq);

    List<Video> readVideoList();

    int updateVideo(Video video);

    int deleteVideoByYoutubeId(String youtubeId);

    int deleteVideoByVideoSeq(int videoSeq);
}
