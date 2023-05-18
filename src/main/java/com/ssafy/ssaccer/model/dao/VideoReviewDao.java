package com.ssafy.ssaccer.model.dao;

import com.ssafy.ssaccer.model.dto.VideoReview;
import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@ApiModel(value = "VideoReview DAO")
@Repository
public interface VideoReviewDao {

    int insertReview(VideoReview review);

    VideoReview selectReview(int reviewSeq);

    List<VideoReview> selectReviewList();

    List<VideoReview> selectReviewListByVideoSeq(int videoSeq);

    int modifyReview(VideoReview review);

    int removeReview(int reviewSeq);

    int addViewCnt(int reviewSeq);
}
