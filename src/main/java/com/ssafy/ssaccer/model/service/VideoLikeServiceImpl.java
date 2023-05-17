package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dao.VideoLikeDao;
import io.swagger.annotations.ApiModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@ApiModel(value="VideoLike Service Implementation")
@RequiredArgsConstructor
@Service
public class VideoLikeServiceImpl implements VideoLikeService {

    private final VideoLikeDao videoLikeDao;
}
