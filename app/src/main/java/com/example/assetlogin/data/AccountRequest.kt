package com.example.assetlogin.data

import com.google.gson.annotations.SerializedName

data class AccountRequest(

    @field:SerializedName("password")
    val password: String? = null,

    @field:SerializedName("newPassword")
    val newPassword: String? = null,

    @field:SerializedName("confirmPassword")
    val confirmPassword: String? = null,

    @field:SerializedName("emailId")
    val emailId: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("rememberMe")
    val rememberMe: String? = null,

    @field:SerializedName("isMobileAccess")
    val isMobileAccess: Boolean = true
)
