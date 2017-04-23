package com.popularmovies.vpaliy.todo.data.repository;


import android.support.annotation.NonNull;

import com.popularmovies.vpaliy.todo.data.source.DataSource;
import com.popularmovies.vpaliy.todo.domain.IRepository;
import com.popularmovies.vpaliy.todo.domain.model.TODOTask;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class TaskRepository implements IRepository {

    private DataSource localDataSource;

    @Inject
    public TaskRepository(@NonNull DataSource localDataSource){
        this.localDataSource=localDataSource;
    }

    @Override
    public Observable<List<TODOTask>> getTaskList() {
        return localDataSource.getTaskList();
    }

    @Override
    public Observable<TODOTask> findTaskById(int taskId) {
        return localDataSource.findTaskById(taskId);
    }

    @Override
    public void deleteTask(int taskId) {
        localDataSource.deleteTask(taskId);
    }

    @Override
    public void updateTask(TODOTask task) {
        localDataSource.updateTask(task);
    }

    @Override
    public void insertTask(TODOTask task) {
        localDataSource.insertTask(task);
    }
}
