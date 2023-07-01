package io.github.stscoundrel.benediction.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration
import org.springframework.data.cassandra.config.SchemaAction
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories

@Configuration
@EnableCassandraRepositories
class ApplicationConfig : AbstractCassandraConfiguration() {
    @Value("\${cassandra.contact-points}")
    private lateinit var contactPoints: String

    @Value("\${cassandra.port}")
    private var port: Int = 9042

    @Value("\${cassandra.keyspace}")
    private lateinit var keyspace: String

    override fun getKeyspaceName(): String {
        return keyspace
    }

    override fun getContactPoints(): String {
        return contactPoints
    }

    override fun getPort(): Int {
        return port
    }

    override fun getSchemaAction(): SchemaAction {
        return SchemaAction.CREATE_IF_NOT_EXISTS
    }
}