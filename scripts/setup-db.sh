#!/bin/bash

# Start Cassandra container
docker-compose up -d

# Wait for Cassandra to start
echo "Waiting for Cassandra to start..."
while ! docker exec cassandra-container cqlsh -e "SHOW HOST" > /dev/null 2>&1; do
    sleep 1
done
echo "Cassandra started successfully"

# Run CQL migrations
# TODO: something smarter than harcoding single script.
echo "Running migration scripts...."
docker exec -it cassandra-container cqlsh -f /db/create_keyspace_and_table.cql

# Stop Cassandra container
docker-compose down

echo "Migration completed successfully"