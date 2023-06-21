-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


-- -----------------------------------------------------
-- Schema ssaccer
-- -----------------------------------------------------
-- DROP SCHEMA IF EXISTS `ssaccer`;
CREATE SCHEMA IF NOT EXISTS `ssaccer` CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ;
USE `ssaccer` ;

-- -----------------------------------------------------
-- Table `ssaccer`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `ssaccer`.`users` (
  `userSeq` INT NOT NULL AUTO_INCREMENT,
  `userId` VARCHAR(20) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `nickname` VARCHAR(20) NOT NULL,
  `role` VARCHAR(10) NOT NULL DEFAULT 'UNRANKED',
  `position` VARCHAR(10) NOT NULL,
  `phoneNumber` VARCHAR(50) NOT NULL,
  `img` VARCHAR(500) NULL DEFAULT NULL,
  `orgimg` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`userSeq`),
  UNIQUE INDEX `userSeq_UNIQUE` (`userSeq` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`userId` ASC) VISIBLE,
  UNIQUE INDEX `phoneNumber_UNIQUE` (`phoneNumber` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE utf8mb4_general_ci;


-- -----------------------------------------------------
-- Table `ssaccer`.`articles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `articles`;
CREATE TABLE IF NOT EXISTS `ssaccer`.`articles` (
  `articleSeq` INT NOT NULL AUTO_INCREMENT,
  `userSeq` INT NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `content` VARCHAR(5000) NOT NULL,
  `viewCnt` INT NOT NULL DEFAULT '0',
  `recruiteCnt` INT NOT NULL,
  `recruiteMax` INT NOT NULL,
  `place` VARCHAR(300) NOT NULL,
  `cost` INT NOT NULL DEFAULT '0',
  `ability` VARCHAR(50) NOT NULL,
  `status` VARCHAR(50) NOT NULL,
  `gender` VARCHAR(50) NOT NULL,
   `shower` TINYINT(1) NOT NULL,
  `parking` TINYINT(1) NOT NULL,
  `beverage` TINYINT(1) NOT NULL,
  `rental` TINYINT(1) NOT NULL,
  `createdDate` TIMESTAMP NOT NULL,
  `matchstartdate` TIMESTAMP NOT NULL,
  `matchenddate` TIMESTAMP NOT NULL,
  PRIMARY KEY (`articleSeq`),
  UNIQUE INDEX `articleSeq_UNIQUE` (`articleSeq` ASC) VISIBLE,
  INDEX `fk_articles_userSeq_idx` (`userSeq` ASC) VISIBLE,
  CONSTRAINT `fk_articles_userSeq`
    FOREIGN KEY (`userSeq`)
    REFERENCES `ssaccer`.`users` (`userSeq`)
    ON UPDATE CASCADE
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE utf8mb4_general_ci;


-- -----------------------------------------------------
-- Table `ssaccer`.`soccerfields`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `soccerfields`;
CREATE TABLE IF NOT EXISTS `ssaccer`.`soccerfields` (
  `fieldSeq` INT NOT NULL AUTO_INCREMENT,
  `first` VARCHAR(45) NULL DEFAULT NULL,
  `second` VARCHAR(45) NULL DEFAULT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `owner` VARCHAR(45) NULL DEFAULT NULL,
  `year` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`fieldSeq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE utf8mb4_general_ci;


-- -----------------------------------------------------
-- Table `ssaccer`.`xypoints`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `xypoints`; 
CREATE TABLE IF NOT EXISTS `ssaccer`.`xypoints` (
  `pointSeq` INT NOT NULL AUTO_INCREMENT,
  `first` VARCHAR(45)  NULL,
  `second` VARCHAR(45) NULL DEFAULT NULL,
  `third` VARCHAR(45) NULL DEFAULT NULL,
  `x` INT NOT NULL,
  `y` INT NOT NULL,
  `longitude` DOUBLE NOT NULL,
  `latitude` DOUBLE NOT NULL,
  PRIMARY KEY (`pointSeq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE utf8mb4_general_ci;


-- -----------------------------------------------------
-- Table `ssaccer`.`teams`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `teams`;
CREATE TABLE IF NOT EXISTS `ssaccer`.`teams` (
  `teamSeq` INT NOT NULL AUTO_INCREMENT,
  `userSeq` INT NOT NULL,
  `articleSeq` INT NOT NULL,
  PRIMARY KEY (`teamSeq`),
  UNIQUE INDEX `teamSeq_UNIQUE` (`teamSeq` ASC) VISIBLE,
  INDEX `fk_teams_userSeq_idx` (`userSeq` ASC) VISIBLE,
  INDEX `fk_teams_articleSeq_idx` (`articleSeq` ASC) VISIBLE,
  CONSTRAINT `fk_teams_articleSeq`
    FOREIGN KEY (`articleSeq`)
    REFERENCES `ssaccer`.`articles` (`articleSeq`),
  CONSTRAINT `fk_teams_userSeq`
    FOREIGN KEY (`userSeq`)
    REFERENCES `ssaccer`.`users` (`userSeq`)
	ON UPDATE CASCADE
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE utf8mb4_general_ci;


-- -----------------------------------------------------
-- Table `ssaccer`.`videos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `videos`;
CREATE TABLE IF NOT EXISTS `ssaccer`.`videos` (
  `videoSeq` INT NOT NULL AUTO_INCREMENT,
  `youtubeId` VARCHAR(100) NOT NULL,
  `title` VARCHAR(200) NOT NULL,
  `url` VARCHAR(500) NOT NULL,
  `channelName` VARCHAR(100) NOT NULL,
  `thumbnail` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`videoSeq`),
  UNIQUE INDEX `videoSeq_UNIQUE` (`videoSeq` ASC) VISIBLE,
  UNIQUE INDEX `youtubeId_UNIQUE` (`youtubeId` ASC) VISIBLE,
  UNIQUE INDEX `url_UNIQUE` (`url` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE utf8mb4_general_ci;


-- -----------------------------------------------------
-- Table `ssaccer`.`reviews`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `reviews`;
CREATE TABLE IF NOT EXISTS `ssaccer`.`reviews` (
  `reviewSeq` INT NOT NULL AUTO_INCREMENT,
  `userSeq` INT NOT NULL,
  `videoSeq` INT NOT NULL,
  `title` VARCHAR(100) NOT NULL,
  `content` VARCHAR(1000) NOT NULL,
  `writer` VARCHAR(30) NOT NULL,
  `viewCnt` INT NOT NULL DEFAULT '0',
  `createdDate` TIMESTAMP NOT NULL,
  PRIMARY KEY (`reviewSeq`),
  UNIQUE INDEX `reviewSeq_UNIQUE` (`reviewSeq` ASC) VISIBLE,
  INDEX `fk_videoreviews_userSeq_idx` (`userSeq` ASC) VISIBLE,
  INDEX `fk_videoreviews_videoSeq_idx` (`videoSeq` ASC) VISIBLE,
  CONSTRAINT `fk_reviews_userSeq`
    FOREIGN KEY (`userSeq`)
    REFERENCES `ssaccer`.`users` (`userSeq`)
	ON UPDATE CASCADE
    ON DELETE CASCADE,
  CONSTRAINT `fk_reviews_videoSeq`
    FOREIGN KEY (`videoSeq`)
    REFERENCES `ssaccer`.`videos` (`videoSeq`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE utf8mb4_general_ci;


-- -----------------------------------------------------
-- Table `ssaccer`.`rlikes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rlikes`;
CREATE TABLE IF NOT EXISTS `ssaccer`.`rlikes` (
  `likeSeq` INT NOT NULL AUTO_INCREMENT,
  `userSeq` INT NOT NULL,
  `reviewSeq` INT NOT NULL,
  UNIQUE INDEX `reviewlikeSeq_UNIQUE` (`likeSeq` ASC) VISIBLE,
  INDEX `fk_reviewlikes_userSeq_idx` (`userSeq` ASC) VISIBLE,
  INDEX `fk_reviewlikes_videoreviewSeq_idx` (`reviewSeq` ASC) VISIBLE,
  CONSTRAINT `fk_rlikes_userSeq`
    FOREIGN KEY (`userSeq`)
    REFERENCES `ssaccer`.`users` (`userSeq`)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
  CONSTRAINT `fk_rlikes_reviewSeq`
    FOREIGN KEY (`reviewSeq`)
    REFERENCES `ssaccer`.`reviews` (`reviewSeq`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE utf8mb4_general_ci;

-- -----------------------------------------------------
-- Table `ssaccer`.`regioncodes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `regioncodes`;
CREATE TABLE IF NOT EXISTS `ssaccer`.`regioncodes` (
  `regioncodeSeq` INT NOT NULL AUTO_INCREMENT,
  `region` VARCHAR(45) NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`regioncodeSeq`),
  UNIQUE INDEX `regioncodeSeq_UNIQUE` (`regioncodeSeq` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE utf8mb4_general_ci;

-- -----------------------------------------------------
-- Table `ssaccer`.`bigregioncodes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssaccer`.`bigregioncodes` (
  `bigregioncodeSeq` INT NOT NULL AUTO_INCREMENT,
  `bigregion` VARCHAR(45) NOT NULL,
  `bigcode` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`bigregioncodeSeq`),
  UNIQUE INDEX `bigregioncodeSeq_UNIQUE` (`bigregioncodeSeq` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE utf8mb4_general_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- insert --
insert into users (userId, password, name, nickname, role, position, phoneNumber, img, orgimg)
VALUES("ssafy", "1234", "박세윤", "Yun", "ADMIN", "올라운더", "010-5183-2208", "img", "orimg");

-- drop table  if exists `soccerxy`;

create table if not exists `soccerxy` 
select p.first as pf, s.first as sf, p.second as ps, s.second as ss, p.x as x, p.y as y, s.name as name, s.year as year, p.longitude as longitude, p.latitude as latitude
from xypoints as p, soccerfields as s
where p.first like concat('%', s.first, '%') OR p.second like concat('%', s.second, '%')
group by ps;

-- drop table `soccerxy`; 

select * from videos;
select * from users;
select * from reviews;
select * from rlikes;	
select * from articles;
select * from teams;

select * from soccerfields;
select * from xypoints;
select * from soccerxy;

select * from regioncodes;
select * from bigregioncodes;

select * from soccerxy where name like "한강공원%";
