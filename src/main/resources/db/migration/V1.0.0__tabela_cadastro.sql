CREATE TABLE cadastro (
    id SERIAL NOT NULL,
    nome VARCHAR(50),
    descricao VARCHAR(50) NOT NULL,
    viabilidade VARCHAR(20) NOT NULL,
    situacao VARCHAR(20),
    data_cadastro DATE NOT NULL,
    data_situacao DATE,
    PRIMARY KEY (id)
);

INSERT INTO cadastro (nome, descricao, viabilidade, situacao, data_cadastro, data_situacao) values ('Fulano 1', 'descrição da ideia', 'BAIXA', 'REGISTRADA', '2020-02-09', null);
INSERT INTO cadastro (nome, descricao, viabilidade, situacao, data_cadastro, data_situacao) values ('Fulano 2', 'descrição da ideia', 'BAIXA', 'REGISTRADA', '2020-02-08', null);
INSERT INTO cadastro (nome, descricao, viabilidade, situacao, data_cadastro, data_situacao) values ('Fulano 3', 'descrição da ideia', 'BAIXA', 'REGISTRADA', '2020-02-07', null);
INSERT INTO cadastro (nome, descricao, viabilidade, situacao, data_cadastro, data_situacao) values ('Fulano 4', 'descrição da ideia', 'BAIXA', 'REGISTRADA', '2020-02-06', null);
INSERT INTO cadastro (nome, descricao, viabilidade, situacao, data_cadastro, data_situacao) values ('Fulano 5', 'descrição da ideia', 'BAIXA', 'REGISTRADA', '2020-02-05', null);