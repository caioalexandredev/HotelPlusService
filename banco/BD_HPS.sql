CREATE DATABASE BD_HOTELPLUSSERVICE;
USE BD_HOTELPLUSSERVICE;

CREATE TABLE quarto (
  `id` INT NOT NULL,
  `numeroQuarto` INT NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `precoDiaria` DOUBLE NOT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE produtos (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` INT NULL,
  `preco` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
);
  
CREATE TABLE endereco (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rua` VARCHAR(45) NOT NULL,
  `numero` INT NOT NULL,
  `complemento` VARCHAR(45) NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE usuario (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `dataNasc` DATE NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `cargo` VARCHAR(45) NOT NULL,
  `remuneracao` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NULL,
  `nivel` INT NOT NULL,
  `FK_Endereco` INT,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`FK_Endereco`)
  REFERENCES endereco(`id`)
);
  
CREATE TABLE cliente (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `dataNasc` DATE NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `FK_Endereco` INT,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`FK_Endereco`)
  REFERENCES endereco(`id`)
);
  
CREATE TABLE ocupacao (
  `id` INT NOT NULL AUTO_INCREMENT,
  `check-in` DATE,
  `check-out` DATE,
  `reserva` DATE NOT NULL,
  `FK_Cliente` INT NOT NULL,
  `FK_Quarto` INT NOT NULL,
  PRIMARY KEY(`id`),
  FOREIGN KEY (`FK_Cliente`)
  REFERENCES cliente(`id`),
  FOREIGN KEY (`FK_Quarto`)
  REFERENCES quarto(`id`)
);

CREATE TABLE frigobar (
  `FK_Produto` INT NOT NULL,
  `FK_Ocupacao` INT NOT NULL,
  FOREIGN KEY (`FK_Produto`)
  REFERENCES produtos(`id`),
  FOREIGN KEY (`FK_Ocupacao`)
  REFERENCES ocupacao(`id`)
);

CREATE TABLE ponto(
	id INT NOT NULL AUTO_INCREMENT,
    datahora DATETIME NOT NULL,
	FK_Usuario INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (FK_Usuario)
    REFERENCES usuario(id)
);

-- Endereço para Usuários Padrões
INSERT INTO `endereco` (`id`, `rua`, `numero`, `complemento`, `bairro`, `cidade`, `estado`) VALUES ('1', 'Rua Padrão', '0', 'Padrão', 'Padrão', 'Padrão', 'Padrão');

-- Usuários Adminstradores
INSERT INTO `usuario` (`id`, `nome`, `dataNasc`, `cpf`, `telefone`, `email`, `cargo`, `remuneracao`, `senha`, `nivel`, `FK_Endereco`) VALUES (NULL, 'Caio Alexandre de Sousa Ramos', '2000-07-16', '592.760.500-19', '(63) 9 9110-6619', 'caio.ramos@estudante.ifto.edu.br', 'Administrador', '6000', '123', '3', 1);
INSERT INTO `usuario` (`id`, `nome`, `dataNasc`, `cpf`, `telefone`, `email`, `cargo`, `remuneracao`, `senha`, `nivel`, `FK_Endereco`) VALUES (NULL, 'Lucas Eduardo Sampaio', '2000-07-16', '592.760.500-19', ' (63) 9 9231-9709', 'lucas.andrade5@estudante.ifto.edu.br', 'Administrador', '6000', '123', '3', 1);

-- Quartos
INSERT INTO `quarto` (`id`, `numeroQuarto`, `tipo`, `precoDiaria`) VALUES (1, 101, 'Casal', 140.00);
INSERT INTO `quarto` (`id`, `numeroQuarto`, `tipo`, `precoDiaria`) VALUES (2, 102, 'Casal', 140.00);
INSERT INTO `quarto` (`id`, `numeroQuarto`, `tipo`, `precoDiaria`) VALUES (3, 103, 'Solteiro', 110.00);
INSERT INTO `quarto` (`id`, `numeroQuarto`, `tipo`, `precoDiaria`) VALUES (4, 104, 'Solteiro', 140.00);
INSERT INTO `quarto` (`id`, `numeroQuarto`, `tipo`, `precoDiaria`) VALUES (5, 201, 'Casal', 140.00);
INSERT INTO `quarto` (`id`, `numeroQuarto`, `tipo`, `precoDiaria`) VALUES (6, 202, 'Triplo', 160.00);
INSERT INTO `quarto` (`id`, `numeroQuarto`, `tipo`, `precoDiaria`) VALUES (7, 203, 'Triplo', 160.00);
INSERT INTO `quarto` (`id`, `numeroQuarto`, `tipo`, `precoDiaria`) VALUES (8, 204, 'Triplo', 160.00);