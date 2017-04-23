package com.popularmovies.vpaliy.todo.mvp.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.popularmovies.vpaliy.todo.di.scope.UserScope;
import com.popularmovies.vpaliy.todo.domain.model.Priority;
import com.popularmovies.vpaliy.todo.domain.model.TODOTask;
import com.popularmovies.vpaliy.todo.mvp.contract.RegisterTODOContract;
import com.popularmovies.vpaliy.todo.mvp.contract.RegisterTODOContract.View;

import java.util.Calendar;
import java.util.Date;

@UserScope
public class RegisterTODOPresenter
        implements RegisterTODOContract.Presenter {

    private View view;
    private TODOTask task;

    public RegisterTODOPresenter(){
        task=new TODOTask(0,null,null,null);
    }

    private boolean isDescriptionValid(String description){
        return !(description==null||description.isEmpty());
    }

    private boolean isPriorityValid(Priority priority){
        return priority!=null;
    }

    private boolean isDueDateValid(Date date){
        return date==null||date.after(Calendar.getInstance().getTime());
    }

    @Override
    public void submitDescription(@NonNull String description) {
        if(!isDescriptionValid(description)){
            view.showWrongDescriptionMessage();
        }else{
            task.setDescription(description);
        }
    }

    @Override
    public void submitDueDate(@Nullable Date date) {
        if(!isDueDateValid(date)){

        }else{
            task.setDueDate(date);
        }
    }

    @Override
    public void submitPriority(@NonNull Priority priority) {
        if(!isPriorityValid(priority)){
            view.showWrongPriorityMessage();
        }else{
            task.setPriority(priority);
        }
    }

    @Override
    public void stop() {

    }

    @Override
    public void attachView(@NonNull View view) {
        this.view=view;
    }
}
