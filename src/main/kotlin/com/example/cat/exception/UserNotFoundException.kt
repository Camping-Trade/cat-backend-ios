package com.example.cat.exception

class UserNotFoundException(message: String) : IllegalAccessException(message) {
    companion object{
        fun byUserId(userId: String): UserNotFoundException {
            val message = "user with id $userId doesn't exist"
            return UserNotFoundException(message)
        }
        fun byUserEmail(email: String): UserNotFoundException {
            val message = "user with email $email doesn't exist"
            return UserNotFoundException(message)
        }
        fun byUserNickname(nickname: String): UserNotFoundException {
            val message = "user with nickname $nickname doesn't exist"
            return UserNotFoundException(message)
        }
    }
}