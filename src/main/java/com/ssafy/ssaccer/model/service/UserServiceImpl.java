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

    private final UserDao userDao;

    @Override
    public int createUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User readUserByUserId(String userId) {
        return userDao.selectUserByUserId(userId);
    }

    @Override
    public User readUserByUserSeq(int userSeq) {
        return userDao.selectUserByUserSeq(userSeq);
    }

    @Override
    public List<User> readUserList() {
        return userDao.selectUserList();
    }

    @Override
    public int updateUser(User user) {
        return userDao.modifyUser(user);
    }

    @Override
    public int deleteUserByUserId(String userId) {
        return userDao.removeUserByUserId(userId);
    }

    @Override
    public int deleteUserByUserSeq(int userSeq) {
        return userDao.removeUserByUserSeq(userSeq);
    }

    @Override
    public User login(User user) {
        User loginUser = userDao.selectUserByUserSeq(user.getUserSeq());

        if(loginUser != null && loginUser.getPassword().equals(user.getPassword()))
            return loginUser;

        return null;
    }
}
