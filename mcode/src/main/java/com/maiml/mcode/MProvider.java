package com.maiml.mcode;

import java.util.HashMap;

/**
 * Created by maimingliang on 2017/2/28.
 */

public abstract class MProvider {

    //TODO this field is used for control the provider on and off
    private boolean mValid = true;
    private HashMap<String,MAction> mActions;
    public MProvider(){
        mActions = new HashMap<>();
        registerActions();
    }
    protected void registerAction(String actionName,MAction action){
        mActions.put(actionName,action);
    }

    public MAction findAction(String actionName){
        return mActions.get(actionName);
    }

    public boolean isValid(){
        return mValid;
    }

    protected abstract void registerActions();
}
