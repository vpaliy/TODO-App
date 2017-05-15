package com.popularmovies.vpaliy.todo.domain.model;



public class Goal extends Task {

    private Plan goalPlan;

    public void setGoalPlan(Plan goalPlan) {
        this.goalPlan = goalPlan;
    }

    public Plan getGoalPlan() {
        return goalPlan;
    }
}
