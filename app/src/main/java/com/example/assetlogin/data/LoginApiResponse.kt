package com.example.assetlogin.data

import com.google.gson.annotations.SerializedName

data class LoginApiResponse(

    @field:SerializedName("data")
    val data: LoginDTO? = null



) : BaseResponse()

