package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dto.User;
import com.ssafy.ssaccer.model.dto.Video;
import io.swagger.annotations.ApiModel;

import java.util.HashMap;
import java.util.List;

@ApiModel(value = "VideoLike Service")
public interface VideoLikeService {

    int createVideoLike(HashMap<Integer, Integer> map);

    List<User> readVideoLikeByUserSeq(int userSeq);

    List<Video> readVideoLikeByVideoSeq(int videoSeq);

    int deleteVideoLike(HashMap<Integer, Integer> map);
}
