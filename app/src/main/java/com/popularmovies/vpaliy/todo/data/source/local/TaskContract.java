package com.popularmovies.vpaliy.todo.data.source.local;


import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;

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
        String TASK_PRIORITY="task_priority";
        String TASK_IS_DONE="task_is_done";
    }

    interface TodoItemColumns {
        String TODO_ITEM_ID=TaskColumns.TASK_ID;
    }

    interface CycleColumns {
        String CYCLE_ID="cycle_id";
        String CYCLE_START_DATE="cycle_start_date";
        String CYCLE_FREQUENCY="cycle_frequency";
        String CYCLE_COUNT="cycle_count";
    }

    interface GoalColumns{
        String GOAL_ID=TaskColumns.TASK_ID;
        String GOAL_PLAN_ID="plan_id";
    }

    interface TaskNoteColumns{
        String TASK_ID="task_id";
    }

    interface ReviewColumns {
        String REVIEW_ID="review_id";
    }

    interface PlanColumns {
        String PLAN_ID="plan_id";
    }


    public static final String CONTENT_AUTHORITY="com.popularmovies.vpaliy.todo";
    public static final Uri BASE_CONTENT_URI=Uri.parse("content://"+CONTENT_AUTHORITY);

    public static final String PATH_TASK="tasks";
    public static final String PATH_CATEGORY="category";
    public static final String PATH_TASK_CYCLE="task_cycle";
    public static final String PATH_TODO_ITEM=PATH_TASK+"/"+"todo_item";
    public static final String PATH_GOAL=PATH_TASK+"/"+"goal";
    public static final String PATH_PLAN="plan";
    public static final String PATH_TASK_NOTE="task_note";
    public static final String PATH_REVIEW="review";


    private TaskContract(){
        throw new UnsupportedOperationException();
    }


    public static class Tasks implements TaskColumns {

        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(PATH_TASK).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TASK;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TASK;

        public static Uri buildTaskWithCategoryUri(String id){
            return CONTENT_URI.buildUpon().appendPath(id).appendPath(PATH_CATEGORY).build();
        }


        public static Uri buildTaskWithCycle(String id){
            return CONTENT_URI.buildUpon().appendPath(id).appendPath(PATH_TASK_CYCLE).build();
        }

        public static Uri buildTaskUri(String id){
            return CONTENT_URI.buildUpon().appendPath(id).build();
        }

        public static String getTaskId(Uri uri){
            return Long.toString(ContentUris.parseId(uri));
        }
    }

    public static class TodoItems implements TodoItemColumns {

        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(PATH_TODO_ITEM).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TODO_ITEM;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TODO_ITEM;

        public static Uri buildTodoItem(String id){
            return CONTENT_URI.buildUpon().appendPath(id).build();
        }

        public static String getTodoItemId(Uri uri){
            return Long.toString(ContentUris.parseId(uri));
        }
    }

    public static class Goals implements GoalColumns {

        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(PATH_GOAL).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GOAL;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_GOAL;

        public static Uri buildGoalUri(String id){
            return CONTENT_URI.buildUpon().appendPath(id).build();
        }

        public static Uri buildGoalPlan(String id){
            return CONTENT_URI.buildUpon().appendPath(id).appendPath(PATH_PLAN).build();
        }

        public static String getGoalId(Uri uri){
            return Long.toString(ContentUris.parseId(uri));
        }
    }

    public static class Categories implements CategoryColumns {

        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(PATH_CATEGORY).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CATEGORY;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CATEGORY;

        public static Uri buildCategoryUri(String id){
            return CONTENT_URI.buildUpon().appendPath(id).build();
        }

        public static String getCategoryId(Uri uri){
            return Long.toString(ContentUris.parseId(uri));
        }
    }

    public static class TaskNotes implements TaskNoteColumns {

        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(PATH_TASK_NOTE).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TASK_NOTE;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TASK_NOTE;

        public static Uri buildTaskNoteUri(String id){
            return CONTENT_URI.buildUpon().appendPath(id).build();
        }

        public static String getTaskNoteId(Uri uri){
            return Long.toString(ContentUris.parseId(uri));
        }
    }

    public static class Plans implements PlanColumns {

        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(PATH_PLAN).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PLAN;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PLAN;

        public static Uri buildPlanUri(String id){
            return CONTENT_URI.buildUpon().appendPath(id).build();
        }

        public static String getPlanId(Uri uri){
            return Long.toString(ContentUris.parseId(uri));
        }
    }

    public static class Reviews implements ReviewColumns {

        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(PATH_REVIEW).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_REVIEW;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_REVIEW;

        public static Uri buildReviewUri(String id){
            return CONTENT_URI.buildUpon().appendPath(id).build();
        }

        public static String getReviewId(Uri uri){
            return Long.toString(ContentUris.parseId(uri));
        }
    }

    public static class Cycles implements CycleColumns {

        public static final Uri CONTENT_URI=BASE_CONTENT_URI.buildUpon().appendPath(PATH_TASK_CYCLE).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TASK_CYCLE;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TASK_CYCLE;

        public static Uri buildCycleUri(String id){
            return CONTENT_URI.buildUpon().appendPath(id).build();
        }

        public static String getCycleId(Uri uri){
            return Long.toString(ContentUris.parseId(uri));
        }
    }

}
