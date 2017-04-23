package com.popularmovies.vpaliy.todo.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.popularmovies.vpaliy.todo.R;
import com.popularmovies.vpaliy.todo.di.component.DaggerViewComponent;
import com.popularmovies.vpaliy.todo.di.module.PresenterModule;
import com.popularmovies.vpaliy.todo.mvp.contract.RegisterTODOContract;
import com.popularmovies.vpaliy.todo.mvp.contract.RegisterTODOContract.Presenter;
import com.popularmovies.vpaliy.todo.ui.TODOApp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class RegisterTaskFragment extends Fragment
        implements RegisterTODOContract.View{

    private Presenter presenter;
    private Unbinder unbinder;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        inject();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_register_task,container,false);
        unbinder=ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(view!=null){
        }
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
    public void attachPresenter(@NonNull Presenter presenter) {
        this.presenter=presenter;
        this.presenter.attachView(this);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if(unbinder!=null){
            unbinder.unbind();
        }
    }
}
