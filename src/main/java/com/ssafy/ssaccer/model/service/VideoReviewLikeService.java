package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dto.User;
import com.ssafy.ssaccer.model.dto.VideoReview;
import com.ssafy.ssaccer.model.dto.VideoReviewLike;
import com.ssafy.ssaccer.model.dto.VideoReviewLikeInfo;
import io.swagger.annotations.ApiModel;

import java.util.HashMap;
import java.util.List;
@ApiModel(value = "VideoReviewLike Service")
public interface VideoReviewLikeService {

    int createLike(HashMap<String, Integer> map);

    VideoReviewLikeInfo readReviewLike(HashMap<String, Integer> map);

    List<VideoReviewLikeInfo> readLikeByUserSeq(int userSeq);

    List<VideoReviewLikeInfo> readLikeByReviewSeq(int reviewSeq);

    int deleteLike(HashMap<String, Integer> map);
}
