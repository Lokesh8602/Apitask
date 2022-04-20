package com.example.assetlogin.repository

import android.content.Context
import com.example.assetlogin.api.RetrofitService
import retrofit2.Call

class LoginRepository(private val retrofitService: RetrofitService?) {

    fun login(email: String, password: String) = retrofitService?.getLogin(email, password)
}










