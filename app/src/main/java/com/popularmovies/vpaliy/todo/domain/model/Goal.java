package com.popularmovies.vpaliy.todo.domain.model;



public class Goal {

    private int taskId;
    private Plan goalPlan;
    private Category category;
    private Priority priority;
    private TaskCycle taskCycle;
    private TaskNote taskNote;

    public void setTaskNote(TaskNote taskNote) {
        this.taskNote = taskNote;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setTaskCycle(TaskCycle taskCycle) {
        this.taskCycle = taskCycle;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setGoalPlan(Plan goalPlan) {
        this.goalPlan = goalPlan;
    }

    public TaskNote getTaskNote() {
        return taskNote;
    }

    public TaskCycle getTaskCycle() {
        return taskCycle;
    }

    public Priority getPriority() {
        return priority;
    }

    public int getTaskId() {
        return taskId;
    }

    public Category getCategory() {
        return category;
    }

    public Plan getGoalPlan() {
        return goalPlan;
    }
}
