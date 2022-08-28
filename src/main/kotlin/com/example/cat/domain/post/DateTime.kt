package com.example.cat.domain.post

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.*



@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class DateTime(){
    @CreatedDate
    lateinit var createdAt: String
        private set
    @LastModifiedDate
    lateinit var updatedAt: String
        private set

    @PrePersist
    private fun onPrePersist() {
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"))
        this.updatedAt = this.createdAt
    }
    @PreUpdate
    private fun onPreUpdate() {
        this.updatedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"))
    }

}
