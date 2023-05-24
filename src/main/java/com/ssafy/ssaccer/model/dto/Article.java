package com.ssafy.ssaccer.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "Article DTO")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Article {

    private int articleSeq;

    private int userSeq;

    private String title;

    private String content;

    private int viewCnt;

    private int recruiteCnt;

    private int recruiteMax;

    private String place;

    private int cost;

    private Ability ability;

    private Status status;

    private Gender gender;

    private boolean shower;

    private boolean parking;

    private boolean beverage;

    private boolean rental;

    private String createdDate;

    private String matchstartDate;

    private String matchendDate;
}
