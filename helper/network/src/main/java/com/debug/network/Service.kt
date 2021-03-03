package com.debug.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://www.themealdb.com/api/json/"
private const val API_VERSION = "v1/1/"

class Service {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL + API_VERSION)
        .client(OkHttpClient.Builder().addInterceptor(logInterceptor()).build())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    fun <API> createService(apiClass: Class<API>): API {
        return retrofit.create(apiClass)
    }

    fun logInterceptor() =
         HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
}