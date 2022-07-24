package com.example.cat.controller

import com.example.cat.controller.dto.UserInfoResponse
import com.example.cat.controller.dto.UserSignUpRequest
import com.example.cat.domain.User
import com.example.cat.repository.UserRepository
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "user", description = "회원관리 관련 api들")
@RestController
@RequestMapping("/api/user")
class UserController(val userRepository: UserRepository){

    @Operation(summary = "회원가입 요청 api", description = "회원가입 요청 api입니다")
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