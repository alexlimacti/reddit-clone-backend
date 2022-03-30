package com.indeas.redditclone.model

import org.hibernate.annotations.GenericGenerator
import java.time.Instant
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "token_refresh")
data class TokenRefresh(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    val id: UUID,
    val token: String,
    val createdDate: Instant
)
