package com.example.cat.service

import com.example.cat.controller.dto.PostDto
import com.example.cat.controller.dto.UserDto
import com.example.cat.controller.dto.WritePostRequest
import com.example.cat.domain.sharing.Post
import com.example.cat.exception.UserNotFoundException
import com.example.cat.repository.PostRepository
import com.example.cat.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository,
    private val userRepository: UserRepository,
) {
    fun writePost(request: WritePostRequest): PostDto {
        val (title, content, imageUrl, location, campId, id, type, product ) = request
        val writer = userRepository.findById(id.toLong())
            .orElseThrow { throw UserNotFoundException.byUserId(id) }
        val postToSave = Post(
            title = title,
            content = content,
            imageUrl = imageUrl,
            location = location,
            campId = campId,
            writer = writer,
            type = type,
            product = product,
        )
        val savedPost = postRepository.save(postToSave)
        return fromEntity(savedPost)
    }

    fun viewPosts(campId: String): List<PostDto> {
        return postRepository.findAllByCampIdOrderByCreatedAtDesc(campId)
            .map {post -> fromEntity(post)}
    }

    private fun fromEntity(entity: Post): PostDto {
        return PostDto(
            id = entity.id.toString(),
            title = entity.title,
            content = entity.content,
            writer = UserDto.fromEntity(entity.writer),
            imageUrl = entity.imageUrl,
            location = entity.location,
            campId = entity.campId,
            type = entity.type,
            product = entity.product,
            )
    }
}