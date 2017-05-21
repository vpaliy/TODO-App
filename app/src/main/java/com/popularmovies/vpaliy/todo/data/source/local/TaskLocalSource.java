package com.popularmovies.vpaliy.todo.data.source.local;

import android.content.ContentResolver;
import android.content.Context;
import android.support.annotation.NonNull;

import com.popularmovies.vpaliy.todo.data.source.DataSource;
import com.popularmovies.vpaliy.todo.data.utils.SchedulerProvider;
import com.popularmovies.vpaliy.todo.domain.model.Task;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;


@Singleton
public class TaskLocalSource implements DataSource{

    private final SchedulerProvider schedulerProvider;
    private final ContentResolver contentResolver;

    @Inject
    public TaskLocalSource(@NonNull Context context,
                           @NonNull SchedulerProvider schedulerProvider){
        this.schedulerProvider=schedulerProvider;
        this.contentResolver=context.getContentResolver();
    }

    @Override
    public void deleteTask(int taskId) {
    }

    @Override
    public void updateTask(Task task) {
    }

    @Override
    public void insertTask(Task task) {
    }

    @Override
    public Observable<Task> findTaskById(int taskId) {
        return null;
    }

    @Override
    public Observable<List<Task>> getTaskList() {
        return null;
    }

}
