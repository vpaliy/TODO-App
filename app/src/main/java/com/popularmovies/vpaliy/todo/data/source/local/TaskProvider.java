package com.popularmovies.vpaliy.todo.data.source.local;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class TaskProvider extends ContentProvider {

    private SQLiteOpenHelper openHelper;


    private static final int TASKS=100;
    private static final int TASK_WITH_ID=101;

    private static final String TASK_SELECTION_BY_ID=
            TaskContract.TaskEntry.TABLE_NAME+"."+ TaskContract.TaskEntry._ID+" =?";

    public static UriMatcher buildUriMatcher(){
        UriMatcher uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        final String authority=TaskContract.CONTENT_AUTHORITY;

        uriMatcher.addURI(authority,TaskContract.PATH_TASKS,TASKS);
        uriMatcher.addURI(authority,TaskContract.PATH_TASKS+"/#",TASK_WITH_ID);

        return uriMatcher;
    }

    private static final UriMatcher MATCHER=buildUriMatcher();


    public TaskProvider(){}

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        final int match=MATCHER.match(uri);
        int rowsDeleted=0;
        switch (match){
            case TASKS:
                rowsDeleted=openHelper.getWritableDatabase()
                        .delete(TaskContract.TaskEntry.TABLE_NAME,selection,selectionArgs);
                break;
            case TASK_WITH_ID:
                long id=ContentUris.parseId(uri);
                rowsDeleted=openHelper.getWritableDatabase()
                        .delete(TaskContract.TaskEntry.TABLE_NAME,
                                TASK_SELECTION_BY_ID,new String[]{Long.toString(id)});
                break;
        }

        return rowsDeleted;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        int match=MATCHER.match(uri);
        switch (match){
            case TASKS:
                return TaskContract.TaskEntry.CONTENT_DIR_TYPE;
            case TASK_WITH_ID:
                return TaskContract.TaskEntry.CONTENT_ITEM_TYPE;
        }
        return null;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int match=MATCHER.match(uri);
        int rowsUpdated=0;
        switch (match){
            case TASKS:
                rowsUpdated=openHelper.getWritableDatabase()
                        .update(TaskContract.TaskEntry.TABLE_NAME,
                                values,selection,selectionArgs);
                break;
            case TASK_WITH_ID:
                rowsUpdated=0;
                break;
        }
        return rowsUpdated;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        int match=MATCHER.match(uri);
        Cursor cursor=null;
        switch (match){
            case TASKS:
                cursor=openHelper.getReadableDatabase()
                        .query(TaskContract.TaskEntry.TABLE_NAME,projection,
                                selection,selectionArgs,
                                null,null,sortOrder);
                break;
            case TASK_WITH_ID:
                cursor=getTaskById(uri,projection,sortOrder);
                break;
        }
        return cursor;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        int match=MATCHER.match(uri);
        long ID=-1;
        switch (match){
            case TASKS:
                ID=openHelper.getWritableDatabase()
                        .insert(TaskContract.TaskEntry.TABLE_NAME,null,values);
                break;
            case TASK_WITH_ID:
                break;
        }
        return ID!=-1?ContentUris.withAppendedId
                (TaskContract.TaskEntry.CONTENT_URI,ID):null;
    }

    @Override
    public boolean onCreate() {
        if (getContext() != null) {
            openHelper=new TaskSQLHelper(getContext());
            return openHelper.getReadableDatabase()!=null;
        }
        return false;
    }

    private Cursor getTaskById(Uri uri, String[] projection, String sortOrder){
        long taskId= ContentUris.parseId(uri);
        String[] selectionArgs={Long.toString(taskId)};

        return openHelper.getReadableDatabase()
                .query(TaskContract.TaskEntry.TABLE_NAME,projection,
                        TASK_SELECTION_BY_ID,selectionArgs,null,null,sortOrder);
    }
}
