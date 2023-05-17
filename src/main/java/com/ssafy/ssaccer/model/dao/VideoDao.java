package com.ssafy.ssaccer.model.dao;

import com.ssafy.ssaccer.model.dto.Video;
import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@ApiModel(value = "Video DAO")
@Repository
public interface VideoDao {

    int insertVideo(Video video);

    Video selectVideoByYoutubeId(String youtubeId);

    Video selectVideoByVideoSeq(int videoSeq);

    List<Video> selectVideoList();

    int modifyVideo(Video video);

    int removeVideoByYoutubeId(String youtubeId);

    int removeVideoByVideoSeq(int videoSeq);
}
