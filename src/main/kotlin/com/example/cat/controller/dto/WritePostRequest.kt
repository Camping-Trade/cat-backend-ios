package com.example.cat.controller.dto

import com.example.cat.domain.post.PostType

data class WritePostRequest(
    val title: String,
    val content: String,
    val imageUrl: String? = null,
    val location: String,
    val campId: String,
    val writerId: String,
    val postType: PostType
)