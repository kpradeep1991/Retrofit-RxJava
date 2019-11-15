package com.enunui.grandma.Interface.core;

import android.util.Log;

import rx.functions.Action1;

public abstract class ApiSuccess<T> implements Action1<T> {


    private String TAG = ApiSuccess.class.getSimpleName();

    public void success()

    {
        Log.d(TAG, "Successs- " + Thread.currentThread().getName());


    }

}
