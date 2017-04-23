package com.popularmovies.vpaliy.todo.mvp.contract;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.popularmovies.vpaliy.todo.domain.model.Priority;
import com.popularmovies.vpaliy.todo.mvp.BasePresenter;
import com.popularmovies.vpaliy.todo.mvp.BaseView;

import java.util.Date;

public interface RegisterTODOContract {

    interface View extends BaseView<Presenter> {
        void attachPresenter(@NonNull Presenter presenter);
        void showWrongDescriptionMessage();
        void showWrongPriorityMessage();

    }

    interface Presenter extends BasePresenter<View> {
        void attachView(@NonNull View view);
        void submitDescription(@NonNull String description);
        void submitPriority(@NonNull Priority priority);
        void submitDueDate(@Nullable Date date);
        void stop();
    }
}
