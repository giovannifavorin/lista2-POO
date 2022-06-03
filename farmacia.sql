create database farmacia;

CREATE TABLE IF NOT EXISTS `mydb`.`Medicamento` (
  `idMedicamento` INT NOT NULL,
  `nome_laboratorio` VARCHAR(45) NULL,
  `preco` FLOAT NULL,
  `dt_vencimento` DATE NULL,
  `nome_medicamento` VARCHAR(45) NULL,
  `qtd_estoque` INT NULL,
  PRIMARY KEY (`idMedicamento`))
ENGINE = InnoDB

CREATE TABLE IF NOT EXISTS `mydb`.`cliente` (
  `idcliente` INT NOT NULL,
  `nome_cliente` VARCHAR(45) NULL,
  `idade` VARCHAR(45) NULL,
  `contato` VARCHAR(45) NULL,
  PRIMARY KEY (`idcliente`))
ENGINE = InnoDB

CREATE TABLE IF NOT EXISTS `mydb`.`funcionario` (
  `idfuncionario` INT NOT NULL,
  `nome_funcionario` VARCHAR(45) NULL,
  `cargo_funcionario` VARCHAR(45) NULL,
  `contato` VARCHAR(45) NULL,
  PRIMARY KEY (`idfuncionario`))
ENGINE = InnoDB