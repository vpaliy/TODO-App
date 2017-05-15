package com.popularmovies.vpaliy.todo.data.repository;

import com.popularmovies.vpaliy.todo.domain.IRepository;
import com.popularmovies.vpaliy.todo.domain.model.Task;
import java.util.List;
import rx.Observable;
import javax.inject.Singleton;

@Singleton
public class TaskRepository implements IRepository {

    @Override
    public Observable<List<Task>> getTaskList() {
        return null;
    }

    @Override
    public void updateTask(Task task) {

    }

    @Override
    public Observable<Task> findTaskById(int taskId) {
        return null;
    }

    @Override
    public void deleteTask(int taskId) {

    }

    @Override
    public void insertTask(Task task) {

    }
}
