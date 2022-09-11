package com.example.cat.controller.dto

import com.example.cat.domain.sharing.PostType
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "게시글 작성 요청DTO")
data class WritePostRequest(
    val title: String,
    val content: String,
    val imageUrl: String? = null,
    val location: String,
    val campId: String,
    val writerId: String,
    val postType: PostType,
    val product: String,
)