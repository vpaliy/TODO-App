package com.popularmovies.vpaliy.todo.ui.eventBus.event;


public class ExposeDetailsEvent {

    private int taskId;

    public ExposeDetailsEvent(int taskId){
        this.taskId=taskId;
    }

    public int getTaskId() {
        return taskId;
    }
}
