package com.example.assetlogin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assetlogin.data.LoginApiResponse
import com.example.assetlogin.repository.LoginRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel constructor(private val repository:LoginRepository)  : ViewModel() {

    val loginLiveData = MutableLiveData<LoginApiResponse>()
    val errorMessage = MutableLiveData<String>()


    fun getlogin(email: String,password:String){
        val response = repository.login(email,password)
        response?.enqueue(object : Callback<LoginApiResponse> {
            override fun onResponse(
                call: Call<LoginApiResponse>,
                response: Response<LoginApiResponse>
            ){
                if(response.body() != null/* && response.body()?*//*.status==200*/ ) {
                    loginLiveData.postValue(response.body())
                }else{
                    errorMessage.postValue("Unscuccessful")
                }

            }

            override fun onFailure(call: Call<LoginApiResponse>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })


}}