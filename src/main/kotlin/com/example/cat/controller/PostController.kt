package com.example.cat.controller

import com.example.cat.controller.dto.PostDto
import com.example.cat.controller.dto.ViewPostsResponse
import com.example.cat.controller.dto.WritePostRequest
import com.example.cat.controller.result.Response
import com.example.cat.controller.result.SuccessCode
import com.example.cat.service.PostService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Tag(name = "post", description = "게시글 관련 api들")
@RestController
@RequestMapping("api/posts")
class PostController(
    private val postService: PostService,
) {
    @Operation(summary = "게시글 작성 api", description = "게시글 작성 api입니다")
    @PostMapping
    fun write(@RequestBody request: WritePostRequest): PostDto {
        return postService.writePost(request)
    }

    @Operation(summary = "게시글 조회 api", description = "게시글을 조회하는 api입니다")
    @GetMapping
    fun viewPostsByCampId(@RequestParam("campId") campId: String): Response<ViewPostsResponse> {
        val posts = postService.viewPosts(campId)
        return Response<ViewPostsResponse>(
            SuccessCode.POSTS_SUCCESSFULLY_RETURNED,
            ViewPostsResponse(
                posts = posts,
                totalcount = posts.size,
            )
        )
    }
}