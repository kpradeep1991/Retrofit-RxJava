package com.enunui.grandma.Interface.core;

import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;
import rx.functions.Action1;

public abstract class ApiFail implements Action1<Throwable> {


    private String TAG = ApiFail.class.getSimpleName();
    @Override
    public void call(Throwable e) {

        if(e instanceof HttpException) {

            HttpException http = (HttpException) e;
            HttpErrorResponse response = new HttpErrorResponse(http.code(), http.response());
            response.setError(http.message());

            //    // Error response Should be read from error body ( reason field )

            try {
                String body = http.response().toString().trim();
                Log.d("ApiFail", body);
                if (body.contains("message")) {
                    Gson gson = new Gson();
                }

                if (body.contains("<html>")) {
                    body = "SOME THING WENT WRONG";
                }
                response.setError(body);
            } catch (Exception e1) {

                e1.printStackTrace();
            }
            if (response.getHttpStatusCode() == 444) {

            } else {
                httpStatus(response);

            }
        }else if (e instanceof IOException)
            {
                noNetworkError();
            }

           else
        {
            unknownError(e);
        }
        Log.d(TAG, "In case response fails - "+Thread.currentThread().getName());

    }

    protected abstract void unknownError(Throwable e);

    protected abstract void noNetworkError();

    protected abstract void httpStatus(HttpErrorResponse response);
}
