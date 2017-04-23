package com.popularmovies.vpaliy.todo.di.module;


import android.support.annotation.NonNull;

import com.popularmovies.vpaliy.todo.data.repository.TaskRepository;
import com.popularmovies.vpaliy.todo.data.source.DataSource;
import com.popularmovies.vpaliy.todo.data.source.local.TaskLocalSource;
import com.popularmovies.vpaliy.todo.data.utils.SchedulerProvider;
import com.popularmovies.vpaliy.todo.domain.IRepository;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {


    @Singleton
    @Provides
    SchedulerProvider provideSchedulers(){
        return new SchedulerProvider();
    }

    @Singleton
    @Provides
    DataSource provideLocalDataSource(@NonNull TaskLocalSource localSource){
        return localSource;
    }

    @Singleton
    @Provides
    IRepository provideTaskRepository(@NonNull TaskRepository taskRepository){
        return taskRepository;
    }
}
