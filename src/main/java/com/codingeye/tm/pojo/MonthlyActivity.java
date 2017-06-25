package com.codingeye.tm.pojo;

/**
 * Created by Camon on 2017/6/24.
 */
public class MonthlyActivity {
    private int eatingCount;
    private int learningCount;
    private int sportsCount;
    private int workingCount;
    private int sleepingCount;
    private int readingCount;
    private int playingCount;
    private int shoppingCount;

    public MonthlyActivity(){}

    public MonthlyActivity(int eatingCount, int learningCount, int sportsCount, int workingCount, int sleepingCount, int readingCount, int playingCount, int shoppingCount) {
        this.eatingCount = eatingCount;
        this.learningCount = learningCount;
        this.sportsCount = sportsCount;
        this.workingCount = workingCount;
        this.sleepingCount = sleepingCount;
        this.readingCount = readingCount;
        this.playingCount = playingCount;
        this.shoppingCount = shoppingCount;
    }

    public int getEatingCount() {
        return eatingCount;
    }

    public void setEatingCount(int eatingCount) {
        this.eatingCount = eatingCount;
    }

    public int getLearningCount() {
        return learningCount;
    }

    public void setLearningCount(int learningCount) {
        this.learningCount = learningCount;
    }

    public int getSportsCount() {
        return sportsCount;
    }

    public void setSportsCount(int sportsCount) {
        this.sportsCount = sportsCount;
    }

    public int getWorkingCount() {
        return workingCount;
    }

    public void setWorkingCount(int workingCount) {
        this.workingCount = workingCount;
    }

    public int getSleepingCount() {
        return sleepingCount;
    }

    public void setSleepingCount(int sleepingCount) {
        this.sleepingCount = sleepingCount;
    }

    public int getReadingCount() {
        return readingCount;
    }

    public void setReadingCount(int readingCount) {
        this.readingCount = readingCount;
    }

    public int getPlayingCount() {
        return playingCount;
    }

    public void setPlayingCount(int playingCount) {
        this.playingCount = playingCount;
    }

    public int getShoppingCount() {
        return shoppingCount;
    }

    public void setShoppingCount(int shoppingCount) {
        this.shoppingCount = shoppingCount;
    }

    @Override
    public String toString() {
        return "MonthlyActivity{" +
                "eatingCount=" + eatingCount +
                ", learningCount=" + learningCount +
                ", sportsCount=" + sportsCount +
                ", workingCount=" + workingCount +
                ", sleepingCount=" + sleepingCount +
                ", readingCount=" + readingCount +
                ", playingCount=" + playingCount +
                ", shoppingCount=" + shoppingCount +
                '}';
    }
}
