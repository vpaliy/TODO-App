package com.popularmovies.vpaliy.todo.domain.model;


import java.util.Date;
import java.util.List;
import java.util.Map;

public class Review {

    private int reviewId;
    private String reviewDescription;
    private Date reviewDate;
    private List<Task> tasks;

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public int getReviewId() {
        return reviewId;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }
}
