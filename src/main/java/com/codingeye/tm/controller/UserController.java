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
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/signin")
    public User getUserInfo(@Param("username") String username,
                            @Param("password") String password) {

        password = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.selectUserBySignIn(username, password);
        return user;
    }

    @PostMapping("/signup")
    public User registerUserInfo(@Param("username") String username,
                                 @Param("password") String password) {
        User user = userMapper.getUserType(username);
        if(user != null){
            user.setUsername(null);
            return user;
        }else {
            user = new User();
            password = MD5Util.MD5EncodeUtf8(password);
            userMapper.insertUserBySignUp(username, password);
            user.setUsername(username);
            return user;
        }
    }

    @GetMapping("/type")
    public User getUserType(@Param("username") String username){
        return userMapper.getUserType(username);
    }
}
