package com.example.servletexample.model;


import com.example.servletexample.runTimeRepository.Users;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private String token;
    private Boolean employed;
    private int level;
    private int points;
    private List<String> presents;
    public User() {
    }

    public User(String email, boolean employed) {
        this.email = email;
        this.employed=employed;
        this.level = 0;
        this.points = 0;
        this.presents=new ArrayList<>();
        this.token = Users.INSTANCE.getNextId();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Boolean getEmployed() {
        return employed;
    }

    public void setEpmloyed(Boolean employed) {
        this.employed = employed;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public void addPoints() {
        this.points += 10;
    }
    public void setPoints(int points){
        this.points=points;
    }
    public void setPresents(List<String> presents)
    {
        this.presents=presents;
    }
    public int getPoints() {
        return points;
    }
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", token='" + token + '\'' +
                ", employed='" +employed+ '\'' +
                '}';
    }
    public void addPresent(String present)
    {
        presents.add(present);
    }
    public List<String> getPresents()
    {
        return presents;
    }
}