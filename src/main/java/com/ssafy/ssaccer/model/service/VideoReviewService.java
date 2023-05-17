package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dto.VideoReview;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(value = "VideoReview Service")
public interface VideoReviewService {

    int createReview(VideoReview review);

    VideoReview readReviewByReviewSeq(int reviewSeq);

    List<VideoReview> readReviewList();

    int updateReview(VideoReview review);

    int deleteReviewByReviewSeq(int reviewSeq);

    int addViewCntByReviewSeq(int reviewSeq);
}
