package com.codingeye.tm.vo;

import com.codingeye.tm.pojo.Activity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Camon on 2017/6/10.
 */
public class ActivityWrapper {
    private int id;
    private String username;
    private LocalDate active_date;
    private LocalDateTime create_time;
    private LocalDateTime update_time;
    private List<ActivityUnit> activities = new ArrayList<>();

    public ActivityWrapper(){
        this.id = Integer.MAX_VALUE;
        this.username = "nobody";

        this.activities.add(new ActivityUnit("吃饭", false));
        this.activities.add(new ActivityUnit("学习", false));
        this.activities.add(new ActivityUnit("运动", false));
        this.activities.add(new ActivityUnit("工作", false));
        this.activities.add(new ActivityUnit("睡觉", false));
        this.activities.add(new ActivityUnit("阅读", false));
        this.activities.add(new ActivityUnit("游戏", false));
        this.activities.add(new ActivityUnit("购物", false));
    }

    public ActivityWrapper(Activity activity) {
        this.id = activity.getId();
        this.username = activity.getUsername();
        this.active_date = activity.getActive_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.create_time = activity.getCreate_time().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        this.update_time = activity.getUpdate_time().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        this.activities.add(new ActivityUnit("吃饭", activity.isEating()));
        this.activities.add(new ActivityUnit("学习", activity.isLearning()));
        this.activities.add(new ActivityUnit("运动", activity.isSports()));
        this.activities.add(new ActivityUnit("工作", activity.isWorking()));
        this.activities.add(new ActivityUnit("睡觉", activity.isSleeping()));
        this.activities.add(new ActivityUnit("阅读", activity.isReading()));
        this.activities.add(new ActivityUnit("游戏", activity.isPlaying()));
        this.activities.add(new ActivityUnit("购物", activity.isShopping()));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getActive_date() {
        return active_date;
    }

    public void setActive_date(LocalDate active_date) {
        this.active_date = active_date;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
    }

    public List<ActivityUnit> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityUnit> activities) {
        this.activities = activities;
    }
}
