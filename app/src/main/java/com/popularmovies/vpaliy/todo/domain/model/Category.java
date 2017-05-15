package com.popularmovies.vpaliy.todo.domain.model;

import java.util.List;

public class Category {

    private String categoryId;
    private String category;

    private List<Task> tasks;

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getCategory() {
        return category;
    }

    public String getCategoryId() {
        return categoryId;
    }
}
