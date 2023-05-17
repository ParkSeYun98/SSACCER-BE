package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dao.VideoReviewDao;
import com.ssafy.ssaccer.model.dto.VideoReview;
import io.swagger.annotations.ApiModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@ApiModel(value="VideoReview Service Implementation")
@RequiredArgsConstructor
@Service
public class VideoReviewServiceImpl implements VideoReviewService {

    private final VideoReviewDao videoReviewDao;

    @Override
    public int createReview(VideoReview review) {
        return videoReviewDao.insertReview(review);
    }

    @Override
    public VideoReview readReviewByReviewSeq(int reviewSeq) {
        return videoReviewDao.selectReview(reviewSeq);
    }

    @Override
    public List<VideoReview> readReviewList() {
        return videoReviewDao.selectReviewList();
    }

    @Override
    public int updateReview(VideoReview review) {
        return videoReviewDao.modifyReview(review);
    }

    @Override
    public int deleteReviewByReviewSeq(int reviewSeq) {
        return videoReviewDao.removeReview(reviewSeq);
    }

    @Override
    public int addViewCntByReviewSeq(int reviewSeq) {
        return videoReviewDao.addViewCnt(reviewSeq);
    }
}
