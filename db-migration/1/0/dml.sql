CREATE TABLE Transaction (
    id SERIAL PRIMARY KEY,
    type VARCHAR(20) NOT NULL,
    category VARCHAR(50),
    amount NUMERIC(12, 2) NOT NULL,
    description TEXT,
    transaction_time TIMESTAMP NOT NULL,
    created TIMESTAMP NOT NULL,
    updated TIMESTAMP,
    version INTEGER
);
