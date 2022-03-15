package com.example.mvpwithvolley.presentationlayer.registration

import com.example.mvpwithvolley.datalayer.User

class RegistrationMVP {

    interface RegistrationView {
        fun setResult(message: String)
        fun onLoad(isLoading: Boolean)
    }

    interface RegistrationPresenter {
        fun registerUser(user: User): String
    }
}