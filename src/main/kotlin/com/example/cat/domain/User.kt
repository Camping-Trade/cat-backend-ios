package com.example.cat.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.xml.stream.Location
import kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo

@Entity
@Table(name="member")
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    var id: Long? = null,
    var email: String,
    var nickname: String,
    var profileImageUrl: String,
    var thumbnailImageUrl: String? = null,
    var kakaoId: String? = null,
    var point: Int = 0,
)