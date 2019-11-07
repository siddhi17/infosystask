package com.example.learn.model


data class ApiResponse<R, E>(var response: R?, var error: E?)