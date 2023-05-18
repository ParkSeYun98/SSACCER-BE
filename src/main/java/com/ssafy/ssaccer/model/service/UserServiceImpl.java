package com.ssafy.ssaccer.model.service;

import com.ssafy.ssaccer.model.dao.UserDao;
import com.ssafy.ssaccer.model.dto.User;
import io.swagger.annotations.ApiModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@ApiModel(value="User Service Implementation")
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserDao dao;

    @Override
    public int createUser(User user) {
        return dao.insertUser(user);
    }

    @Override
    public User readUserByUserId(String userId) {
        return dao.selectUserByUserId(userId);
    }

    @Override
    public User readUserByUserSeq(int userSeq) {
        return dao.selectUserByUserSeq(userSeq);
    }

    @Override
    public List<User> readUserList() {
        return dao.selectUserList();
    }

    @Override
    public int updateUser(User user) {
        return dao.modifyUser(user);
    }

    @Override
    public int deleteUserByUserId(String userId) {
        return dao.removeUserByUserId(userId);
    }

    @Override
    public int deleteUserByUserSeq(int userSeq) {
        return dao.removeUserByUserSeq(userSeq);
    }

    @Override
    public User login(User user) {
        User loginUser = dao.selectUserByUserSeq(user.getUserSeq());

        if(loginUser != null && loginUser.getPassword().equals(user.getPassword()))
            return loginUser;

        return null;
    }
}
