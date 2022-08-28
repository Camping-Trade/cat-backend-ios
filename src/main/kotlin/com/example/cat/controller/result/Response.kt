package com.example.cat.controller.result

data class Response<T>(
    val successCode: SuccessCode,
    val data: T
)