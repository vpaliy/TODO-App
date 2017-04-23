package com.popularmovies.vpaliy.todo.domain.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Date;

public class TODOTask {

    private final static Date UNLIMITED=null;

    private int taskId;
    private boolean isFinished;
    private Priority priority;
    private String title;
    private String description;
    private Date dueDate;

    public TODOTask(){}

    public TODOTask(int taskId,
                    @NonNull Priority priority,
                    @NonNull String description,
                    @NonNull String title){
        this(taskId,priority,description,title,UNLIMITED);
    }

    public TODOTask(int taskId,
                    @NonNull Priority priority,
                    @NonNull String description,
                    @NonNull String title,
                    @Nullable Date dueDate){
        this.taskId=taskId;
        this.priority=priority;
        this.description=description;
        this.title=title;
        this.dueDate = dueDate;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public boolean isFinished() {
        return isFinished;
    }

    @Nullable
    public Date getDueDate() {
        return dueDate;
    }

    public int getTaskId() {
        return taskId;
    }

    @NonNull
    public Priority getPriority() {
        return priority;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(@NonNull Priority priority) {
        this.priority = priority;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
