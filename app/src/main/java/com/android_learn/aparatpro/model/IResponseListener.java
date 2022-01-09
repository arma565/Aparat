package com.android_learn.aparatpro.model;

public interface IResponseListener<T> {

    void onSuccess(T responseMessage);
    void onFailure(String errorResponseMessage);



}
