package com.example.infosystask.model


data class ApiResponse<R, E>(var response: R?, var error: E?)