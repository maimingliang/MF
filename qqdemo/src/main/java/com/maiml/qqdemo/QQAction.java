package com.maiml.qqdemo;

import android.content.Context;
import android.content.Intent;

import com.maiml.mcode.MAction;

import java.util.HashMap;

/**
 * Created by maimingliang on 2017/2/28.
 */

public class QQAction extends MAction {
    @Override
    public void invoke(Context context, HashMap<String, String> requestData) {
        context.startActivity(new Intent(context,QQActivity.class));
    }
}
