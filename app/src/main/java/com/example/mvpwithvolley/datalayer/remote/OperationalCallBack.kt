package com.example.mvpwithvolley.datalayer.remote

interface OperationalCallBack {
    fun onSuccess(message: String)
    fun onFailure(message: String)
}