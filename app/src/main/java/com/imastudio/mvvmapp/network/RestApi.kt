package com.imastudio.mvpapp.network

import com.imastudio.mvpapp.model.modelauth.ResponseAuth
import com.imastudio.mvpapp.model.modelwisata.ResponseWisata
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface RestApi {

    @FormUrlEncoded
    @POST("registeruser.php")
    fun registerUser(
        @Field("vsnama") vsnama: String,
        @Field("vsusia") vsusia: String,
        @Field("vsalamat") vsalamat: String,
        @Field("vsnotelp") vsnotelp: String,
        @Field("vsjenkel") vsjenkel: String?,
        @Field("vsusername") vsusername: String,
        @Field("vslevel") vslevel: String,
        @Field("vspassword") vspassword: String
    ): Call<ResponseAuth>

    @FormUrlEncoded
    @POST("loginuser.php")
    fun loginuser(
        @Field("edtusername") vsusername: String,
        @Field("vslevel") vslevel: String?,
        @Field("edtpassword") vspassword: String
    ): Call<ResponseAuth>

    @GET("?action=findAll")
    fun  getWisata() : Call<ResponseWisata>
}