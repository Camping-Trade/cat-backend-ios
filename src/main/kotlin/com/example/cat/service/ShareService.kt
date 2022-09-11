package com.example.cat.service

import com.example.cat.controller.dto.ShareRecordDto
import com.example.cat.domain.sharing.ShareRecord
import com.example.cat.domain.sharing.ShareType
import com.example.cat.repository.PostRepository
import com.example.cat.repository.ShareRepository
import com.example.cat.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class ShareService(
    private val shareRepository: ShareRepository,
    private val userRepository: UserRepository,
    private val postRepository: PostRepository,
) {
    data class Request(
        val userId: String,
        val type: ShareType,
        val postId: String,
        val campId: Long,
    )
    fun saveRecord(request: Request): ShareRecordDto {
        val(userId, type, postId, campId) = request
        val user = userRepository.findById(userId.toLong()).orElseThrow {
            throw IllegalArgumentException("user not found with id:$userId")
        }
        val post = postRepository.findById(postId.toLong()).orElseThrow {
            throw IllegalArgumentException("post not found with id:$postId")
        }
        return shareRepository.save(
            ShareRecord(
                user = user,
                type = type,
                post = post,
                campId = campId,
                pointToGet = 100,
            )
        ).let { toDto(it) }

    }

    private fun toDto(entity: ShareRecord): ShareRecordDto =with(entity){
        return ShareRecordDto(
            userId = user.id!!.toString(),
            userNickname = user.nickname,
            postId = post.id!!.toString(),
            product = post.product,
            type = type,
            campId = campId,
            pointToGet = pointToGet,

        )
    }
}