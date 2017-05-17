package com.popularmovies.vpaliy.todo.data.source.local;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import static com.popularmovies.vpaliy.todo.data.source.local.TaskContract.Tasks;
import static com.popularmovies.vpaliy.todo.data.source.local.TaskContract.Reviews;
import static com.popularmovies.vpaliy.todo.data.source.local.TaskContract.Categories;
import static com.popularmovies.vpaliy.todo.data.source.local.TaskContract.Goals;
import static com.popularmovies.vpaliy.todo.data.source.local.TaskContract.Plans;
import static com.popularmovies.vpaliy.todo.data.source.local.TaskContract.TodoItems;
import static com.popularmovies.vpaliy.todo.data.source.local.TaskContract.Cycles;

public class TaskSQLHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="tasks.db";
    private static final int DATABASE_VERSION=1;


    interface Tables {
        String TASKS="tasks";
        String REVIEWS="reviews";
        String CATEGORIES="categories";
        String TODO_ITEMS="todo_items";
        String GOALS="goals";
        String PLANS="plans";
        String TASK_NOTES="notes";
        String CYCLES="cycles";


    }

    interface References {
        String TASK_ID="REFERENCES "+Tables.TASKS+"("+Tasks.TASK_ID+")";
        String PLAN_ID="REFERENCES "+Tables.PLANS+"("+Plans.PLAN_ID+")";
        String REVIEW_ID="REFERENCES "+Tables.REVIEWS+"("+Reviews.REVIEW_ID+")";
        String CATEGORY_ID="REFERENCES "+Tables.CATEGORIES+"("+Categories.CATEGORY_ID+")";
        String CYCLE_ID="REFERENCES "+Tables.CYCLES+"("+Cycles.CYCLE_ID+")";
    }

    public TaskSQLHelper(@NonNull Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+Tables.TASKS+" ("+
            Tasks.TASK_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            Tasks.TASK_HEADLINE+" TEXT NOT NULL,"+
            Tasks.TASK_DUE_DATE+" TEXT,"+
            Tasks.TASK_IS_DONE+" INTEGER NOT NULL,"+
            Tasks.TASK_CATEGORY_ID+" TEXT "+References.CATEGORY_ID+","+
            Tasks.TASK_CYCLE_ID+" INTEGER "+References.CYCLE_ID+","+
            Tasks.TASK_PRIORITY+" TEXT,"+
                " UNIQUE (" + Tasks.TASK_ID + ") ON CONFLICT REPLACE)");

        db.execSQL("CREATE TABLE "+Tables.TODO_ITEMS+" ("+
                TodoItems.TODO_ITEM_ID+" INTEGER PRIMARY KEY,"+
                TodoItems.TODO_ITEM_ID+" INTEGER FOREIGN KEY"+References.TASK_ID+","+
                " UNIQUE (" + TodoItems.TODO_ITEM_ID + ") ON CONFLICT REPLACE)");

        db.execSQL("CREATE TABLE "+Tables.GOALS+" ("+
                Goals.GOAL_ID+" INTEGER PRIMARY KEY,"+
                Goals.GOAL_PLAN_ID+" INTEGER "+References.PLAN_ID+","+
                Goals.GOAL_ID+" INTEGER FOREIGN KEY "+References.TASK_ID+","+
                " UNIQUE (" + TodoItems.TODO_ITEM_ID + ") ON CONFLICT REPLACE)");

        db.execSQL("CREATE TABLE "+Tables.CYCLES+" ("+
                Cycles.CYCLE_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                Cycles.CYCLE_FREQUENCY+" TEXT NOT NULL,"+
                Cycles.CYCLE_START_DATE+" TEXT NOT NULL,"+
                Cycles.CYCLE_COUNT+" INTEGER,"+
                " UNIQUE (" + Cycles.CYCLE_ID + ") ON CONFLICT REPLACE)");

        db.execSQL("CREATE TABLE "+Tables.CATEGORIES+" ("+
                Categories.CATEGORY_ID+" TEXT NOT NULL PRIMARY KEY,"+
                Categories.CATEGORY_NAME+" TEXT NOT NULL,"+
                " UNIQUE (" + Categories.CATEGORY_NAME + ") ON CONFLICT REPLACE)");

        db.execSQL("CREATE TABLE "+Tables.PLANS+" ("+
                Plans.PLAN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                " UNIQUE (" + Plans.PLAN_ID + ") ON CONFLICT REPLACE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF EXISTS "+Tables.TASKS);
        db.execSQL("DROP IF EXISTS "+Tables.PLANS);
        db.execSQL("DROP IF EXISTS "+Tables.CATEGORIES);
        db.execSQL("DROP IF EXISTS "+Tables.GOALS);
        db.execSQL("DROP IF EXISTS "+Tables.REVIEWS);
        db.execSQL("DROP IF EXISTS "+Tables.TODO_ITEMS);
        db.execSQL("DROP IF EXISTS "+Tables.CYCLES);
        onCreate(db);
    }
}
