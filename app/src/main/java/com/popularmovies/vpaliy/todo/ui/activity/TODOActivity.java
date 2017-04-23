package com.popularmovies.vpaliy.todo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.popularmovies.vpaliy.todo.R;
import com.popularmovies.vpaliy.todo.ui.TODOApp;
import com.popularmovies.vpaliy.todo.ui.eventBus.event.RegisterEvent;
import com.popularmovies.vpaliy.todo.ui.fragment.TODOFragment;
import com.popularmovies.vpaliy.todo.ui.utils.Constants;


public class TODOActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        if(savedInstanceState==null) setUp();
    }

    private void setUp(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameHolder,new TODOFragment(), Constants.FRAGMENT_TODO_TAG)
                .commit();
    }

    @Override
    void handleEvent(@NonNull Object event) {
        if(event instanceof RegisterEvent){
            startActivity(new Intent(this,RegisterActivity.class));
        }
    }

    @Override
    void inject() {
        TODOApp.provideInstance()
                .provideAppComponent()
                .inject(this);
    }
}
