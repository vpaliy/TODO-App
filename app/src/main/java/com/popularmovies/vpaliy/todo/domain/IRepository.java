package com.popularmovies.vpaliy.todo.domain;

import com.popularmovies.vpaliy.todo.domain.model.TODOTask;

import java.util.List;

import rx.Observable;

public interface IRepository {

    Observable<List<TODOTask>> getTaskList();
    Observable<TODOTask> findTaskById(int taskId);

    void deleteTask(int taskId);
    void insertTask(TODOTask task);
    void updateTask(TODOTask task);
}
