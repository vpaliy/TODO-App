package com.popularmovies.vpaliy.todo.domain.model;


import java.util.Date;

public class TODOItem {

    private int taskId;
    private String headline;
    private TaskCycle taskCycle;
    private TaskNote taskNote;
    private Category category;
    private Date dueDate;
    private Priority priority;

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setTaskCycle(TaskCycle taskCycle) {
        this.taskCycle = taskCycle;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setTaskNote(TaskNote taskNote) {
        this.taskNote = taskNote;
    }

    public Category getCategory() {
        return category;
    }

    public Date getDueDate() {
        return dueDate;
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

    public String getHeadline() {
        return headline;
    }
}
