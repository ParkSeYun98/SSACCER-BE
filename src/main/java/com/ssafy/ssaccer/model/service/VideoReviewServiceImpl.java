package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dao.VideoReviewDao;
import com.ssafy.ssaccer.model.dto.VideoReview;
import io.swagger.annotations.ApiModel;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@ApiModel(value="VideoReview Service Implementation")
@RequiredArgsConstructor
@Service
public class VideoReviewServiceImpl implements VideoReviewService {
	
	
    private final VideoReviewDao dao;


    @Override
    public int createReview(VideoReview review) {
        return dao.insertReview(review);
    }

    @Override
    public VideoReview readReview(int reviewSeq) {
        return dao.selectReview(reviewSeq);
    }

    @Override
    public List<VideoReview> readReviewList() {
        return dao.selectReviewList();
    }

    @Override
    public List<VideoReview> readReviewListByVideoSeq(int videoSeq) {
        return dao.selectReviewListByVideoSeq(videoSeq);
    }

    @Override
    public int updateReview(VideoReview review) {
        return dao.modifyReview(review);
    }

    @Override
    public int deleteReview(int reviewSeq) {
        return dao.removeReview(reviewSeq);
    }

    @Override
    public int addViewCnt(int reviewSeq) {
        return dao.addViewCnt(reviewSeq);
    }
}
