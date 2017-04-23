package com.popularmovies.vpaliy.todo.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import com.popularmovies.vpaliy.todo.R;
import com.popularmovies.vpaliy.todo.di.component.DaggerViewComponent;
import com.popularmovies.vpaliy.todo.di.module.PresenterModule;
import com.popularmovies.vpaliy.todo.domain.model.TODOTask;
import com.popularmovies.vpaliy.todo.mvp.contract.TODOTasksContract;
import com.popularmovies.vpaliy.todo.mvp.contract.TODOTasksContract.Presenter;
import com.popularmovies.vpaliy.todo.ui.TODOApp;
import com.popularmovies.vpaliy.todo.ui.adapter.TaskAdapter;
import com.popularmovies.vpaliy.todo.ui.eventBus.RxBus;
import java.util.List;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import javax.inject.Inject;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import butterknife.BindView;

public class TODOFragment extends Fragment
        implements TODOTasksContract.View{

    private Presenter presenter;

    @Inject
    protected RxBus rxBus;

    @BindView(R.id.todoList)
    protected RecyclerView recyclerView;

    private TaskAdapter adapter;
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
        View view=inflater.inflate(R.layout.fragment_todo,container,false);
        unbinder=ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(view!=null){
            presenter.start();
            adapter=new TaskAdapter(getContext(),rxBus);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                    LinearLayoutManager.VERTICAL,false));
            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
            recyclerView.setAdapter(adapter);

            new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT,ItemTouchHelper.RIGHT) {
                @Override
                public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                    return false;
                }

                @Override
                public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                    final int position=viewHolder.getAdapterPosition();
                    final TODOTask removedTask=adapter.removeAt(position);
                    Snackbar.make(view,R.string.emptyTaskMessage,Snackbar.LENGTH_LONG)
                            .addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
                                @Override
                                public void onDismissed(Snackbar transientBottomBar, int event) {
                                    super.onDismissed(transientBottomBar, event);
                                    switch (event){
                                        default:

                                    }
                                }
                            })
                            .setAction("UNDO", v->adapter.addTask(position,removedTask))
                            .show();
                }
            }).attachToRecyclerView(recyclerView);

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
    public void showErrorMessage() {
        if(getView()!=null){
            Snackbar.make(getView(), R.string.errorTaskMessage,Snackbar.LENGTH_LONG);
        }
    }

    @Override
    public void showEmptyMessage() {
        if(getView()!=null){
            Snackbar.make(getView(), R.string.emptyTaskMessage,Snackbar.LENGTH_LONG);
        }
    }

    @Override
    public void onDestroy() {
        if(unbinder!=null){
            unbinder.unbind();
        }
        super.onDestroy();
    }

    @Override
    public void showTaskList(@NonNull List<TODOTask> todoTaskList) {
        adapter.setData(todoTaskList);
    }

    @Override
    @Inject
    public void attachPresenter(@NonNull TODOTasksContract.Presenter presenter) {
        this.presenter=presenter;
        this.presenter.attachView(this);
    }
}
