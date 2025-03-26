CREATE TABLE category (
    id SERIAL PRIMARY KEY,
    uuid UUID NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(500),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    version INTEGER
);

CREATE TABLE transaction (
    id SERIAL PRIMARY KEY,
    uuid UUID NOT NULL UNIQUE,
    type VARCHAR(20) NOT NULL,
    category_id INTEGER NOT NULL,
    amount NUMERIC(12, 2) NOT NULL,
    description TEXT,
    transaction_time TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    version INTEGER,
    CONSTRAINT fk_transaction_category FOREIGN KEY (category_id) REFERENCES category (id)
);
