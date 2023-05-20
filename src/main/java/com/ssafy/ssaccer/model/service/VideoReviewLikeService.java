package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dto.User;
import com.ssafy.ssaccer.model.dto.VideoReview;
import com.ssafy.ssaccer.model.dto.VideoReviewLike;
import io.swagger.annotations.ApiModel;

import java.util.HashMap;
import java.util.List;
@ApiModel(value = "VideoReviewLike Service")
public interface VideoReviewLikeService {

    int createLike(HashMap<String, Integer> map);

    VideoReviewLike readReviewLike(HashMap<String, Integer> map);

    List<VideoReview> readLikeByUserSeq(int userSeq);

    List<User> readLikeByReviewSeq(int reviewSeq);

    int deleteLike(HashMap<String, Integer> map);
}
