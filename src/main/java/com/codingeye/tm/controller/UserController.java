package com.codingeye.tm.controller;

import com.codingeye.tm.dao.UserMapper;
import com.codingeye.tm.pojo.User;
import com.codingeye.tm.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Camon on 2017/6/26.
 */

@RestController
@RequestMapping("/api/user/")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @CrossOrigin(origins = "*")
    @PostMapping("/signin")
    public User getUserInfo(@Param("username") String username,
                            @Param("password") String password) {

        password = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.selectUserBySignIn(username, password);
        return user;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/signup")
    public User registerUserInfo(@Param("username") String username,
                                 @Param("password") String password) {

        password = MD5Util.MD5EncodeUtf8(password);
        userMapper.insertUserBySignUp(username, password);
        User user = new User();
        user.setUsername(username);
        return user;
    }
}
