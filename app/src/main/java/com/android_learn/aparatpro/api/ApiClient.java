package com.android_learn.aparatpro.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;

    private static final String baseUrl = "https://androidsupport.ir/pack/aparat/";
    private ApiClient()
    {

    }

    public  static  Retrofit getRetrofit()
    {
        if(retrofit == null)
        {
            retrofit = new
                    Retrofit
                    .Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }



}
