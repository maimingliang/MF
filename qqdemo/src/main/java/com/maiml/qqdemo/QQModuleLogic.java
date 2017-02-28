package com.maiml.qqdemo;

import com.maiml.mcode.BaseModuleLogic;
import com.maiml.mcode.LocalRouter;

/**
 * Created by maimingliang on 2017/2/28.
 */

public class QQModuleLogic extends BaseModuleLogic {



    @Override
    public void onCreate() {

        LocalRouter.getInstance(mApplication).registerProvider("qqdemo",new QQProvider());

    }
}
