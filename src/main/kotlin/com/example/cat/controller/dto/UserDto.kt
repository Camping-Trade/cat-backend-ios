package com.example.cat.controller.dto

import com.example.cat.domain.User

data class UserDto(
    val id: String,
    val nickname: String,
){
    companion object{
        fun fromEntity(entity: User): UserDto{
            return UserDto(
                id = entity.id.toString(),
                nickname = entity.nickname,
            )
        }
    }
}