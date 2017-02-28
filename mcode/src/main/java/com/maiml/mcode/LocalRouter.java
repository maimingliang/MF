package com.maiml.mcode;

import android.support.annotation.NonNull;

import java.util.HashMap;

/**
 * Created by maimingliang on 2017/2/28.
 */

public class LocalRouter {

    private static LocalRouter sInstance = null;
    private MApplication mApplication;

    private HashMap<String, MProvider> mProviders = null;


    public static synchronized LocalRouter getInstance(@NonNull MApplication context) {
        if (sInstance == null) {
            sInstance = new LocalRouter(context);
        }
        return sInstance;
    }

    private LocalRouter(MApplication context) {
         mApplication = context;
         mProviders = new HashMap<>();

    }


    public void registerProvider(String providerName, MProvider provider) {
        mProviders.put(providerName, provider);
    }


    public MProvider getProvider(String providerName){
        return mProviders.get(providerName);
    }
}
