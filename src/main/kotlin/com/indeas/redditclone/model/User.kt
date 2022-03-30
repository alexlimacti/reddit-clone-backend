package com.indeas.redditclone.model

import org.hibernate.annotations.GenericGenerator
import java.time.Instant
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    val id: UUID,
    val username: String,
    val password: String,
    val email: String,
    val created: Instant,
    val enabled: Boolean

)