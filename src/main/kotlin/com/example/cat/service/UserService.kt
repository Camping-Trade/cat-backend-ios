package com.example.cat.service

import com.example.cat.domain.User
import com.example.cat.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun signUp(user: User): User{
        userRepository.findByEmail(user.email)?.let { throw IllegalAccessException("이미 존재하는 회원입니다") }
        return userRepository.save(user)
    }
    fun updateUserInfo(request: User): User{

       var user = request.id?.let { finduserbyId(it) }
           ?: throw IllegalStateException("userId가 입력되지 않았습니다")
        user.email = request.email
        user.nickname = request.nickname
        user.profileImageUrl = request.profileImageUrl
        return userRepository.save(user)
    }
    fun deleteUser(userId: Long){
        var user = finduserbyId(userId)
        userRepository.delete(user)
    }
    fun getUserInfo(userId: Long): User{
        return finduserbyId(userId)
    }
    internal fun finduserbyId(userId: Long): User{
       return userRepository.findById(userId)
           .orElseThrow{ IllegalAccessException("존재하지 않는 회원입니다")}

    }
}