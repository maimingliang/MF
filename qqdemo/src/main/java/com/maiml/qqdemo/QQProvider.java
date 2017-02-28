package com.maiml.qqdemo;

import com.maiml.mcode.MProvider;

/**
 * Created by maimingliang on 2017/2/28.
 */

public class QQProvider extends MProvider {


    @Override
    protected void registerActions() {

        registerAction("qq",new QQAction());
    }
}
