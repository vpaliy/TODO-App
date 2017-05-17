package com.popularmovies.vpaliy.todo.data.source.local;

import android.content.UriMatcher;
import android.net.Uri;
import android.util.SparseArray;

public class TaskUriMatcher {

    private UriMatcher uriMatcher;
    private SparseArray<TaskUriEnum> codeMap;

    public TaskUriMatcher(){
        buildUriMatcher();
        buildUriMap();
    }

    private void buildUriMatcher(){
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        TaskUriEnum[] movieUriEnum=TaskUriEnum.values();
        for(TaskUriEnum uriEnum:movieUriEnum){
            uriMatcher.addURI(TaskContract.CONTENT_AUTHORITY,uriEnum.path,uriEnum.code);
        }
    }

    private void buildUriMap(){
        codeMap=new SparseArray<>();
        TaskUriEnum[] movieUriEnum=TaskUriEnum.values();
        for(TaskUriEnum uriEnum:movieUriEnum){
            codeMap.put(uriEnum.code,uriEnum);
        }
    }

    public TaskUriEnum match(Uri uri){
        final int code=uriMatcher.match(uri);
        if(codeMap.get(code)==null){
            throw new UnsupportedOperationException("Unknown uri with code " + code);
        }
        return codeMap.get(code);
    }

    public String getType(Uri uri){
        final int code=uriMatcher.match(uri);
        if(codeMap.get(code)==null){
            throw new UnsupportedOperationException("Unknown uri with code " + code);
        }
        return codeMap.get(code).contentType;
    }


}
