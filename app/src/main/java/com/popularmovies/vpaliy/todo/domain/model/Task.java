package com.popularmovies.vpaliy.todo.domain.model;


import java.util.Date;

public abstract class Task {

    protected int taskId;
    protected String headline;
    protected Category category;
    protected Date dueDate;
    protected TaskCycle taskCycle;
    protected Priority priority;
    protected TaskNote taskNote;
    protected boolean isDone;

    public String getHeadline() {
        return headline;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Category getCategory() {
        return category;
    }

    public int getTaskId() {
        return taskId;
    }

    public Priority getPriority() {
        return priority;
    }

    public TaskCycle getTaskCycle() {
        return taskCycle;
    }

    public TaskNote getTaskNote() {
        return taskNote;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void setTaskNote(TaskNote taskNote) {
        this.taskNote = taskNote;
    }

    public void setTaskCycle(TaskCycle taskCycle) {
        this.taskCycle = taskCycle;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
