package com.example.cat.controller.dto

data class ViewPostsResponse(
    val totalcount: Int,
    val posts: List<PostDto>,
)
