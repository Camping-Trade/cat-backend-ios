package com.example.cat.controller

import com.example.cat.controller.dto.UserInfoResponse
import com.example.cat.controller.dto.UserSignUpRequest
import com.example.cat.domain.User
import com.example.cat.repository.UserRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/user")
@RestController
class UserController(val userRepository: UserRepository){

    @PostMapping
    fun signUp(@RequestBody request:UserSignUpRequest): UserInfoResponse {
        return toUserInfoResponse(userRepository.save(toUser(request)))
    }

    internal fun toUserInfoResponse(entity: User): UserInfoResponse{
        return UserInfoResponse(
            nickname = entity.nickname,
            profileImageUrl = entity.profileImageUrl,
            email = entity.email,
        )
    }
    internal fun toUser(request: UserSignUpRequest): User{
        return User(
            nickname = request.nickname,
            profileImageUrl = request.profileImageUrl,
            email = request.email,
        )
    }
}