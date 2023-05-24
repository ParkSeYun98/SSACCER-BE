package com.ssafy.ssaccer.model.dao;

import com.ssafy.ssaccer.model.dto.Ability;
import com.ssafy.ssaccer.model.dto.Article;
import com.ssafy.ssaccer.model.dto.Gender;
import com.ssafy.ssaccer.model.dto.Status;
import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@ApiModel(value = "Article DAO")
@Repository
public interface ArticleDao {

    int insertArticle(Article article);

    Article selectArticleByArticleSeq(int articleSeq);

    List<Article> selectAllArticleList();

    List<Article> selectArticleListByUserSeq(int userSeq);

    List<Article> selectArticleListByStatus(Status status);

    List<Article> selectArticleListByGender(Gender gender);

    List<Article> selectArticleListByAbility(Ability ability);

    int modifyArticle(Article article);

    int removeArticle(int articleSeq);

    int addViewCnt(int articleSeq);

    int addRecruiteCnt(int articleSeq);

    int minusRecruiteCnt(int articleSeq);
}
