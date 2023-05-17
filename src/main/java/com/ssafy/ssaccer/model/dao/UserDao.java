package com.ssafy.ssaccer.model.dao;

import com.ssafy.ssaccer.model.dto.User;
import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@ApiModel(value = "USER DAO")
@Repository
public interface UserDao {

    int insertUser(User user);

    User selectUserByUserId(String userId);

    User selectUserByUserSeq(int userSeq);

    List<User> selectUserList();

    int modifyUser(User user);

    int removeUserByUserId(String userId);

    int removeUserByUserSeq(int userSeq);
}
