package com.popularmovies.vpaliy.todo.ui.adapter;


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.popularmovies.vpaliy.todo.ui.utils.wrapper.InputWrapper;

public class RegisterTaskAdapter extends FragmentPagerAdapter {

    private static final int TITLE=0;
    private static final int PRIORITY=1;
    private static final int DESCRIPTION=2;
    private static final int DEADLINE=3;

    public RegisterTaskAdapter(@NonNull FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        InputWrapper inputWrapper=null;
        switch (position){
            case TITLE:

            case PRIORITY:
                return null;
            case DESCRIPTION:
                return null;
            case DEADLINE:
                return null;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}