package com.example.cat.domain.sharing

import com.example.cat.domain.User
import javax.persistence.*

@Entity
@Table(name="share_record")
class ShareRecord (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val user: User,
    @Enumerated(EnumType.STRING)
    val type: ShareType,
    @OneToOne
    @JoinColumn(name = "share_post_id")
    val post: Post,
    val campId: Long,
    val pointToGet: Int,
) : DateTime()