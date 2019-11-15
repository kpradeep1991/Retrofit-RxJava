package com.enunui.grandma.Interface;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Api {

    private Api() {
    }

  private static Retrofit getRetrofit(){

      HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
      interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


      OkHttpClient client= new OkHttpClient.Builder()

              .connectTimeout(60, TimeUnit.SECONDS)
              .readTimeout(30,TimeUnit.SECONDS)

              .addInterceptor(interceptor).build();
      client.connectTimeoutMillis();

      Retrofit Objretrofit =new Retrofit.Builder()

              .baseUrl("https://www.haplot.com/")
              .addConverterFactory(ScalarsConverterFactory.create())
              .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
              .client(client)
              .build();





        return Objretrofit;
  }

  public static APIInterface  ApiInterface()
  {
        return getRetrofit().create(APIInterface.class);
    }
}
