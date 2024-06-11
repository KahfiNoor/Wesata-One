package com.example.wesataone.model.data.remote.response

import com.google.gson.annotations.SerializedName

data class SignInResponse(
    @field:SerializedName("loginResult")
    val signInResult: SignInResult,

    @field:SerializedName("error")
    val error: Boolean? = null,

    @field:SerializedName("message")
    val message: String? = null
)

data class SignInResult(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("userId")
    val userId: String,

    @field:SerializedName("token")
    val token: String
)