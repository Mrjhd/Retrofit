package com.example.day03xrecycleview.http;

/**
 * Created by 因为有个你i on 2018/5/11.
 */

public interface OkLoadListener {
    void okLoadSuccess(String json);
    void okLoadError(String error);
}
