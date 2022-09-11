package com.example.cat.controller.dto

import com.example.cat.domain.sharing.ShareType

data class SaveShareRecordRequest(
    val userId: String,
    val type: ShareType,
    val postId: String,
    val campId: Long,
)