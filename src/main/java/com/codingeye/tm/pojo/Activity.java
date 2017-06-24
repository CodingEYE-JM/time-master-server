package com.codingeye.tm.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Camon on 2017/6/10.
 */
public class Activity {

    private int id;
    private String username;
    private Date active_date;
    private boolean eating;
    private boolean learning;
    private boolean sports;
    private boolean working;
    private boolean sleeping;
    private boolean reading;
    private boolean playing;
    private boolean shopping;
    private Date create_time;
    private Date update_time;

    public Activity(){}

    public Activity(int id, String username, Date active_date, boolean eating, boolean learning, boolean sports, boolean working, boolean sleeping, boolean reading, boolean playing, boolean shopping, Date create_time, Date update_time) {
        this.id = id;
        this.username = username;
        this.active_date = active_date;
        this.eating = eating;
        this.learning = learning;
        this.sports = sports;
        this.working = working;
        this.sleeping = sleeping;
        this.reading = reading;
        this.playing = playing;
        this.shopping = shopping;
        this.create_time = create_time;
        this.update_time = update_time;
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

    public Date getActive_date() {
        return active_date;
    }

    public void setActive_date(Date active_date) {
        this.active_date = active_date;
    }

    public boolean isEating() {
        return eating;
    }

    public void setEating(boolean eating) {
        this.eating = eating;
    }

    public boolean isLearning() {
        return learning;
    }

    public void setLearning(boolean learning) {
        this.learning = learning;
    }

    public boolean isSports() {
        return sports;
    }

    public void setSports(boolean sports) {
        this.sports = sports;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public boolean isSleeping() {
        return sleeping;
    }

    public void setSleeping(boolean sleeping) {
        this.sleeping = sleeping;
    }

    public boolean isReading() {
        return reading;
    }

    public void setReading(boolean reading) {
        this.reading = reading;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public boolean isShopping() {
        return shopping;
    }

    public void setShopping(boolean shopping) {
        this.shopping = shopping;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", active_date=" + active_date +
                ", eating=" + eating +
                ", learning=" + learning +
                ", sports=" + sports +
                ", working=" + working +
                ", sleeping=" + sleeping +
                ", reading=" + reading +
                ", playing=" + playing +
                ", shopping=" + shopping +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
