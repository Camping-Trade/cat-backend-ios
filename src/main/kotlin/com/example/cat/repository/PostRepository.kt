package com.example.cat.repository

import com.example.cat.domain.sharing.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository: JpaRepository<Post, Long> {
    fun findAllByCampIdOrderByCreatedAtDesc(campId: String): List<Post>
}