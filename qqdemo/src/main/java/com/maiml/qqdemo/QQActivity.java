package com.maiml.qqdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.maiml.httputils.AbstractHttp;
import com.maiml.httputils.OKHttp;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class QQActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qq);


        AbstractHttp<QQService> okhttp = new OKHttp();


        QQService apiService = okhttp.getApiService(QQService.class);


        Observable<BaseHttpResult<List<GankIoBean>>> iOS = apiService.findList("iOS", 1);

        iOS.subscribeOn(Schedulers.io())  /*http请求线程*/
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseHttpResult<List<GankIoBean>>>() {
                    @Override
                    public void onCompleted() {
                        Log.e("tag","onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("tag","onError = " + e.getMessage());
                    }

                    @Override
                    public void onNext(BaseHttpResult<List<GankIoBean>> listBaseHttpResult) {
                        Log.e("tag","onNext");

                        List<GankIoBean> results = listBaseHttpResult.getResults();

                        Log.e("tag",results.toString());
                    }
                });

//        apiService.getApiName("hhhh");

        Log.e("tag",apiService.toString());

    }
}
