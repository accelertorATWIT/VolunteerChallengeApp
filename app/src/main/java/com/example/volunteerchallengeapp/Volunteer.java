package com.example.volunteerchallengeapp;

public class Volunteer {
    private String name;
    private int completedChallenges;

    public Volunteer(String name, int completedChallenges) {
        this.name = name;
        this.completedChallenges = completedChallenges;
    }

    public String getName() {
        return name;
    }

    public int getCompletedChallenges() {
        return completedChallenges;
    }

    public void setCompletedChallenges(int completedChallenges) {
        this.completedChallenges = completedChallenges;
    }
}
