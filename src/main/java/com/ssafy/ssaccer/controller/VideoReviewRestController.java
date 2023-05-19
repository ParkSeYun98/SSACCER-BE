package com.ssafy.ssaccer.controller;

import com.ssafy.ssaccer.model.dto.VideoReview;
import com.ssafy.ssaccer.model.service.VideoReviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiModel(value="VideoReview RestController")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET , RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor
@RestController
@RequestMapping("/review")
public class VideoReviewRestController {

    private final VideoReviewService rService;

    @ApiOperation(value = "리뷰 등록")
    @PostMapping("/regist")
    public ResponseEntity<?> insertReview(@RequestBody VideoReview review) {

        try {
            int result = rService.createReview(review);

            if(result != 0)
                return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
            else
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "전체 리뷰 리스트 조회")
    @GetMapping("/read/list")
    public ResponseEntity<?> selectReviewList() {

        try {
            List<VideoReview> reviewList = rService.readReviewList();

            if(reviewList != null)
                return new ResponseEntity<List<VideoReview>>(reviewList, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "특정 리뷰 조회")
    @GetMapping("/read/{reviewSeq}")
    public ResponseEntity<?> searchReview(@PathVariable int reviewSeq) {

        try {
            VideoReview review = rService.readReview(reviewSeq);

            if(review != null)
                return new ResponseEntity<VideoReview>(review, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }
    
    @ApiOperation(value = "영상에 해당하는 리뷰 리스트 조회")
    @GetMapping("/readbyvideoseq/list/{videoSeq}")

    public ResponseEntity<?> selectReviewListByVideoSeq(@PathVariable int videoSeq) {

        try {
            List<VideoReview> reviewList = rService.readReviewListByVideoSeq(videoSeq);

            if(reviewList != null)
                return new ResponseEntity<List<VideoReview>>(reviewList, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "특정 유저가 작성한 리뷰 리스트 조회")
    @GetMapping("/readbyuserseq/list/{userSeq}")

    public ResponseEntity<?> selectReviewListByUserSeq(@PathVariable int userSeq) {

        try {
            List<VideoReview> reviewList = rService.readReviewListByVideoSeq(userSeq);

            if(reviewList != null)
                return new ResponseEntity<List<VideoReview>>(reviewList, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "리뷰 수정")
    @PutMapping("/update")
    public ResponseEntity<?> updateReview(@RequestBody VideoReview review) {

        try {
            int result = rService.updateReview(review);

            if(result != 0)
                return new ResponseEntity<Integer>(result, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "리뷰 삭제")
    @DeleteMapping("/delete/{reviewSeq}")
    public ResponseEntity<?> deleteReview(@PathVariable int reviewSeq) {

        try {
            int result = rService.deleteReview(reviewSeq);

            if(result != 0)
                return new ResponseEntity<Integer>(result, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    private ResponseEntity<String> exceptionHandling(Exception e) {

        e.printStackTrace();

        return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
