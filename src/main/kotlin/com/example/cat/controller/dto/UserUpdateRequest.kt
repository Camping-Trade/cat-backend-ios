package com.example.cat.controller.dto

data class UserUpdateRequest(
    val id: Long,
    val nickname: String,
    val profileImageUrl: String,
    val email: String,
)