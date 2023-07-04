package io.github.stscoundrel.benediction.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.cassandra.core.mapping.Column
import org.springframework.data.cassandra.core.mapping.Table
import java.time.Instant
import java.util.*

@Table(value = "events")
class Event {

    @CreatedDate
    var timestamp: Instant

    @field:Column(value = "project_name")
    var projectName: String

    @Id
    var id: UUID
    var path: String

    @field:Column("user_identifier")
    var userIdentifier: String

    constructor(
        projectName: String,
        path: String,
        userIdentifier: String
    ) {
        // Main constructor for providing only non-automatic values.
        this.projectName = projectName
        this.path = path
        this.userIdentifier = userIdentifier
        this.timestamp = Instant.now()
        this.id = UUID.randomUUID()
    }

    constructor() {
        // "Default" constructor that exists mostly for test case serialization issues.
        this.projectName = ""
        this.path = ""
        this.userIdentifier = ""
        this.timestamp = Instant.now()
        this.id = UUID.randomUUID()
    }
}