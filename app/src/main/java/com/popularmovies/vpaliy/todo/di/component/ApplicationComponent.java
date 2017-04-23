package com.popularmovies.vpaliy.todo.di.component;


import android.content.Context;
import com.popularmovies.vpaliy.todo.data.utils.SchedulerProvider;
import com.popularmovies.vpaliy.todo.di.module.ApplicationModule;
import com.popularmovies.vpaliy.todo.di.module.DataModule;
import com.popularmovies.vpaliy.todo.domain.IRepository;
import com.popularmovies.vpaliy.todo.ui.activity.BaseActivity;
import com.popularmovies.vpaliy.todo.ui.eventBus.RxBus;
import com.popularmovies.vpaliy.todo.ui.fragment.RegisterFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, DataModule.class})
public interface ApplicationComponent {

    void inject(BaseActivity activity);
    void inject(RegisterFragment fragment);
    Context context();
    RxBus rxBus();
    SchedulerProvider schedulerProvider();
    IRepository iRepository();
}
