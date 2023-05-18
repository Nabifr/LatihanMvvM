package com.android.designpatternmvvm.network

import com.android.designpatternmvvm.model.getAllUser
import com.android.designpatternmvvm.model.getAllUserItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("user")
    fun getAllUser() : Call<List<getAllUserItem>>
}