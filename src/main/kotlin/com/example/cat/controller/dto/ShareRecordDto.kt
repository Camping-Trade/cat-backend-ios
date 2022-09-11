package com.example.cat.controller.dto

import com.example.cat.domain.sharing.ShareType

data class ShareRecordDto(
    val userId: String,
    val userNickname: String,
    val type: ShareType,
    val postId: String,
    val product: String,
    val campId: Long,
    val pointToGet: Int,
)