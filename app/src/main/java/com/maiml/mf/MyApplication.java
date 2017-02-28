package com.maiml.mf;

import com.maiml.mcode.LocalRouter;
import com.maiml.mcode.MApplication;
import com.maiml.qqdemo.QQModuleLogic;

/**
 * Created by maimingliang on 2017/2/28.
 */

public class MyApplication extends MApplication {


    @Override
    protected void initializeLogic() {
        registerModuleLogic("qq",new QQModuleLogic());
    }
}
