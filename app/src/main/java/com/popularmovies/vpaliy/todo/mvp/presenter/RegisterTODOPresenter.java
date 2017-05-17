package com.popularmovies.vpaliy.todo.mvp.presenter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.popularmovies.vpaliy.todo.di.scope.UserScope;
import com.popularmovies.vpaliy.todo.domain.model.Priority;
import com.popularmovies.vpaliy.todo.mvp.contract.RegisterTODOContract;
import com.popularmovies.vpaliy.todo.mvp.contract.RegisterTODOContract.View;

import java.util.Calendar;
import java.util.Date;

@UserScope
public class RegisterTODOPresenter
        implements RegisterTODOContract.Presenter {

    private View view;

    public RegisterTODOPresenter(){
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
    }

    @Override
    public void submitDueDate(@Nullable Date date) {

    }

    @Override
    public void submitPriority(@NonNull Priority priority) {

    }

    @Override
    public void stop() {

    }

    @Override
    public void attachView(@NonNull View view) {
        this.view=view;
    }
}
