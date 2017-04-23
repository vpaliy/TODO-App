package com.popularmovies.vpaliy.todo.di.module;

import android.content.Context;
import android.support.annotation.NonNull;

import com.popularmovies.vpaliy.todo.ui.eventBus.RxBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Context context;

    public ApplicationModule(@NonNull Context context){
        this.context=context;
    }

    @Singleton
    @Provides
    Context provideContext(){
        return context;
    }

    @Singleton
    @Provides
    RxBus provideRxBus(){
        return new RxBus();
    }



}
