package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dto.Ability;
import com.ssafy.ssaccer.model.dto.Article;
import com.ssafy.ssaccer.model.dto.Gender;
import com.ssafy.ssaccer.model.dto.Status;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(value = "Article Service")
public interface ArticleService {

    int createArticle(Article article);

    Article readArticleByArticleSeq(int articleSeq);

    List<Article> readAllArticleList();

    List<Article> readArticleListByUserSeq(int userSeq);

    List<Article> readArticleListByStatus(Status status);

    List<Article> readArticleListByGender(Gender gender);

    List<Article> readArticleListByAbility(Ability ability);

    int updateArticle(Article article);

    int deleteArticle(int articleSeq);

    int addViewCnt(int articleSeq);

    int addRecruiteCnt(int articleSeq);

    int minusRecruiteCnt(int articleSeq);
}
