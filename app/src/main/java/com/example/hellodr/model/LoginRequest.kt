package com.example.hellodr.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginRequest(

    @SerializedName("email")
    @Expose
    val email: String?,
    @SerializedName("password")
    @Expose
    val password: String?
)