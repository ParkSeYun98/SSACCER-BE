package com.ssafy.ssaccer.controller;

import com.ssafy.ssaccer.model.dto.*;
import com.ssafy.ssaccer.model.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@ApiModel(value="Article RestController")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET , RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor
@RestController
@RequestMapping("/article")
public class ArticleRestController {

    private final ArticleService aService;

    @ApiOperation(value = "게시글 등록")
    @PostMapping("/regist")
    public ResponseEntity<?> registArticle(@RequestBody Article article) {

        try {
            int result = aService.createArticle(article);

            if(result != 0)
                return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
            else
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "게시글 번호로 게시글 읽기")
    @GetMapping("/readbyarticleseq/{articleSeq}")
    public ResponseEntity<?> readArticleByArticleSeq(@PathVariable int articleSeq) {

        try {
            Article article = aService.readArticleByArticleSeq(articleSeq);

            if(article != null)
                return new ResponseEntity<Article>(article, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "전체 게시글 리스트 읽기")
    @GetMapping("/read/list")
    public ResponseEntity<?> readAllArticleList() {

        try {
            List<Article> articleList = aService.readAllArticleList();

            if(articleList != null)
                return new ResponseEntity<List<Article>>(articleList, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "유저가 작성한 게시글 리스트 읽기")
    @GetMapping("/readbyuserseq/list/{userSeq}")
    public ResponseEntity<?> readArticleListByUserSeq(@PathVariable int userSeq) {

        try {
            List<Article> articleList = aService.readArticleListByUserSeq(userSeq);

            if(articleList != null)
                return new ResponseEntity<List<Article>>(articleList, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "특정 상태인 게시글 리스트 읽기")
    @GetMapping("/readbystatus/list/{status}")
    public ResponseEntity<?> readArticleListByStatus(@PathVariable Status status) {

        try {
            List<Article> articleList = aService.readArticleListByStatus(status);

            if(articleList != null)
                return new ResponseEntity<List<Article>>(articleList, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "특정 성별을 모집하는 게시글 리스트 읽기")
    @GetMapping("/readbygender/list/{gender}")
    public ResponseEntity<?> readArticleListByGender(@PathVariable Gender gender) {

        try {
            List<Article> articleList = aService.readArticleListByGender(gender);

            if(articleList != null)
                return new ResponseEntity<List<Article>>(articleList, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "특정 풋살 실력의 사용자를 모집하는 게시글 리스트 읽기")
    @GetMapping("/readbyability/list/{ability}")
    public ResponseEntity<?> readArticleListByAbility(@PathVariable Ability ability) {

        try {
            List<Article> articleList = aService.readArticleListByAbility(ability);

            if(articleList != null)
                return new ResponseEntity<List<Article>>(articleList, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "게시글 수정")
    @PutMapping("/update")
    public ResponseEntity<?> updateArticle(@RequestBody Article article) {

        try {
            int result = aService.updateArticle(article);

            if(result != 0)
                return new ResponseEntity<Integer>(result, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "게시글 삭제")
    @DeleteMapping("/delete/{articleSeq}")
    public ResponseEntity<?> deleteArticle(@PathVariable int articleSeq) {

        try {
            int result = aService.deleteArticle(articleSeq);

            if(result != 0)
                return new ResponseEntity<Integer>(result, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "게시글 조회수 증가")
    @PutMapping("/updateviewcnt/{articleSeq}")
    public ResponseEntity<?> updateViewCnt(@PathVariable int articleSeq) {

        try {
            int result = aService.addViewCnt(articleSeq);

            if(result != 0)
                return new ResponseEntity<Integer>(result, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    private ResponseEntity<String> exceptionHandling(Exception e) {

        e.printStackTrace();

        return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}























