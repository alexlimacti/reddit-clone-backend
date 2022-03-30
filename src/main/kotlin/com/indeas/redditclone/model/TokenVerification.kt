package com.indeas.redditclone.model

import org.hibernate.annotations.GenericGenerator
import java.time.Instant
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "token_verification")
data class TokenVerification(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    val id: UUID,
    val token: String,

    @OneToOne
    val user: User,
    val experyDate: Instant
)