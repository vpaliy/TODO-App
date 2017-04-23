package com.popularmovies.vpaliy.todo.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.popularmovies.vpaliy.todo.R;
import com.popularmovies.vpaliy.todo.ui.TODOApp;
import com.popularmovies.vpaliy.todo.ui.eventBus.RxBus;
import com.popularmovies.vpaliy.todo.ui.utils.Constants;
import com.popularmovies.vpaliy.todo.ui.utils.wrapper.InputWrapper;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import javax.inject.Inject;

import static butterknife.ButterKnife.findById;

public class RegisterFragment extends Fragment {

    private InputWrapper inputWrapper;

    @Inject
    protected RxBus bus;

    public static RegisterFragment newInstance(@NonNull InputWrapper wrapper) {
        RegisterFragment fragment=new RegisterFragment();
        Bundle args=new Bundle();
        args.putParcelable(Constants.INPUT_WRAPPER,wrapper);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        if(savedInstanceState==null) {
            savedInstanceState=getArguments();
        }
        inputWrapper=savedInstanceState.getParcelable(Constants.INPUT_WRAPPER);
        initializeInjection();
    }

    private void initializeInjection() {
        TODOApp.provideInstance()
                .provideAppComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register_input,container,false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if(view!=null) {
            Button submitButton=findById(view, R.id.submitButton);
            EditText input=findById(view,R.id.dataInput);
            TextView property=findById(view,R.id.property);
            property.setText(inputWrapper.getProperty());
            //  input.setText(inputWrapper.getProperty());
            //input.setInputType(inputWrapper.getInputType());

            //notify the presenter;

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(Constants.INPUT_WRAPPER,inputWrapper);
        super.onSaveInstanceState(outState);
    }
}
