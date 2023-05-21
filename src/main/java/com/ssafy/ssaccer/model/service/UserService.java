package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dto.User;
import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(value = "User Service")
public interface UserService {

    int createUser(User user);

    User readUserByUserId(String userId);

    User readUserByUserSeq(int userSeq);

    List<User> readUserList();

    int updateUser(User user);

    int deleteUserByUserId(String userId);

    int deleteUserByUserSeq(int userSeq);

    User login(User user);

    int uploadImage(int userSeq);
}
