package com.popularmovies.vpaliy.todo.data.source.local;


import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class TaskContract {

    interface CategoryColumns {

    }

    interface TaskColumns{

    }

    interface GoalColumns{

    }

    interface TaskNoteColumns{

    }

    interface ReviewColumns {

    }


    interface PlanColumns {

    }


    public static final String CONTENT_AUTHORITY="com.popularmovies.vpaliy.todo";
    public static final Uri BASE_CONTENT_URI=Uri.parse("content://"+CONTENT_AUTHORITY);

    public static final String PATH_TASK="tasks";
    public static final String PATH_CATEGORY="category";
    public static final String PATH_PRIORITY="priority";
    public static final String PATH_TASK_CYCLE="task_cycle";
    public static final String PATH_TASK_NOTE="task_note";
    public static final String PATH_REVIEW="review";


    private TaskContract(){
        throw new UnsupportedOperationException();
    }

    public static class TaskEntry implements BaseColumns{

        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(PATH_TASK).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TASK;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TASK;

        public static final String TABLE_NAME="tasks";
        public static final String COLUMN_TITLE="title";
        public static final String COLUMN_DESCRIPTION="description";
        public static final String COLUMN_DEADLINE="deadline";
        public static final String COLUMN_PRIORITY="priority";
        public static final String COLUMN_FINISHED="isFinished";

        public static final String SQL_CREATE_TABLE=
                "CREATE TABLE "+TABLE_NAME+" ("+
                        _ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        COLUMN_TITLE+" TEXT NOT NULL, "+
                        COLUMN_DESCRIPTION+ " TEXT , "+
                        COLUMN_PRIORITY+" STRING NOT NULL, "+
                        COLUMN_FINISHED+" BOOLEAN NOT NULL, "+
                        COLUMN_DEADLINE+" STRING"+");";

        public static final String[] COLUMNS={_ID,COLUMN_TITLE,COLUMN_DESCRIPTION,
                COLUMN_PRIORITY,COLUMN_FINISHED,COLUMN_DESCRIPTION};


    }
}
