package com.popularmovies.vpaliy.todo.di.component;


import android.content.Context;
import android.support.annotation.NonNull;

import com.popularmovies.vpaliy.todo.data.source.DataSource;
import com.popularmovies.vpaliy.todo.data.utils.SchedulerProvider;
import com.popularmovies.vpaliy.todo.di.module.ApplicationModule;
import com.popularmovies.vpaliy.todo.di.module.DataModule;
import com.popularmovies.vpaliy.todo.domain.IRepository;
import com.popularmovies.vpaliy.todo.ui.activity.BaseActivity;
import com.popularmovies.vpaliy.todo.ui.eventBus.RxBus;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, DataModule.class})
public interface ApplicationComponent {

    void inject(BaseActivity activity);

    Context context();
    RxBus rxBus();
    SchedulerProvider schedulerProvider();
    IRepository iRepository();
}
