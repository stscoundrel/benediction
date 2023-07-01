package io.github.stscoundrel.benediction.repository

import io.github.stscoundrel.benediction.model.Event
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface EventRepository : CassandraRepository<Event, UUID>