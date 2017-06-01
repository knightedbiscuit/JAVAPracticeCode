CREATE SCHEMA `club` ;
CREATE TABLE `club`.`members` (
  `Surname` VARCHAR(45) NOT NULL,
  `FirstName` VARCHAR(45) NULL,
  `SecondName` VARCHAR(45) NULL,
  PRIMARY KEY (`Surname`));
