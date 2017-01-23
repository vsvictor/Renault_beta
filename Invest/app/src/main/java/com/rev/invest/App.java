package com.rev.invest;

import android.app.Application;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by victor on 19.01.17.
 */

public class App extends Application {
    private static final String TAG = App.class.getSimpleName();
    private Retrofit retro;
    private Gson gson;
    private static Datas datas;
    private static OkHttpClient client;
    @Override
    public void onCreate(){
        super.onCreate();
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();
                Log.i(TAG, original.toString());
                Request.Builder requestBuilder = new Request.Builder().url("https://google.com.ua");
                Request request = requestBuilder.build();
                Log.i(TAG,request.toString());
                return chain.proceed(request);
            }
        });

        client = httpClient.build();

        gson = new GsonBuilder()
                .create();
        retro = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/maps/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        datas = retro.create(Datas.class);
    }
    public static Datas getApi() {
        return datas;
    }
}
