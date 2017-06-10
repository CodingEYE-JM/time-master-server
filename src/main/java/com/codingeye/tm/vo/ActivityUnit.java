package com.codingeye.tm.vo;

/**
 * Created by Camon on 2017/6/10.
 */
class ActivityUnit {
    private String name;
    private boolean active;

    public ActivityUnit(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
