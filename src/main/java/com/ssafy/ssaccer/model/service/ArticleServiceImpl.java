package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dao.ArticleDao;
import com.ssafy.ssaccer.model.dto.Ability;
import com.ssafy.ssaccer.model.dto.Article;
import com.ssafy.ssaccer.model.dto.Gender;
import com.ssafy.ssaccer.model.dto.Status;
import io.swagger.annotations.ApiModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@ApiModel(value="Article Service Implementation")
@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService{

    private final ArticleDao dao;

    @Override
    public int createArticle(Article article) {
        return dao.insertArticle(article);
    }

    @Override
    public Article readArticleByArticleSeq(int articleSeq) {
        return dao.selectArticleByArticleSeq(articleSeq);
    }

    @Override
    public List<Article> readAllArticleList() {
        return dao.selectAllArticleList();
    }

    @Override
    public List<Article> readArticleListByUserSeq(int userSeq) {
        return dao.selectArticleListByUserSeq(userSeq);
    }

    @Override
    public List<Article> readArticleListByStatus(Status status) {
        return dao.selectArticleListByStatus(status);
    }

    @Override
    public List<Article> readArticleListByGender(Gender gender) {
        return dao.selectArticleListByGender(gender);
    }

    @Override
    public List<Article> readArticleListByAbility(Ability ability) {
        return dao.selectArticleListByAbility(ability);
    }

    @Override
    public int updateArticle(Article article) {
        return dao.modifyArticle(article);
    }

    @Override
    public int deleteArticle(int articleSeq) {
        return dao.removeArticle(articleSeq);
    }

    @Override
    public int addViewCnt(int articleSeq) {
        return dao.addViewCnt(articleSeq);
    }

    @Override
    public int addRecruiteCnt(int articleSeq) {
        return dao.addRecruiteCnt(articleSeq);
    }

    @Override
    public int minusRecruiteCnt(int articleSeq) {
        return dao.minusRecruiteCnt(articleSeq);
    }
}
