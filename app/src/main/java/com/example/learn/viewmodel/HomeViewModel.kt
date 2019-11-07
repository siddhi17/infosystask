package com.example.learn.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.learn.model.ApiResponse
import com.example.learn.model.FactResponse
import com.example.learn.repository.HomeRepository


class HomeViewModel : ViewModel() {

    private val homeRepository = HomeRepository()

    /**
     * access facts data
     */
    fun getfactsData(): LiveData<ApiResponse<FactResponse, String>> {
        return homeRepository.callFactsData()
    }

}
