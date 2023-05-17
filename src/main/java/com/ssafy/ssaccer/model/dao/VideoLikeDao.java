package com.ssafy.ssaccer.model.dao;

import com.ssafy.ssaccer.model.dto.User;
import com.ssafy.ssaccer.model.dto.Video;
import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@ApiModel(value = "VideoLike DAO")
@Repository
public interface VideoLikeDao {

    int addVideoLike(HashMap<Integer, Integer> map);

    List<User> selectVideoLikeByUserSeq(int userSeq);

    List<Video> selectUserLikeByVideoSeq(int videoSeq);

    int cancelVideoLike(HashMap<Integer, Integer> map);
}
