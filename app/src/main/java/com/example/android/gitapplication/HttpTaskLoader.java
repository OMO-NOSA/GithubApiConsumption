package com.example.android.gitapplication;

import android.content.AsyncTaskLoader;
import android.content.Context;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by NOSSY on 9/7/2017.
 */


public class HttpTaskLoader extends AsyncTaskLoader<String> {

    private static final String GITHUB_URL =
            "https://api.github.com/search/users?q=location:Lagos+language:Java";
    public HttpTaskLoader(Context context){

        super(context);
    }
    @Override
    public String loadInBackground(){

        try{

            OkHttpClient client=new OkHttpClient();
            Request request=new Request.Builder().url(GITHUB_URL).build();
            Response response=client.newCall(request).execute();
            String result=response.body().string();
            return result;

        }catch (Exception e){
            return null;


        }
    }



}

