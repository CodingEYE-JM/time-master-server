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

        this.activities.add(new ActivityUnit("eating", false));
        this.activities.add(new ActivityUnit("learning", false));
        this.activities.add(new ActivityUnit("sports", false));
        this.activities.add(new ActivityUnit("working", false));
        this.activities.add(new ActivityUnit("sleeping", false));
        this.activities.add(new ActivityUnit("reading", false));
        this.activities.add(new ActivityUnit("playing", false));
        this.activities.add(new ActivityUnit("shopping", false));
    }

    public ActivityWrapper(Activity activity) {
        this.id = activity.getId();
        this.username = activity.getUsername();
        this.active_date = activity.getActive_date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.create_time = activity.getCreate_time().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        this.update_time = activity.getUpdate_time().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        this.activities.add(new ActivityUnit("eating", activity.isEating()));
        this.activities.add(new ActivityUnit("learning", activity.isLearning()));
        this.activities.add(new ActivityUnit("sports", activity.isSports()));
        this.activities.add(new ActivityUnit("working", activity.isWorking()));
        this.activities.add(new ActivityUnit("sleeping", activity.isSleeping()));
        this.activities.add(new ActivityUnit("reading", activity.isReading()));
        this.activities.add(new ActivityUnit("playing", activity.isPlaying()));
        this.activities.add(new ActivityUnit("shopping", activity.isShopping()));
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
