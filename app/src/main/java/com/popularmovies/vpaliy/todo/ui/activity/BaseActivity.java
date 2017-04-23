package com.popularmovies.vpaliy.todo.ui.activity;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.popularmovies.vpaliy.todo.ui.eventBus.RxBus;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseActivity extends AppCompatActivity{

    @Inject
    protected RxBus rxBus;

    protected CompositeDisposable disposables;

    /**
     * Handle the user events
     */
    abstract void handleEvent(@NonNull Object event);

    /**
     * Initialize the dependencies
     */
    abstract void inject();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        inject();
        disposables=new CompositeDisposable();
        super.onCreate(savedInstanceState);
    }

    @CallSuper
    @Override
    protected void onStart() {
        super.onStart();
        disposables.add(rxBus.asFlowable()
                .subscribe(this::processEvent));
    }

    private void processEvent(Object object){
        if(object!=null){
            handleEvent(object);
        }
    }

    @CallSuper
    @Override
    protected void onStop(){
        super.onStop();
        disposables.clear();
    }

}
