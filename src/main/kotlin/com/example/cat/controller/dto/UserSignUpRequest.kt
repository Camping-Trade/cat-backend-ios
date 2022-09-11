package com.example.cat.controller.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "회원가입 요청DTO")
data class UserSignUpRequest(
    val email: String,
    val nickname: String,
    val profileImageUrl: String,
    val kakaoId: String? = null,
    val thumbnailImageUrl: String? = null,
)