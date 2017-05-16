package com.popularmovies.vpaliy.todo.domain.model;

import java.util.Calendar;
import java.util.Date;

public class TaskCycle {

    private int cycleId;
    private TaskFrequency taskFrequency;
    private Date startDate;
    private Date endDate;
    private int cycleCount;

    public void setCycleCount(int cycleCount) {
        this.cycleCount = cycleCount;
    }

    public void setCycleId(int cycleId) {
        this.cycleId = cycleId;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
        computeEndDate();
    }

    private void computeEndDate(){
        if(taskFrequency!=null && startDate!=null){
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(startDate);
            switch (taskFrequency){
                case DAILY:
                    calendar.add(Calendar.DAY_OF_MONTH,1);
                case WEEKLY:
                    calendar.add(Calendar.WEEK_OF_MONTH,1);
                case MONTHLY:
                    calendar.add(Calendar.MONTH,1);
                    break;
            }
            endDate=calendar.getTime();
        }
    }

    public void setTaskFrequency(TaskFrequency taskFrequency) {
        this.taskFrequency = taskFrequency;
        computeEndDate();
    }

    public Date getEndDate() {
        if(endDate==null) computeEndDate();
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public int getCycleCount() {
        return cycleCount;
    }

    public int getCycleId() {
        return cycleId;
    }
}
