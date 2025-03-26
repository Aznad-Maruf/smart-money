CREATE TABLE message (
    id SERIAL PRIMARY KEY,
    uuid UUID NOT NULL UNIQUE,
    message TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    version INTEGER
);