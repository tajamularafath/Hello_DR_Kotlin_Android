package com.example.hellodr.ViewModel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.hellodr.Webservice.HelloDrClientBuilder.Companion.API_BASE_URl
import com.example.hellodr.model.LoginRequest
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginViewModel(application: Application): ViewModel() {

    val userName = ObservableField<String>()
    val password = ObservableField<String>()


    private fun buildSignInRequestData(): LoginRequest {
        return LoginRequest(
            email = userName.get(),
            password = password.get()
        )

    }

    val API_BASE_URl = "http://localhost:8080"
    val dBuilder = Retrofit.Builder()
        .baseUrl(API_BASE_URl)
        .addConverterFactory(
            GsonConverterFactory
                .create(GsonBuilder().serializeNulls().create())
        )


}