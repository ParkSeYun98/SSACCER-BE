package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dao.VideoReviewLikeDao;
import com.ssafy.ssaccer.model.dto.User;
import com.ssafy.ssaccer.model.dto.VideoReview;
import com.ssafy.ssaccer.model.dto.VideoReviewLike;
import com.ssafy.ssaccer.model.dto.VideoReviewLikeInfo;
import io.swagger.annotations.ApiModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@ApiModel(value="VideoReviewLike Service Implementation")
@RequiredArgsConstructor
@Service
public class VideoReviewLikeServiceImpl implements VideoReviewLikeService {

    private final VideoReviewLikeDao dao;

    @Override
    public int createLike(HashMap<String, Integer> map) {
        return dao.addLike(map);
    }

    @Override
    public VideoReviewLikeInfo readReviewLike(HashMap<String, Integer> map) {
        return dao.selectReviewLike(map);
    }

    @Override
    public List<VideoReview> readLikeByUserSeq(int userSeq) {
        return dao.selectLikeByUserSeq(userSeq);
    }

    @Override
    public List<User> readLikeByReviewSeq(int reviewSeq) {
        return dao.selectLikeByReviewSeq(reviewSeq);
    }

    @Override
    public int deleteLike(HashMap<String, Integer> map) {
        return dao.cancelLike(map);
    }


}
