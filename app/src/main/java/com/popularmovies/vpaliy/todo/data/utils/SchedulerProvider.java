package com.popularmovies.vpaliy.todo.data.utils;


import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SchedulerProvider {

    public Scheduler io(){
        return Schedulers.io();
    }

    public Scheduler ui(){
        return AndroidSchedulers.mainThread();
    }

    public Scheduler newThread(){
        return Schedulers.newThread();
    }


}
