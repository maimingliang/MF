package com.maiml.mcode;

import android.app.Application;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by maimingliang on 2017/2/28.
 */

public abstract class MApplication extends Application {


    private HashMap<String, BaseModuleLogic> mLogicClassMap;

    private static MApplication sInstance;
    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
        LocalRouter.getInstance(this);
        mLogicClassMap = new HashMap<>();
        initializeLogic();

     }


    protected abstract void initializeLogic();


    protected void registerModuleLogic(String name,@NonNull BaseModuleLogic logicClass){

        mLogicClassMap.put(name,logicClass);

    }

    public static MApplication getMApplication(){
        return sInstance;
    }
}
