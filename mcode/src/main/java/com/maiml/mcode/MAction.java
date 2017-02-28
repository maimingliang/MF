package com.maiml.mcode;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by maimingliang on 2017/2/28.
 */

public abstract class MAction {

    public abstract void invoke(Context context, HashMap<String,String> requestData);

}
