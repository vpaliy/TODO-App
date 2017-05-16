package com.popularmovies.vpaliy.todo.domain.model;


import android.support.annotation.NonNull;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Plan {

    private int planId;
    private float completed;
    private List<TODOItem> todoItemList;

    private void computeCompleted(){
        if(todoItemList==null||todoItemList.isEmpty()){
            completed=100f;
            return;
        }
        int completedItemCount=0;
        for(TODOItem item:todoItemList){
            completedItemCount+=item.isDone?1:0;
        }

        completed=(completedItemCount * 100f)/todoItemList.size();
    }


    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public Plan addTODOItem(@NonNull TODOItem item){
        if(todoItemList==null) todoItemList=new LinkedList<>();
        todoItemList.add(item);
        return this;
    }

    public void setTodoItemList(List<TODOItem> todoItemList) {
        this.todoItemList = todoItemList;
        computeCompleted();
    }

    public float getCompleted() {
        return completed;
    }

    public int getPlanId() {
        return planId;
    }

    public List<TODOItem> getTodoItemList() {
        return todoItemList;
    }
}
