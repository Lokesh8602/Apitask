package com.example.assetlogin.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable
open class BaseResponse(
    @field:SerializedName("errorMessages")
    val errorMessages: List<Error?>? = null,

    @field:SerializedName("validationMessages")
    val validationMessages: Any? = null,

    @field:SerializedName("success")
    val success: Boolean? = null,

    @field:SerializedName("notificationType")
    val notificationType: Any? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("returnToUrl")
    val returnToUrl: Any? = null
) : Serializable

class Error {
    @field:SerializedName("message")
    val message: String? = null
}