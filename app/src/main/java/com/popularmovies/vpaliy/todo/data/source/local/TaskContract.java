package com.popularmovies.vpaliy.todo.data.source.local;


import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class TaskContract {


    interface CategoryColumns {
        String CATEGORY_ID="category_id";
        String CATEGORY_NAME="category_name";
    }

    interface TaskColumns{
        String TASK_ID="task_id";
        String TASK_HEADLINE="task_headline";
        String TASK_CATEGORY_ID="task_category_id";
        String TASK_DUE_DATE="task_due_date";
        String TASK_CYCLE_ID="task_cycle_id";
        String TASK_PRIORITY_ID="task_priority_id";
        String TASK_IS_DONE="task_is_done";
        String TASK_NOTE_ID="task_note_id";
    }

    interface TodoItemColumns {
        String TODO_ITEM_PLAN_ID="todo_item_plan_id";
    }


    interface GoalColumns{
        String GOAL_PLAN_ID="plan_id";
    }

    interface TaskNoteColumns{
        String TASK_ID="task_id";
    }

    interface ReviewColumns {

    }


    interface PlanColumns {
        String PLAN_ID="plan_id";
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


}
