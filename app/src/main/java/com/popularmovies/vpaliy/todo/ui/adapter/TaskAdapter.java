package com.popularmovies.vpaliy.todo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.popularmovies.vpaliy.todo.R;
import com.popularmovies.vpaliy.todo.domain.model.Task;
import com.popularmovies.vpaliy.todo.ui.eventBus.RxBus;
import com.popularmovies.vpaliy.todo.ui.eventBus.event.ExposeDetailsEvent;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import android.support.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private static final String TAG=TaskAdapter.class.getSimpleName();

    private List<Task> taskList;
    private LayoutInflater inflater;
    private RxBus rxBus;

    public TaskAdapter(@NonNull Context context,
                       @NonNull RxBus rxBus){
        this.inflater=LayoutInflater.from(context);
        this.rxBus=rxBus;
        this.taskList=new ArrayList<>();
    }



    public class TaskViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        @BindView(R.id.title) TextView taskTitle;

        public TaskViewHolder(@NonNull View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        void onBindData(){
        }

        @Override
        public void onClick(View v) {
            Task task=taskList.get(getAdapterPosition());
            rxBus.send(new ExposeDetailsEvent(task.getTaskId()));
        }
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TaskViewHolder(inflater.inflate(R.layout.adapter_todo_item,parent,false));
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.onBindData();
    }

    public void setData(@NonNull List<Task> taskList){
        Log.d(TAG,Integer.toString(taskList.size()));
        this.taskList=taskList;
        notifyDataSetChanged();
    }

    public Task removeAt(int index){
        if(index<0||index>=taskList.size()) return null;
        Task task=taskList.get(index);
        taskList.remove(index);
        notifyItemRemoved(index);
        return task;
    }

    public void addTask(int position, @NonNull Task task){
        taskList.add(position,task);
        notifyItemInserted(position);
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}
