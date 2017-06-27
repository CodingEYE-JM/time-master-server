package com.codingeye.tm.controller;

import com.codingeye.tm.dao.ActivityMapper;

import com.codingeye.tm.dao.UserMapper;
import com.codingeye.tm.pojo.DailyActivity;
import com.codingeye.tm.pojo.MonthlyActivity;
import com.codingeye.tm.vo.ActivityWrapper;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Camon on 2017/6/10.
 */
@RestController
@RequestMapping("/api/activity/")
public class ActivityController {
    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private UserMapper userMapper;

    @CrossOrigin(origins = "*")
    @GetMapping("/{year}/{month}")
    public MonthlyActivity getReportsOfMonth(@PathVariable("year") String year,
                                             @PathVariable("month") String month,
                                             @Param("username") String username) {
        MonthlyActivity monthlyActivity = activityMapper.selectByUserAndMonth(username, year + month);
        return monthlyActivity;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{year}/{month}/{day}")
    public ActivityWrapper getActivitiesOfDay(@PathVariable("year") int year,
                                              @PathVariable("month") int month,
                                              @PathVariable("day") int day,
                                              @Param("username") String username) {
        LocalDate activeDate = LocalDate.of(year, month, day);
        DailyActivity dailyActivity = activityMapper.selectByUserAndDate(username, activeDate.toString());
        return dailyActivity != null ? new ActivityWrapper(dailyActivity) : new ActivityWrapper();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/{year}/{month}/{day}")
    public void setActivitiesOfDay(@PathVariable("year") int year,
                                   @PathVariable("month") int month,
                                   @PathVariable("day") int day,
                                   @Param("id") int id,
                                   @Param("eating") boolean eating,
                                   @Param("learning") boolean learning,
                                   @Param("sports") boolean sports,
                                   @Param("working") boolean working,
                                   @Param("sleeping") boolean sleeping,
                                   @Param("reading") boolean reading,
                                   @Param("playing") boolean playing,
                                   @Param("shopping") boolean shopping,
                                   @Param("username") String username) {
        Date activeDate = new GregorianCalendar(year, month - 1, day).getTime();
        DailyActivity activity = new DailyActivity(
                id, username, activeDate, eating, learning, sports, working, sleeping, reading, playing, shopping, new Date(), new Date()
        );
        if (id == Integer.MAX_VALUE) {
            activityMapper.insertByUserAndDate(activity);
        } else {
            activityMapper.updateByUserAndDate(activity);
        }

        String yearMonth = month < 10? year + "0" + month : "" + year + month;
        MonthlyActivity monthlyActivity = activityMapper.selectByUserAndMonth(username, yearMonth);
        modifyUserType(monthlyActivity, username);
    }

    private void modifyUserType(MonthlyActivity monthlyActivity, String username){
        
        int maxCount = 0;
        String userType = "";
        
        if (monthlyActivity.getEatingCount() > maxCount) {
            maxCount = monthlyActivity.getEatingCount();
            userType = "EATER";
        }
        if (monthlyActivity.getLearningCount() > maxCount) {
            maxCount = monthlyActivity.getLearningCount();
            userType = "LEARNER";
        }
        if (monthlyActivity.getSportsCount() > maxCount) {
            maxCount = monthlyActivity.getSportsCount();
            userType = "SPORTSMAN";
        }
        if (monthlyActivity.getWorkingCount() > maxCount) {
            maxCount = monthlyActivity.getWorkingCount();
            userType = "WORKER";
        }
        if (monthlyActivity.getSleepingCount() > maxCount) {
            maxCount = monthlyActivity.getSleepingCount();
            userType = "SLEEPER";
        }
        if (monthlyActivity.getReadingCount() > maxCount) {
            maxCount = monthlyActivity.getReadingCount();
            userType = "READER";
        }
        if (monthlyActivity.getPlayingCount() > maxCount) {
            maxCount = monthlyActivity.getPlayingCount();
            userType = "PLAYER";
        }
        if (monthlyActivity.getShoppingCount() > maxCount) {
            maxCount = monthlyActivity.getShoppingCount();
            userType = "SHOPPER";
        }

        userMapper.updateUserType(username, userType);
    }
}
