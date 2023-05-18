-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ssaccer
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ssaccer`;
CREATE SCHEMA IF NOT EXISTS `ssaccer` DEFAULT CHARACTER SET utf8 ;
USE `ssaccer` ;

-- -----------------------------------------------------
-- Table `ssaccer`.`Videos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Videos`;

CREATE TABLE IF NOT EXISTS `ssaccer`.`Videos` (
                                                  `videoSeq` INT NOT NULL AUTO_INCREMENT,
                                                  `youtubeId` VARCHAR(50) NOT NULL,
    `title` VARCHAR(50) NOT NULL,
    `url` VARCHAR(500) NOT NULL,
    `channelName` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`videoSeq`),
    UNIQUE INDEX `videoSeq_UNIQUE` (`videoSeq` ASC) VISIBLE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 5
    DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `ssaccer`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Users`;

CREATE TABLE IF NOT EXISTS `ssaccer`.`Users` (
                                                 `userSeq` INT NOT NULL AUTO_INCREMENT,
                                                 `userId` VARCHAR(20) NOT NULL,
    `password` VARCHAR(30) NOT NULL,
    `name` VARCHAR(20) NOT NULL,
    `nickname` VARCHAR(20) NOT NULL,
    `role` VARCHAR(10) NOT NULL,
    PRIMARY KEY (`userSeq`),
    UNIQUE INDEX `user_seq_UNIQUE` (`userSeq` ASC) VISIBLE,
    UNIQUE INDEX `id_UNIQUE` (`userId` ASC) VISIBLE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 5
    DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ssaccer`.`VideoLikes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `VideoLikes`;

CREATE TABLE IF NOT EXISTS `ssaccer`.`VideoLikes` (
                                                      `videoSeq` INT NOT NULL,
                                                      `userSeq` INT NOT NULL,
                                                      PRIMARY KEY (`videoSeq`, `userSeq`),
    INDEX `fk_VideoLikes_userSeq_idx` (`userSeq` ASC) VISIBLE,
    CONSTRAINT `fk_VideoLikes_videoSeq`
    FOREIGN KEY (`videoSeq`)
    REFERENCES `ssaccer`.`Videos` (`videoSeq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_VideoLikes_userSeq`
    FOREIGN KEY (`userSeq`)
    REFERENCES `ssaccer`.`Users` (`userSeq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `ssaccer`.`VideoReviews`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssaccer`.`VideoReviews` (
                                                        `reviewSeq` INT NOT NULL AUTO_INCREMENT,
                                                        `userSeq` INT NOT NULL,
                                                        `videoSeq` INT NOT NULL,
                                                        `title` VARCHAR(100) NOT NULL,
    `content` VARCHAR(1000) NOT NULL,
    `viewCnt` INT NOT NULL DEFAULT 0,
    `createdDate` DATETIME NOT NULL,
    `modifiedDate` DATETIME NOT NULL,
    PRIMARY KEY (`reviewSeq`),
    UNIQUE INDEX `reviewSeq_UNIQUE` (`reviewSeq` ASC) VISIBLE,
    INDEX `fk_users_userSeq_idx` (`userSeq` ASC) VISIBLE,
    INDEX `fk_videos_videoSeq'_idx` (`videoSeq` ASC) VISIBLE,
    CONSTRAINT `fk_VideoReviews_userSeq`
    FOREIGN KEY (`userSeq`)
    REFERENCES `ssaccer`.`Users` (`userSeq`),
    CONSTRAINT `fk_VideoReviews_videoSeq'`
    FOREIGN KEY (`videoSeq`)
    REFERENCES `ssaccer`.`Videos` (`videoSeq`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 3
    DEFAULT CHARACTER SET = utf8;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- insert --

INSERT INTO Videos (youtubeId, title, url, channelName)
VALUES
    ("u5OgcZdNbMo", "저는 하체 식주의자 입니다", "https://www.youtube.com/embed/u5OgcZdNbMo", "GYM종국");

INSERT INTO users (userId, password, name, nickname, role)
VALUES
    ("ssafy", "1234", "박세윤", "Yun", "관리자");

INSERT INTO videoreviews (userSeq, videoSeq, title, content, createdDate, modifiedDate)
VALUES
    (5, 5, "놀랍네요", "감명받았습니다..", "2023-05-17 15:12:11", "2023-05-18 09:45:17");

-- select --

SELECT * FROM users;
SELECT * FROM videoreviews;
SELECT * FROM videolikes;
SELECT * FROM videos;
