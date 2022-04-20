package com.example.assetlogin.api


import com.example.assetlogin.data.LoginApiResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface RetrofitService {

    @FormUrlEncoded
    @POST("Account/Login")
    fun getLogin(
     @Field("email") email: String,
     @Field("password") password:String
    ): Call<LoginApiResponse>


    companion object {
        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("http://eyassetmgmtapi.aspnetdevelopment.in/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}