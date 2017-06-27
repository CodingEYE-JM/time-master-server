package com.codingeye.tm.controller;

import com.codingeye.tm.dao.RecommendMapper;
import com.codingeye.tm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by Camon on 2017/6/25.
 */
@RestController
@RequestMapping("/api/recommend/")
public class RecommendController {
    @Autowired
    private RecommendMapper recommendMapper;

    @CrossOrigin(origins = "*")
    @GetMapping("/{type}")
    public List<User> getSameTypeUsers(@PathVariable("type") String type,
                                       @Param("username") String username) {
        List<User> sameTypeUsers = recommendMapper.getSameTypeUsers(username, type);
        return sameTypeUsers;
    }
}
