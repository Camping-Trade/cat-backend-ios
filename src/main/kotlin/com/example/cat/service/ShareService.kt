package com.example.cat.service

import com.example.cat.controller.dto.ShareRecordDto
import com.example.cat.domain.User
import com.example.cat.domain.sharing.Post
import com.example.cat.domain.sharing.PostStatus
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
        val shareUserId: String,
        val receiveUserId: String,
        val postId: String,
    )
    fun shareSuccess(request: Request) {
        val(shareUserId, receiveUserId, postId) = request
        val shareUser = userRepository.findById(shareUserId.toLong()).orElseThrow {
            throw IllegalArgumentException("user not found with id:$shareUserId")
        }
        val receiveUser = userRepository.findById(receiveUserId.toLong()).orElseThrow{
            throw IllegalArgumentException("user not found with id:$receiveUserId")
        }
        val post = postRepository.findById(postId.toLong()).orElseThrow {
            throw IllegalArgumentException("post not found with id:$postId")
        }
        saveShareRecordForTwoUsers(shareUser,receiveUser,post)
        updatePostToBeDone(post)
    }

    private fun saveShareRecordForTwoUsers(shareUser: User, receiveUser: User, post: Post) {
        val pointToGet = 100
        shareRepository.save(
            ShareRecord(
                user = shareUser,
                type = ShareType.SHARE,
                post = post,
                campId = post.campId.toLong(),
                pointToGet = pointToGet,
            )
        )
        shareRepository.save(
            ShareRecord(
                user = receiveUser,
                type = ShareType.RECEIVE,
                post = post,
                campId = post.campId.toLong(),
                pointToGet = pointToGet,
            )
        )
        shareUser.updatePoint(pointToGet)
        receiveUser.updatePoint(pointToGet)
    }
    private fun updatePostToBeDone(post: Post) {
        post.status = PostStatus.DONE
        postRepository.save(post)
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