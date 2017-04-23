package com.popularmovies.vpaliy.todo.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.popularmovies.vpaliy.todo.di.component.DaggerViewComponent;
import com.popularmovies.vpaliy.todo.di.module.PresenterModule;
import com.popularmovies.vpaliy.todo.domain.model.TODOTask;
import com.popularmovies.vpaliy.todo.mvp.contract.RegisterTODOContract;
import com.popularmovies.vpaliy.todo.mvp.contract.RegisterTODOContract.Presenter;
import com.popularmovies.vpaliy.todo.ui.TODOApp;

public class RegisterFragment extends Fragment
            implements RegisterTODOContract.View{

    private Presenter presenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        inject();
    }

    private void inject(){
        DaggerViewComponent.builder()
                .applicationComponent(TODOApp.provideInstance()
                    .provideAppComponent())
                .presenterModule(new PresenterModule())
                .build().inject(this);
    }

    @Override
    public void showWrongDescriptionMessage() {

    }

    @Override
    public void showWrongPriorityMessage() {

    }

    @Override
    public void attachPresenter(@NonNull RegisterTODOContract.Presenter presenter) {

    }


}
