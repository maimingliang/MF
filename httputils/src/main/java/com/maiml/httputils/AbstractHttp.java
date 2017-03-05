package com.maiml.httputils;

/**
 * Created by maimingliang on 2017/3/5.
 */

public abstract class AbstractHttp<T> {



    public abstract void handleError();

    public static  AbstractHttp getInstance(){

        return null;
    }

//    public  abstract  Object getHttpInstance();

    public abstract T getApiService(Class<T> t);


}
