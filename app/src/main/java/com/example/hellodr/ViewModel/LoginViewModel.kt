package com.example.hellodr.ViewModel

import android.app.Application
import androidx.databinding.ObservableField

class LoginViewModel(application: Application) {

    val userName = ObservableField<String>()
    val password = ObservableField<String>()


    private fun buildSignInRequestData()


}