package com.example.infosystask.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.infosystask.constant.HttpConstant
import com.example.infosystask.model.ApiResponse
import com.example.infosystask.model.FactResponse
import com.gavkariapp.network.ApiClient
import com.gavkariapp.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeRepository {

    /**
     * facts data api ClickableRow
     */
    fun callFactsData(): LiveData<ApiResponse<FactResponse, String>> {

        val responseData: MutableLiveData<ApiResponse<FactResponse, String>> = MutableLiveData()
        ApiClient.get().create(ApiInterface::class.java)
                .callFactsData()
                .enqueue(object : Callback<FactResponse> {
                    override fun onResponse(call: Call<FactResponse>?, response: Response<FactResponse>?) {
                        if (response!!.code() == HttpConstant.SUCCESS) {
                            responseData.postValue(ApiResponse(response!!.body(), null))
                        }
                    }

                    override fun onFailure(call: Call<FactResponse>?, t: Throwable?) {

                        //return error response to view model
                        responseData.postValue(ApiResponse(null, t!!.message))
                    }
                })

        return responseData
    }

    
}


