package com.codingeye.tm.controller;

import com.codingeye.tm.dao.ActivityMapper;
import com.codingeye.tm.dao.RecommendMapper;
import com.codingeye.tm.pojo.MonthlyActivity;
import com.codingeye.tm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Camon on 2017/6/25.
 */
@RestController
@RequestMapping("/api/recommend/")
public class RecommendController {
    @Autowired
    private RecommendMapper recommendMapper;

    @GetMapping("/{type}")
    public List<User> getSameTypeUsers(@PathVariable("type") String type,
                                       HttpServletResponse response) {
        List<User> sameTypeUsers = recommendMapper.getSameTypeUsers(type);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return sameTypeUsers;
    }
}
