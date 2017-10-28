-- base de datos registro de instrumentos
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `registros` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
USE `registros` ;

-- Table ´registros´.ínstrumentos´
-- ***********************************************
CREATE TABLE IF NOT EXISTS `registros`.`instrumentos` (
`codigo` MEDIUMINT (9) NULL ,
`nombre` VARCHAR(50) NOT NULL,
`unidad` VARCHAR(50) NULL,
PRIMARY KEY (`nombre`))
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


-- INSERT INTO instrumentos VALUES ("03","Termómetro","PSI");
-- DELETE FROM instrumentos WHERE nombre="Pulgómetro";
SELECT * FROM instrumentos