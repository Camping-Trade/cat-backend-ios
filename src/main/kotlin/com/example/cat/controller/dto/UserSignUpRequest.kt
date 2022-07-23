package com.example.cat.controller.dto

data class UserSignUpRequest(
    val email: String,
    val nickname: String,
    val profileImageUrl: String,
)