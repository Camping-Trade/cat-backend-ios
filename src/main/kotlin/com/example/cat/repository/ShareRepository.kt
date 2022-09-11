package com.example.cat.repository

import com.example.cat.domain.sharing.ShareRecord
import org.springframework.data.jpa.repository.JpaRepository

interface ShareRepository: JpaRepository<ShareRecord, Long> {
}