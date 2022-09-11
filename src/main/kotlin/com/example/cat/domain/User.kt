package com.example.cat.domain

import javax.persistence.*
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
    @Enumerated(EnumType.STRING)
    var roleType: RoleType = RoleType.USER,
    var point: Int = 0,
) {
    fun updatePoint(point: Int) {
        this.point += point
    }
}