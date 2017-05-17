package com.popularmovies.vpaliy.todo.mvp.contract;


import android.support.annotation.NonNull;

import com.popularmovies.vpaliy.todo.domain.model.Task;
import com.popularmovies.vpaliy.todo.mvp.BasePresenter;
import com.popularmovies.vpaliy.todo.mvp.BaseView;

import java.util.List;

public interface TODOTasksContract {

    interface View extends BaseView<Presenter> {
        void attachPresenter(@NonNull Presenter presenter);
        void showErrorMessage();
        void showEmptyMessage();
        void showTaskList(@NonNull List<Task> todoTaskList);
    }

    interface Presenter extends BasePresenter<View> {
        void attachView(@NonNull View view);
        void start();
        void stop();

    }

}
