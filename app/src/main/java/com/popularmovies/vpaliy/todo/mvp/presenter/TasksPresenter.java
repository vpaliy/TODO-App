package com.popularmovies.vpaliy.todo.mvp.presenter;


import com.popularmovies.vpaliy.todo.data.utils.SchedulerProvider;
import com.popularmovies.vpaliy.todo.di.scope.UserScope;
import com.popularmovies.vpaliy.todo.domain.IRepository;
import com.popularmovies.vpaliy.todo.domain.model.Task;
import com.popularmovies.vpaliy.todo.mvp.contract.TODOTasksContract;
import com.popularmovies.vpaliy.todo.mvp.contract.TODOTasksContract.View;
import java.util.List;

import javax.inject.Inject;
import android.support.annotation.NonNull;
import android.util.Log;

import rx.subscriptions.CompositeSubscription;

@UserScope
public class TasksPresenter
    implements TODOTasksContract.Presenter{

    private static final String TAG=TasksPresenter.class.getSimpleName();

    private View view;
    private final IRepository iRepository;
    private final SchedulerProvider schedulerProvider;
    private final CompositeSubscription subscriptions;

    @Inject
    public TasksPresenter(@NonNull IRepository iRepository,
                          @NonNull SchedulerProvider schedulerProvider){
        this.iRepository=iRepository;
        this.subscriptions=new CompositeSubscription();
        this.schedulerProvider=schedulerProvider;
    }


    @Override
    public void attachView(@NonNull View view) {
        this.view=view;
        Log.d(TAG,"attachView()");
    }


    @Override
    public void start() {
        Log.d(TAG,"start()");
        subscriptions.add(iRepository.getTaskList()
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe(this::processData,
                       this::processErrorMessage,
                       ()->{}));
    }

    @Override
    public void stop() {
        subscriptions.clear();
    }

    private void processData(@NonNull List<Task> todoTaskList){
        Log.d(TAG,"processData()");
        if(todoTaskList.isEmpty()){
            view.showEmptyMessage();
        }else{
            view.showTaskList(todoTaskList);
        }
    }

    private void processErrorMessage(Throwable throwable){
        throwable.printStackTrace();
        view.showErrorMessage();
    }
}
