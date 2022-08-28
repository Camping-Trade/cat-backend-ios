package com.example.cat.controller.dto

import com.example.cat.domain.post.PostType

data class PostDto(
    val id: String,
    val title: String,
    val content: String,
    val writer: UserDto,
    val imageUrl: String? = null,
    val location: String? = null,
    val campId: String,
    val type: PostType
)