CREATE TABLE PRODUTO (
    id        varchar(255) not null primary key,
    name      varchar(255) not null,
    descricao varchar(300),
    preco     numeric(18, 2)
);