package com.maiml.qqdemo;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by maimingliang on 2017/3/5.
 */

public interface QQService {

    @GET("random/data/{category}/{num}")
    Observable<BaseHttpResult<List<GankIoBean>>> findList(@Path("category") String category, @Path("num") int num);

}
