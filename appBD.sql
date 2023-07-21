CREATE DATABASE app_db;

USE app_db;

CREATE TABLE cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    cpf VARCHAR(11) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(150) NOT NULL,
    telefone VARCHAR(20) NOT NULL
);

CREATE TABLE funcionario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(150) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    cargo VARCHAR(100) NOT NULL,
    salario DOUBLE NOT NULL,
    dataAdmissao DATE NOT NULL
);