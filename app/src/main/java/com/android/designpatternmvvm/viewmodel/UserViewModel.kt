package com.android.designpatternmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.designpatternmvvm.model.getAllUserItem
import com.android.designpatternmvvm.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel

class UserViewModel (
    application: Application
    ): AndroidViewModel(application) {

    var liveDataList = MutableLiveData<List<getAllUserItem>?>()

    fun getLDatUsr(): MutableLiveData<List<getAllUserItem>?> {
        return  liveDataList
    }

    fun getDataUser(){
        ApiClient.instance.getAllUser()
            .enqueue(object : Callback<List<getAllUserItem>> {
                override fun onResponse(
                    call: Call<List<getAllUserItem>>,
                    response: Response<List<getAllUserItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataList.postValue(response.body())
                    }else{
                        liveDataList.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<getAllUserItem>>, t: Throwable) {
                    liveDataList.postValue(null)
                    //Toast.makeText(getApplication(), t.message, Toast.LENGTH_SHORT).show()
                }

            })
    }
}