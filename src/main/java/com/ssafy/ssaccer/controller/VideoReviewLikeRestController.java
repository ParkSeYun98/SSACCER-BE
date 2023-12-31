package com.ssafy.ssaccer.controller;

import com.ssafy.ssaccer.model.dto.User;
import com.ssafy.ssaccer.model.dto.VideoReview;
import com.ssafy.ssaccer.model.dto.VideoReviewLikeInfo;
import com.ssafy.ssaccer.model.service.VideoReviewLikeService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@ApiModel(value="VideoReviewLike RestController")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET , RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor
@RestController
@RequestMapping("/rlike")
public class VideoReviewLikeRestController {

    private final VideoReviewLikeService lService;

    @ApiOperation(value = "좋아요")
    @PostMapping("/like/{userSeq}/{reviewSeq}")
    public ResponseEntity<?> Like(@PathVariable int userSeq, @PathVariable int reviewSeq) {

        try {
            HashMap<String, Integer> map = new HashMap<>();

            map.put("userSeq", userSeq);
            map.put("reviewSeq", reviewSeq);

            int result = lService.createLike(map);

            if(result != 0)
                return new ResponseEntity<Integer>(result, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);

        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }
    
    @ApiOperation(value = "좋아요 취소")
    @DeleteMapping("/unlike/{userSeq}/{reviewSeq}")
    public ResponseEntity<?> unlike(@PathVariable int userSeq, @PathVariable int reviewSeq) {

        try {
            HashMap<String, Integer> map = new HashMap<>();

            map.put("userSeq", userSeq);
            map.put("reviewSeq", reviewSeq);

            int result = lService.deleteLike(map);

            if(result != 0)
                return new ResponseEntity<>(result, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "특정 리뷰 좋아요 여부")
    @GetMapping("/reviewlike/{userSeq}/{reviewSeq}")
    public ResponseEntity<?> getUserLikeList(@PathVariable int userSeq, @PathVariable int reviewSeq) {

        try {
            HashMap<String, Integer> map = new HashMap<>();

            map.put("userSeq", userSeq);
            map.put("reviewSeq", reviewSeq);

            VideoReviewLikeInfo reviewLike = lService.readReviewLike(map);

            if(reviewLike != null)
                return new ResponseEntity<VideoReviewLikeInfo>(reviewLike, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "특정 리뷰를 좋아요 누른 사람 리스트")
    @GetMapping("/userlist/{reviewSeq}")
    public ResponseEntity<?> getUserLikeListByReviewSeq(@PathVariable int reviewSeq) {

        try {
            List<VideoReviewLikeInfo> list = lService.readLikeByReviewSeq(reviewSeq);

            if(list != null)
                return new ResponseEntity<List<VideoReviewLikeInfo>>(list, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "특정 유저가 좋아요 한 리뷰 리스트")
    @GetMapping("/reviewlist/{userSeq}")
    public ResponseEntity<?> getReviewLikeListByUserSeq(@PathVariable int userSeq) {

        try {
            List<VideoReviewLikeInfo> list = lService.readLikeByUserSeq(userSeq);

            if(list != null)
                return new ResponseEntity<List<VideoReviewLikeInfo>>(list, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }


    private ResponseEntity<String> exceptionHandling(Exception e) {

        e.printStackTrace();

        return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
