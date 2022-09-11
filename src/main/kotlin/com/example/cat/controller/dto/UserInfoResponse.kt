package com.example.cat.controller.dto

data class UserInfoResponse(
    val id: Long,
    val nickname: String,
    val profileImageUrl: String,
    val email: String,
    val kakaoId: String?,
    val thumbnailImageUrl: String?,
)