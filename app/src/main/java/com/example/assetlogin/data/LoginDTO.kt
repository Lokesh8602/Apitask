package com.example.assetlogin.data

import com.google.gson.annotations.SerializedName

class LoginDTO(

    @field:SerializedName("password")
    val password: String? = null,

    @field:SerializedName("newPassword")
    val newPassword: String? = null,

    @field:SerializedName("roleName")
    val roleName: String? = null,

    @field:SerializedName("roleTypeId")
    val roleTypeId: Int? = null,

    @field:SerializedName("confirmPassword")
    val confirmPassword: String? = null,

    @field:SerializedName("emailId")
    val emailId: String? = null,

    @field:SerializedName("rememberMe")
    val rememberMe: Boolean? = null,

    @field:SerializedName("firstName")
    val firstName: String? = null,

    @field:SerializedName("lastName")
    val lastName: String? = null,

    @field:SerializedName("token")
    val token: String? = null,

    @field:SerializedName("id")
    val id: Int? = null

)