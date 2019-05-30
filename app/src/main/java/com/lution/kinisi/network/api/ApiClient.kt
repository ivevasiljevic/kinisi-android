package com.lution.kinisi.network.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.lution.kinisi.BuildConfig
import com.lution.kinisi.network.interceptors.HeaderInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by ivasil on 5/29/2019
 */

object ApiClient {

    val apiClient by lazy {

        createRetrofitClient()
    }

    private fun createRetrofitClient(): ApiServiceUserManagement {

       return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_ENDPOINT)
            .client(createOkHttpClient())
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(ApiServiceUserManagement::class.java)
    }

    private fun createOkHttpClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor())
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }
}