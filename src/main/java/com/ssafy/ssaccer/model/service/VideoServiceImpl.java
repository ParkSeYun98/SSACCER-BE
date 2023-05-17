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

    private final VideoDao videoDao;

    @Override
    public int createVideo(Video video) {
        return videoDao.insertVideo(video);
    }

    @Override
    public Video readVideoByYoutubeId(String youtubeId) {
        return videoDao.selectVideoByYoutubeId(youtubeId);
    }

    @Override
    public Video readVideoByVideoSeq(int videoSeq) {
        return videoDao.selectVideoByVideoSeq(videoSeq);
    }

    @Override
    public List<Video> readVideoList() {
        return videoDao.selectVideoList();
    }

    @Override
    public int updateVideo(Video video) {
        return videoDao.modifyVideo(video);
    }

    @Override
    public int deleteVideoByYoutubeId(String youtubeId) {
        return videoDao.removeVideoByYoutubeId(youtubeId);
    }

    @Override
    public int deleteVideoByVideoSeq(int videoSeq) {
        return videoDao.removeVideoByVideoSeq(videoSeq);
    }
}
