package com.popularmovies.vpaliy.todo.ui;

import android.app.Application;
import android.widget.SimpleCursorTreeAdapter;

import com.popularmovies.vpaliy.todo.di.component.ApplicationComponent;
import com.popularmovies.vpaliy.todo.di.component.DaggerApplicationComponent;
import com.popularmovies.vpaliy.todo.di.module.ApplicationModule;
import com.popularmovies.vpaliy.todo.di.module.DataModule;


public class TODOApp extends Application {

    private ApplicationComponent appComponent;
    private static TODOApp INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeAppComponent();
        INSTANCE=this;
    }

    public static TODOApp provideInstance(){
        return INSTANCE;
    }

    public ApplicationComponent provideAppComponent(){
        return appComponent;
    }

    private void initializeAppComponent(){
        appComponent= DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .dataModule(new DataModule())
                .build();
    }
}
