package com.example.cat.controller.dto


data class SaveShareRecordRequest(
    val shareUserId: String,
    val receiveUserId: String,
    val postId: String,
)