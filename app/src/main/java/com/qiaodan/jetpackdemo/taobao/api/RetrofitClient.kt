package com.qiaodan.jetpackdemo.taobao.api

import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * author: created by yuqiaodan on 2022/12/28 17:56
 * description:
 */
object RetrofitClient {


    val TAG = "RetrofitClient"

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            LoggingInterceptor.Builder()
                .setLevel(Level.BASIC)
                .log(Platform.INFO)
                .request(TAG)
                .response(TAG)
                .build()
        )
        .callTimeout(30, TimeUnit.SECONDS)
        .build()


    val retrofit = Retrofit.Builder()
        .baseUrl(ApiService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val apiService=retrofit.create(ApiService::class.java)





}