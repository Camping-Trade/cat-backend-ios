package com.example.cat.controller

import com.example.cat.controller.dto.UserInfoResponse
import com.example.cat.controller.dto.UserSignUpRequest
import com.example.cat.controller.dto.UserUpdateRequest
import com.example.cat.domain.User
import com.example.cat.repository.UserRepository
import com.example.cat.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@Tag(name = "user", description = "회원관리 관련 api들")
@RestController
@RequestMapping("/api/user")
class UserController(
   private val userRepository: UserRepository,
   private val userService: UserService,

    ) {

    @Operation(summary = "회원가입 요청 api", description = "회원가입 요청 api입니다")
    @PostMapping
    fun signUp(@RequestBody request:UserSignUpRequest): UserInfoResponse {
        return toUserInfoResponse(userService.signUp(toUser(request)))
    }
    @Operation(summary = "회원 정보 수정 api", description = "회원 정보 수정을 요청하는 api입니다")
    @PutMapping
    fun updateUserInfo(@RequestBody request: UserUpdateRequest): UserInfoResponse{
        return toUserInfoResponse(userService.updateUserInfo(UpdateRequesttoUser(request)))
    }
    @Operation(summary = "회원 삭제", description = "회원 정보를 삭제하는 api입니다")
    @DeleteMapping
    fun deleteUserInfo(@RequestParam("userId") userId: Long){
        userService.deleteUser(userId)
    }
    @Operation(summary ="회원 정보 조회", description = "회원 정보를 조회하는 api입니다")
    @GetMapping
    fun getUserInfo(@RequestParam("userId") userId: Long): UserInfoResponse{
        return toUserInfoResponse(userService.getUserInfo(userId))
    }

    internal fun UpdateRequesttoUser(request: UserUpdateRequest): User{
        return User(
            id = request.id,
            nickname = request.nickname,
            profileImageUrl = request.profileImageUrl,
            email = request.email,
        )
    }
    internal fun toUserInfoResponse(entity: User): UserInfoResponse{
        return UserInfoResponse(
            id = entity.id!!,
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