package com.ssafy.ssaccer.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

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

    private Position position;

    private String phoneNumber;

    private String img;

    private String orgimg;

    private MultipartFile file;
}
