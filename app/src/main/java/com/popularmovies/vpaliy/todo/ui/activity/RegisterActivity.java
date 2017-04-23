package com.popularmovies.vpaliy.todo.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.popularmovies.vpaliy.todo.R;
import com.popularmovies.vpaliy.todo.ui.TODOApp;
import com.popularmovies.vpaliy.todo.ui.fragment.RegisterFragment;
import com.popularmovies.vpaliy.todo.ui.utils.Constants;


public class RegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if(savedInstanceState==null) setUp();
    }

    private void setUp(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameHolder,new RegisterFragment(), Constants.FRAGMENT_REGISTER_TAG)
                .commit();
    }
    @Override
    void handleEvent(@NonNull Object event) {

    }

    @Override
    void inject() {
        TODOApp.provideInstance()
                .provideAppComponent()
                .inject(this);
    }
}
