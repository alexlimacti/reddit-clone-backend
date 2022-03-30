package com.indeas.redditclone.model

import org.hibernate.annotations.GenericGenerator
import java.time.Instant
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotEmpty

@Entity
@Table(name = "comments")
data class Comment(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    val id: UUID,

    @NotEmpty
    val text: String,

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    val post: Post,

    val createdDate: Instant,

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    val user: User
)
