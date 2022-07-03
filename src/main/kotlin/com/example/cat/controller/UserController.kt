package com.example.cat.controller

import com.example.cat.domain.User
import com.example.cat.repository.UserRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/user")
@RestController
class UserController(val userRepository: UserRepository){

    @PostMapping
    fun signUp(@RequestParam("email") email:String): String{
        return userRepository.save(User(email = email)).email
    }
}