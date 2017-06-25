package com.codingeye.tm.controller;

import com.codingeye.tm.dao.ActivityMapper;

import com.codingeye.tm.pojo.DailyActivity;
import com.codingeye.tm.pojo.MonthlyActivity;
import com.codingeye.tm.vo.ActivityWrapper;
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

    @GetMapping("/{year}/{month}")
    public MonthlyActivity getReportsOfMonth(@PathVariable("year") String year,
                                             @PathVariable("month") String month,
                                             HttpServletResponse response) {
        MonthlyActivity monthlyActivity = activityMapper.selectByUserAndMonth("eater", year + month);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return monthlyActivity;
    }

    @GetMapping("/{year}/{month}/{day}")
    public ActivityWrapper getActivitiesOfDay(@PathVariable("year") int year,
                                              @PathVariable("month") int month,
                                              @PathVariable("day") int day,
                                              HttpServletResponse response) {
        LocalDate activeDate = LocalDate.of(year, month, day);
        DailyActivity dailyActivity = activityMapper.selectByUserAndDate("eater", activeDate.toString());
        response.setHeader("Access-Control-Allow-Origin", "*");
        return dailyActivity != null ? new ActivityWrapper(dailyActivity) : new ActivityWrapper();
    }
}
