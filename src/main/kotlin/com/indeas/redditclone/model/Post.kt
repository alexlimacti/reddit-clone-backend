package com.indeas.redditclone.model

import org.hibernate.annotations.GenericGenerator
import org.springframework.lang.Nullable
import java.time.Instant
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.Lob
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "posts")
data class Post(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    val id: UUID,

    @NotBlank(message = "Post Name cannot be empty or null")
    val postName: String,

    @Nullable
    val url: String,

    @Nullable
    @Lob
    val description: String,

    val voteCount: Int = 0,

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    val user: User,

    val createdDate: Instant,

    @ManyToOne
    @JoinColumn(name = "subreddit_id", referencedColumnName = "id")
    val subreddit: Subreddit
)
