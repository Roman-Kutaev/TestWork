CREATE TABLE IF NOT EXISTS products
(
    id    BIGINT PRIMARY KEY ,
    name  VARCHAR(100) NOT NULL ,
    description VARCHAR(1000) NOT NULL
);