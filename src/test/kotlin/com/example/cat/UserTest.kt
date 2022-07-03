package com.example.cat

import com.example.cat.domain.User
import com.example.cat.repository.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.web.WebAppConfiguration
import kotlin.test.assertEquals

@SpringBootTest
@WebAppConfiguration
@ActiveProfiles("test")
class UserTest @Autowired constructor(val userRepository: UserRepository) {

    @Test
    fun 회원가입(){
        //given
        val email = "test@gmail.com"
        //when
        userRepository.save(User(email = email))
        //then
        assertEquals(userRepository.findAll().size,1)
    }

}