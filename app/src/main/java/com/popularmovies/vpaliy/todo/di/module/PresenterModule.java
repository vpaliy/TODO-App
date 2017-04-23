package com.popularmovies.vpaliy.todo.di.module;

import android.support.annotation.NonNull;

import com.popularmovies.vpaliy.todo.di.scope.UserScope;
import com.popularmovies.vpaliy.todo.mvp.contract.RegisterTODOContract;
import com.popularmovies.vpaliy.todo.mvp.contract.TODOTasksContract;
import com.popularmovies.vpaliy.todo.mvp.presenter.RegisterTODOPresenter;
import com.popularmovies.vpaliy.todo.mvp.presenter.TasksPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    @UserScope
    TODOTasksContract.Presenter provideTasksPresenter(@NonNull TasksPresenter presenter){
        return presenter;
    }

    @Provides
    @UserScope
    RegisterTODOContract.Presenter provideRegisterPresenter(@NonNull RegisterTODOPresenter presenter){
        return presenter;
    }
}
