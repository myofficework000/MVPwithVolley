package com.example.mvpwithvolley.presentationlayer.registration

import com.example.mvpwithvolley.datalayer.User
import com.example.mvpwithvolley.datalayer.remote.OperationalCallBack
import com.example.mvpwithvolley.datalayer.remote.VolleyHandler

class RegistrationPresenter(
    private val volleyHandler: VolleyHandler,
    private val registrationView: RegistrationMVP.RegistrationView
) : RegistrationMVP.RegistrationPresenter {

    override fun registerUser(user: User): String {
        registrationView.onLoad(true)
        val message = volleyHandler.userRegistration(user, object : OperationalCallBack {
            override fun onSuccess(message: String) {
                registrationView.onLoad(false)
                registrationView.setResult(message)
            }

            override fun onFailure(message: String) {
                registrationView.onLoad(false)
                registrationView.setResult(message)
            }
        })
        return message ?: DEFAULT_MESSAGE
    }

    companion object {
        const val DEFAULT_MESSAGE = "default message"
    }
}