package com.example.infosystask.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.infosystask.model.ApiResponse
import com.example.infosystask.model.FactResponse
import com.example.infosystask.repository.HomeRepository


class HomeViewModel : ViewModel() {

    private val homeRepository = HomeRepository()

    /**
     * access facts data
     */
    fun getfactsData(): LiveData<ApiResponse<FactResponse, String>> {
        return homeRepository.callFactsData()
    }

}
