package com.popularmovies.vpaliy.todo.data.source.local;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;

import com.popularmovies.vpaliy.todo.data.source.DataSource;
import com.popularmovies.vpaliy.todo.data.utils.SchedulerProvider;
import com.popularmovies.vpaliy.todo.domain.model.Priority;
import com.popularmovies.vpaliy.todo.domain.model.TODOTask;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;


@Singleton
public class TaskLocalSource implements DataSource {

    private final SchedulerProvider schedulerProvider;
    private final ContentResolver contentResolver;

    @Inject
    public TaskLocalSource(@NonNull Context context,
                           @NonNull SchedulerProvider schedulerProvider){
        this.schedulerProvider=schedulerProvider;
        this.contentResolver=context.getContentResolver();
    }

    @Override
    public void deleteTask(int taskId) {
        contentResolver.delete(ContentUris.withAppendedId(TaskContract.TaskEntry
                .CONTENT_URI,taskId),null,null);
    }

    @Override
    public void updateTask(TODOTask task) {
        contentResolver.update(ContentUris.withAppendedId(TaskContract.TaskEntry.
                CONTENT_URI,task.getTaskId()),toContentValues(task),null,null);
    }

    @Override
    public void insertTask(TODOTask task) {
        contentResolver.insert(TaskContract.TaskEntry.CONTENT_URI,toContentValues(task));
    }

    @Override
    public Observable<TODOTask> findTaskById(int taskId) {
        return Observable.fromCallable(()->toTask(contentResolver
                .query(ContentUris.withAppendedId(TaskContract.TaskEntry.CONTENT_URI,taskId),
                        TaskContract.TaskEntry.COLUMNS,null,null,null)));
    }

    @Override
    public Observable<List<TODOTask>> getTaskList() {
        return Observable.fromCallable(()->toTasks(contentResolver
                .query(TaskContract.TaskEntry.CONTENT_URI,TaskContract.TaskEntry.COLUMNS,
                        null,null,null)));
    }

    private List<TODOTask> toTasks(Cursor cursor){
        if(cursor!=null){
            if(cursor.moveToFirst()){
                List<TODOTask> todoTaskList = new ArrayList<>(cursor.getCount());
                while(cursor.moveToNext()){
                    TODOTask task=new TODOTask();
                    String date =null;// cursor.getString(cursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_DEADLINE));
                    if (date != null) {
                        // task.setDueDate(DateFormat.getDateInstance().parse(date));
                    }

                    task.setDescription(cursor.getString(cursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_DESCRIPTION)));
                    task.setFinished(cursor.getInt(cursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_FINISHED)) == 1);
                    task.setPriority(Priority.valueOf(cursor.getString(cursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_PRIORITY))));
                    task.setTitle(cursor.getString(cursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_TITLE)));
                    task.setTaskId(cursor.getInt(cursor.getColumnIndex(TaskContract.TaskEntry._ID)));
                    todoTaskList.add(task);
                }
                return todoTaskList;
            }
            cursor.close();
        }
        return new ArrayList<>();
    }

    private TODOTask toTask(Cursor cursor){
        if(cursor!=null){
            TODOTask task=new TODOTask();
            if(cursor.moveToFirst()) {
                String date = cursor.getString(cursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_DEADLINE));
                if (date != null) {
                    // task.setDueDate(DateFormat.getDateInstance().parse(date));
                }

                task.setDescription(cursor.getString(cursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_DESCRIPTION)));
                task.setFinished(cursor.getInt(cursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_FINISHED)) == 1);
                task.setPriority(Priority.valueOf(cursor.getString(cursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_PRIORITY))));
                task.setTitle(cursor.getString(cursor.getColumnIndex(TaskContract.TaskEntry.COLUMN_TITLE)));
                task.setTaskId(cursor.getInt(cursor.getColumnIndex(TaskContract.TaskEntry._ID)));
                return task;
            }
            cursor.close();
        }
        return null;
    }

    private ContentValues toContentValues(@NonNull TODOTask task){
        ContentValues values=new ContentValues();
        //values.put(TaskContract.TaskEntry._ID,task.getTaskId());
        values.put(TaskContract.TaskEntry.COLUMN_TITLE,task.getTitle());
        values.put(TaskContract.TaskEntry.COLUMN_DESCRIPTION,task.getDescription());
        values.put(TaskContract.TaskEntry.COLUMN_DEADLINE,task.getDueDate()!=null
                ?task.getDueDate().toString():null);
        values.put(TaskContract.TaskEntry.COLUMN_FINISHED,task.isFinished());
        values.put(TaskContract.TaskEntry.COLUMN_PRIORITY,task.getPriority().toString());
        return values;
    }
}
