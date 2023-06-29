CREATE KEYSPACE IF NOT EXISTS benediction_keyspace WITH replication = {'class':'SimpleStrategy', 'replication_factor':'1'};

USE benediction_keyspace;

CREATE TABLE IF NOT EXISTS events (
  timestamp TIMESTAMP,
  project_name TEXT,
  id UUID,
  path TEXT,
  user_identifier TEXT,
  PRIMARY KEY ((timestamp, project_name), id)
);