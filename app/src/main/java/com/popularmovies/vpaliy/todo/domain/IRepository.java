package com.popularmovies.vpaliy.todo.domain;

import com.popularmovies.vpaliy.todo.domain.model.Task;
import java.util.List;
import rx.Observable;

public interface IRepository {

    Observable<List<Task>> getTaskList();
    Observable<Task> findTaskById(int taskId);

    void deleteTask(int taskId);
    void insertTask(Task task);
    void updateTask(Task task);
}
