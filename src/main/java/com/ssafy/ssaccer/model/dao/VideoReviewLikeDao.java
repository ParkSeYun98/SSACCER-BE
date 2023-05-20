package com.ssafy.ssaccer.model.dao;

import com.ssafy.ssaccer.model.dto.User;
import com.ssafy.ssaccer.model.dto.VideoReview;
import com.ssafy.ssaccer.model.dto.VideoReviewLike;
import com.ssafy.ssaccer.model.dto.VideoReviewLikeInfo;
import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@ApiModel(value = "VideoReviewLike DAO")
@Repository
public interface VideoReviewLikeDao {

    int addLike(HashMap<String, Integer> map);

    VideoReviewLikeInfo selectReviewLike(HashMap<String, Integer> map);

    List<VideoReview> selectLikeByUserSeq(int userSeq);

    List<User> selectLikeByReviewSeq(int reviewSeq);

    int cancelLike(HashMap<String, Integer> map);
}
