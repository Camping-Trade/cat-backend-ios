package com.example.cat.domain.post

import com.example.cat.domain.User
import javax.persistence.*

@Entity
@Table(name = "sale_post")
class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val writer: User,
    val title: String,
    val content: String,
    val imageUrl: String? = null,
    val location : String? = null,
    val campId: String,
    val type: PostType = PostType.SHARE,
) : DateTime()