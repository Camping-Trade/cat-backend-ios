package com.example.cat.controller.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "회원정보 수정 요청DTO")
data class UserUpdateRequest(
    val id: Long,
    val nickname: String,
    val profileImageUrl: String,
    val email: String,
)