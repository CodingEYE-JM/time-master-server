package com.codingeye.tm.controller;

import com.codingeye.tm.vo.ActivityWrapper;
import com.codingeye.tm.dao.ActivityMapper;
import com.codingeye.tm.pojo.Activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

/**
 * Created by Camon on 2017/6/10.
 */
@RestController
@RequestMapping("/api/activity/")
public class ActivityController {
    @Autowired
    private ActivityMapper activityMapper;

    @GetMapping("/{year}/{month}/{day}")
    public ActivityWrapper getActivitiesOfDay(@PathVariable("year") int year,
                                              @PathVariable("month") int month,
                                              @PathVariable("day") int day,
                                              HttpServletResponse response) {
        LocalDate activeDate = LocalDate.of(year, month, day);
        Activity activity = activityMapper.selectByUserAndDate("eater", activeDate.toString());
        response.setHeader("Access-Control-Allow-Origin", "*");
        return activity != null ? new ActivityWrapper(activity) : new ActivityWrapper();
    }
}
