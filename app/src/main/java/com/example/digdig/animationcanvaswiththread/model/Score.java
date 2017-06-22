package com.example.digdig.animationcanvaswiththread.model;

/**
 * Created by digdig on 17-06-14.
 */

public class Score {
    private int touch;
    private int lose;
    private int score;
    private int live;

    public int getLive() {
        return live;
    }

    public void setLive(int live) {
        this.live = live;
    }

    public int getTouch() {
        return touch;
    }

    public void setTouch(int touch) {
        this.touch = touch;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Score(int touch, int lose, int score,int live) {
        this.touch = touch;
        this.lose = lose;
        this.score = score;
        this.live = live;
    }

    public Score() {
        this.touch = 0;
        this.lose = 0;
        this.score = 0;
        this.live = 4;
    }
    public void incrementCaught() {
        this.touch++;
    }

    public void incrementMissed() {
        this.lose++;
    }

    public void incrementScore(int coconuts) {
        this.score += (coconuts*2);
    }


}
