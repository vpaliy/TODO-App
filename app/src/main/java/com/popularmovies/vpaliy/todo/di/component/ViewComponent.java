package com.popularmovies.vpaliy.todo.di.component;

import com.popularmovies.vpaliy.todo.di.module.PresenterModule;
import com.popularmovies.vpaliy.todo.di.scope.UserScope;
import com.popularmovies.vpaliy.todo.ui.fragment.RegisterFragment;
import com.popularmovies.vpaliy.todo.ui.fragment.RegisterTaskFragment;
import com.popularmovies.vpaliy.todo.ui.fragment.TODOFragment;

import dagger.Component;

@UserScope
@Component(modules = PresenterModule.class,
           dependencies = ApplicationComponent.class)
public interface ViewComponent {
    void inject(RegisterTaskFragment fragment);
    void inject(TODOFragment fragment);
}
