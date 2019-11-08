package com.gavkariapp.network

import com.example.infosystask.constant.HttpConstant.GET_DATA
import com.example.infosystask.model.FactResponse
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    /**
     * calling facts api
     */
    @GET(GET_DATA)
    fun callFactsData(): Call<FactResponse>

}
