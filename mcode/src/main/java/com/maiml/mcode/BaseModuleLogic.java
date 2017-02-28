package com.maiml.mcode;

/**
 * Created by maimingliang on 2017/2/28.
 */

public abstract class BaseModuleLogic {

    protected MApplication mApplication;

    public void setmApplication(MApplication mApplication) {
        this.mApplication = mApplication;
    }

    public BaseModuleLogic(){
        onCreate();
    }

    public abstract void onCreate() ;


}
