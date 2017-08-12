------------
-- Table `BuenFestLocaText`.`PreguntaSeguridad`
-- -----------------------------------------------------
CREATE TABLE PreguntaSeguridad (
  idPreguntaSeguridad INT NOT NULL AUTO_INCREMENT,
  Pregunta TEXT NULL,
  PRIMARY KEY (`idPreguntaSeguridad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BuenFestLocaText`.`Usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BuenFestLocaText`.`Usuarios` (
  `idUsuarios` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NULL,
  `contrasena` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  `IdPreguntaSeguridadFK` INT NOT NULL,
  PRIMARY KEY (`idUsuarios`, `IdPreguntaSeguridadFK`),
  INDEX `fk_Usuarios_PreguntaSeguridad_idx` (`IdPreguntaSeguridadFK` ASC),
  CONSTRAINT `fk_Usuarios_PreguntaSeguridad`
    FOREIGN KEY (`IdPreguntaSeguridadFK`)
    REFERENCES `BuenFestLocaText`.`PreguntaSeguridad` (`idPreguntaSeguridad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;