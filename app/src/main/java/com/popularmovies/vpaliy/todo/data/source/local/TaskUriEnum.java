package com.popularmovies.vpaliy.todo.data.source.local;

import com.popularmovies.vpaliy.todo.domain.model.Task;

import static com.popularmovies.vpaliy.todo.data.source.local.TaskContract.Tasks;
import static com.popularmovies.vpaliy.todo.data.source.local.TaskContract.Reviews;
import static com.popularmovies.vpaliy.todo.data.source.local.TaskContract.Categories;
import static com.popularmovies.vpaliy.todo.data.source.local.TaskContract.Goals;
import static com.popularmovies.vpaliy.todo.data.source.local.TaskContract.Plans;
import static com.popularmovies.vpaliy.todo.data.source.local.TaskContract.TodoItems;
import static com.popularmovies.vpaliy.todo.data.source.local.TaskContract.Cycles;
import static com.popularmovies.vpaliy.todo.data.source.local.TaskSQLHelper.Tables;

enum TaskUriEnum {

    TASKS(100,Tables.TASKS,TaskContract.PATH_TASK,Tasks.CONTENT_DIR_TYPE),
    TASK_ID(101,null,TaskContract.PATH_TASK,Tasks.CONTENT_ITEM_TYPE),
    TASK_CATEGORY_ID(103,null,TaskContract.PATH_TASK+"/*"+TaskContract.PATH_CATEGORY,Tasks.CONTENT_ITEM_TYPE),
    TASK_CYCLE_ID(104,null,TaskContract.PATH_TASK+"/*"+TaskContract.PATH_TASK_CYCLE,Tasks.CONTENT_ITEM_TYPE),
    TODO_ITEM(200,Tables.TODO_ITEMS,TaskContract.PATH_TODO_ITEM,Tasks.CONTENT_DIR_TYPE),
    TODO_ITEM_ID(201,null,TaskContract.PATH_TODO_ITEM+"/#", Tasks.CONTENT_ITEM_TYPE),
    GOALS(300,Tables.GOALS,TaskContract.PATH_GOAL,Tasks.CONTENT_DIR_TYPE),
    GOAL_ID(301,null,TaskContract.PATH_GOAL+"/#",Tasks.CONTENT_ITEM_TYPE),
    CATEGORY(400,Tables.CATEGORIES,TaskContract.PATH_CATEGORY,Tasks.CONTENT_DIR_TYPE),
    CATEGORY_TASKS_ID(401,null,TaskContract.PATH_CATEGORY+"/*"+TaskContract.PATH_TASK,Tasks.CONTENT_ITEM_TYPE);

    public int code;
    public String table;
    public String path;
    public String contentType;

    TaskUriEnum(int code, String table, String path, String contentType){
        this.code=code;
        this.table=table;
        this.path=path;
        this.contentType=contentType;
    }
}
