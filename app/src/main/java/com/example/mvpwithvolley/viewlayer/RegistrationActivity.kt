package com.example.mvpwithvolley.viewlayer

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvpwithvolley.databinding.ActivityRegistrationBinding
import com.example.mvpwithvolley.datalayer.User
import com.example.mvpwithvolley.datalayer.remote.VolleyHandler
import com.example.mvpwithvolley.presentationlayer.registration.RegistrationMVP
import com.example.mvpwithvolley.presentationlayer.registration.RegistrationPresenter

class RegistrationActivity : AppCompatActivity(), RegistrationMVP.RegistrationView {
    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var presenter: RegistrationPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val volleyHandler = VolleyHandler(this)
        presenter = RegistrationPresenter(volleyHandler, this)
        setUpEvents()
    }

    override fun onLoad(isLoading: Boolean) {
        binding.apply {
            if (isLoading) {
                progress.visibility = View.VISIBLE
            } else {
                progress.visibility = View.GONE
            }
        }
    }

    override fun setResult(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        binding.apply {
            edtName.text!!.clear()
            edtMobile.text!!.clear()
            edtEmail.text!!.clear()
            edtPassword.text!!.clear()
        }
    }

    private fun setUpEvents() {
        binding.apply {
            btnRegister.setOnClickListener {
                presenter.registerUser(
                    User(
                        edtName.text.toString(),
                        edtMobile.text.toString(),
                        edtEmail.text.toString(),
                        edtPassword.text.toString()
                    )
                )
            }
        }
    }
}