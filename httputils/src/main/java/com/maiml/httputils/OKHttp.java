package com.maiml.httputils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by maimingliang on 2017/3/5.
 */

public class OKHttp extends AbstractHttp {



    private  Retrofit mRetrofit =  null;



    @Override
    public void handleError() {

    }

    @Override
    public Object getApiService(Class s) {
        return getHttpInstance().create(s);
    }


    public synchronized Retrofit getHttpInstance() {


        if(mRetrofit == null){
            mRetrofit = provideRetrofit(provideOkHttpClient(providesIntercepter()));
        }
        return mRetrofit;
    }



    Interceptor providesIntercepter(){
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                //更改请求头
//                if (!NetworkUtil.isNetWorkActive(mContext)){
//                    //如果没有网络，那么就强制使用缓存数据
//                    request = request.newBuilder()
//                            .cacheControl(CacheControl.FORCE_CACHE)
//                            .build();
//                }
                //获得返回头，如果有网络，就缓存一分钟,没有网络缓存四周
                Response originalResponse = chain.proceed(request);

//
//                ResponseBody body = originalResponse.body();
//                if(body != null){
//
////                    LogUtil.e("resp ","-----> contentLength =" + body.contentLength());
//                    LogUtil.e("resp ","-----> contentType =" + body.contentType().toString());
//
//                    Reader in = body.charStream();
////                    LogUtil.e("reader ","-----> read res = " + reader.read());
//
//                    int s;
//                    String sb = "";
//                    while((s=in.read())!=-1)
//                    {
//                        sb+=(char)s;
//                    }
//                    in.close();
//
//                    LogUtil.e("tag", "-----> sb res " + sb);
//
//                }



                //更改响应头
                if (false){
                    String cacheControl = request.cacheControl().toString();
                    return originalResponse.newBuilder()
                            .header("Cache-Control", cacheControl)
                            .removeHeader("Pragma")
                            .build();
                }else {
                    return originalResponse.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=2419200")
                            .removeHeader("Pragma")
                            .build();
                }
            }
        };
    }

    public  OkHttpClient provideOkHttpClient(Interceptor interceptor) {

        OkHttpClient okhttpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true) //设置出现错误进行重新连接。

                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        return chain.proceed(chain.request()
                                .newBuilder()
                                .addHeader("Content-Type", "application/json;charset=UTF-8")
                                .build());
                    }
                })   //拦截器
//                .addInterceptor(interceptor)
//                .addNetworkInterceptor(interceptor)
//                .cache(providesCache())
                .build();



        return okhttpClient;
    }

    public Retrofit provideRetrofit(OkHttpClient okhttpClient) {

        Gson gson = new GsonBuilder().serializeNulls().create();


        Retrofit retrofit = new Retrofit.Builder()
                .client(okhttpClient)
                .baseUrl("http://gank.io/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }
}
