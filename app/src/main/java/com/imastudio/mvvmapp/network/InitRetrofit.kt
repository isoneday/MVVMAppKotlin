package com.imastudio.mvpapp.network

import com.google.gson.GsonBuilder
import com.imastudio.mvpapp.helper.Helper.Companion.BASE_URL
import com.imastudio.mvpapp.helper.Helper.Companion.BASE_WISATAURL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object InitRetrofit {

    val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .retryOnConnectionFailure(true)
        .connectTimeout(15, TimeUnit.SECONDS)
        .build()
    val gson = GsonBuilder().setLenient().create()
//untuk url pertama
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun getInstance(): RestApi = retrofit.create(RestApi::class.java)
    //untuk url kedua
    val retrofitwisata = Retrofit.Builder()
        .baseUrl(BASE_WISATAURL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun getInstanceWisata(): RestApi = retrofitwisata.create(RestApi::class.java)


}