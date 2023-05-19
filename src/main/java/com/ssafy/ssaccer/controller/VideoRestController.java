package com.ssafy.ssaccer.controller;

import com.ssafy.ssaccer.model.dto.Video;
import com.ssafy.ssaccer.model.service.VideoService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiModel(value="Video RestController")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET , RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor
@RestController
@RequestMapping("/video")
public class VideoRestController {

    private final VideoService vService;
    
    @ApiOperation(value = "영상 등록", notes = "영상을 클릭하여 상세 페이지로 넘어 갈 때 DB에 저장 - 중복 체크 필요")
    @PostMapping("/regist")
    public ResponseEntity<?> registVideo(@RequestBody Video video) {
        System.out.println(video);
        System.out.println(video.getChannelName());
        System.out.println(video.getYoutubeId());

        try {
            int result = vService.createVideo(video);

            if(result != 0)
                return new ResponseEntity<Integer>(result, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "특정 영상 조회")
    @GetMapping("/read/{videoSeq}")
    public ResponseEntity<?> getVideoById(@PathVariable int videoSeq) {

        try {
            Video video = vService.readVideoByVideoSeq(videoSeq);

            if(video != null)
                return new ResponseEntity<Video>(video, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "영상 리스트 조회")
    @GetMapping("/read/list")
    public ResponseEntity<?> getVideoList() {

        try {
            List<Video> list = vService.readVideoList();

            if(list != null)
                return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    private ResponseEntity<String> exceptionHandling(Exception e) {

        e.printStackTrace();

        return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
