package com.codingeye.tm.controller;

import com.codingeye.tm.dao.ActivityMapper;

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

    @CrossOrigin(origins = "*")
    @GetMapping("/{year}/{month}")
    public MonthlyActivity getReportsOfMonth(@PathVariable("year") String year,
                                             @PathVariable("month") String month,
                                             HttpServletResponse response) {
        MonthlyActivity monthlyActivity = activityMapper.selectByUserAndMonth("admin", year + month);
        return monthlyActivity;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{year}/{month}/{day}")
    public ActivityWrapper getActivitiesOfDay(@PathVariable("year") int year,
                                              @PathVariable("month") int month,
                                              @PathVariable("day") int day,
                                              HttpServletResponse response) {
        LocalDate activeDate = LocalDate.of(year, month , day);
        DailyActivity dailyActivity = activityMapper.selectByUserAndDate("admin", activeDate.toString());
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
                                   HttpServletResponse response) {
        Date activeDate = new GregorianCalendar(year, month - 1, day).getTime();
        DailyActivity activity = new DailyActivity(
                id, "admin", activeDate, eating, learning, sports, working, sleeping, reading, playing, shopping, new Date(), new Date()
        );
        if (id == Integer.MAX_VALUE) {
            activityMapper.insertByUserAndDate(activity);
        } else {
            activityMapper.updateByUserAndDate(activity);
        }
    }
}
