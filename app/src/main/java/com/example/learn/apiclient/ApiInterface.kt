package com.gavkariapp.network

import com.example.learn.constant.HttpConstant.GET_DATA
import com.example.learn.model.FactResponse
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    /**
     * calling facts api
     */
    @GET(GET_DATA)
    fun callFactsData(): Call<FactResponse>

}
