CREATE KEYSPACE IF NOT EXISTS benediction_keyspace WITH replication = {'class':'SimpleStrategy', 'replication_factor':'1'};

USE benediction_keyspace;

CREATE TABLE IF NOT EXISTS events (
  project_name TEXT,
  timestamp TIMESTAMP,
  id UUID,
  path TEXT,
  user_identifier TEXT,
  PRIMARY KEY ((project_name), timestamp, id)
);