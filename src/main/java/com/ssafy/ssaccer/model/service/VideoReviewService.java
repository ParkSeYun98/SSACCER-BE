package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dto.VideoReview;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(value = "VideoReview Service")
public interface VideoReviewService {

    int createReview(VideoReview review);

    VideoReview readReview(int reviewSeq);

    List<VideoReview> readReviewList();

    List<VideoReview> readReviewListByVideoSeq(int videoSeq);

    int updateReview(VideoReview review);

    int deleteReview(int reviewSeq);

    int addViewCnt(int reviewSeq);
}
