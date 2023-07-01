package io.github.stscoundrel.benediction.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.Table
import java.time.Instant
import java.util.*

@Table(value = "events")
class Event {
    // Note: while timestamp & id won't ever be null in DB level,
    // they may be empty while instantiating new Event model.
    // Defaults will handle those situations.

    @CreatedDate
    var timestamp: Instant

    @field:Column(value = "project_name")
    val projectName: String

    @Id
    var id: UUID
    val path: String

    @field:Column("user_identifier")
    val userIdentifier: String

    constructor(
        projectName: String,
        path: String,
        userIdentifier: String
    ) {
        this.projectName = projectName
        this.path = path
        this.userIdentifier = userIdentifier
        this.timestamp = Instant.now()
        this.id = UUID.randomUUID()
    }
}