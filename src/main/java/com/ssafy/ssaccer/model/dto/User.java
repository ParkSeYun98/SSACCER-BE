package com.ssafy.ssaccer.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "User DTO")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class User {

    private int userSeq;

    private String userId;

    private String password;

    private String name;

    private String nickname;

    private Role role;
}
