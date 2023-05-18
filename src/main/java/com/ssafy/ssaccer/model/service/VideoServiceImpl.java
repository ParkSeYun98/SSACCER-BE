package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dao.VideoDao;
import com.ssafy.ssaccer.model.dto.Video;
import io.swagger.annotations.ApiModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@ApiModel(value="Video Service Implementation")
@RequiredArgsConstructor
@Service
public class VideoServiceImpl implements VideoService {

    private final VideoDao dao;

    @Override
    public int createVideo(Video video) {
        return dao.insertVideo(video);
    }

    @Override
    public Video readVideoByYoutubeId(String youtubeId) {
        return dao.selectVideoByYoutubeId(youtubeId);
    }

    @Override
    public Video readVideoByVideoSeq(int videoSeq) {
        return dao.selectVideoByVideoSeq(videoSeq);
    }

    @Override
    public List<Video> readVideoList() {
        return dao.selectVideoList();
    }

    @Override
    public int updateVideo(Video video) {
        return dao.modifyVideo(video);
    }

    @Override
    public int deleteVideoByYoutubeId(String youtubeId) {
        return dao.removeVideoByYoutubeId(youtubeId);
    }

    @Override
    public int deleteVideoByVideoSeq(int videoSeq) {
        return dao.removeVideoByVideoSeq(videoSeq);
    }
}
