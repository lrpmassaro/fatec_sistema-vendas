CREATE DATABASE sistema_controle_vendas;

CREATE TABLE clientes(
codigo serial NOT NULL,
nome varchar(50),
cpf varchar(14),
telefone varchar(13),
CONSTRAINT clientes_pkey PRIMARY KEY (codigo)
);

CREATE TABLE produtos(
codigo serial NOT NULL,
nome varchar(50),
categoria varchar(50),
estoque integer,
precocusto real,
precovenda real,
CONSTRAINT produtos_pkey PRIMARY KEY (codigo)
);

CREATE TABLE vendas(
numero serial NOT NULL,
data date,
codigocliente integer,
codigoproduto integer,
quantidade integer,
valortotal real,
CONSTRAINT vendas_pkey PRIMARY KEY (numero)
);