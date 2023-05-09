package com.example.javafxuserinformation;

public class User {
    private int id;
    private String name;
    private String job;
    private int score;

    public User(String job, String name, int score) {
        this.job = job;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }
    public void setJob() {
        this.job = job;
    }
    public String getName() {
        return name;
    }
    public void serName() {
        this.name = name;
    }
    public int getScore() {
        return score;
    }
    public void setScore() {
        this.score = score;
    }
}
