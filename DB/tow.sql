# database name = tow
CREATE SCHEMA IF NOT EXISTS `tow` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE tow;

#table > tow.ticket
CREATE TABLE `ticket` (
  `ticket_num` BIGINT NOT NULL,
  `category` VARCHAR(45) NULL,
  `title` VARCHAR(255) NULL,
  `register_date` DATE NULL,
  `pre_sale_date` DATETIME NULL,
  `open_sale_date` DATETIME NULL,
  `image_url` VARCHAR(255) NULL,
  `basic_info` LONGTEXT NULL,
  `introduction` LONGTEXT NULL,
  `agency_info` VARCHAR(255) NULL,
  PRIMARY KEY (`ticket_num`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

#가데이터
INSERT INTO `tow`.`ticket` (`ticket_num`, `category`, `title`, `register_date`, `open_sale_date`, `image_url`, `basic_info`, `introduction`, `agency_info`) VALUES ('1', '콘서트', 'BAND DALDAM concert <동아리>', '2024-05-21', '2024-05-24 20:00:00', 'https://cdnticket.melon.co.kr/resource/image/upload/ticketopen/2024/05/20240521171204527523df-c089-4d37-a28f-2da4eb2e6ab5.jpg/melon/resize/130x184/strip/true', '- 공 연 명 : BAND DALDAM concert < 동아리 >', '낡은 책상 위로 올라간 채로 오늘을 외쳐라', '주 최 : BLUE IS ROCK ');
INSERT INTO `tow`.`ticket` (`ticket_num`, `category`, `title`, `register_date`, `open_sale_date`, `image_url`, `basic_info`, `introduction`, `agency_info`) VALUES ('2', '콘서트', 'a', '2024-05-21', '2024-05-24 20:00:00', 'https://cdnticket.melon.co.kr/resource/image/upload/ticketopen/2024/05/20240521171204527523df-c089-4d37-a28f-2da4eb2e6ab5.jpg/melon/resize/130x184/strip/true', '- 공 연 명 : BAND DALDAM concert < 동아리 >', '낡은 책상 위로 올라간 채로 오늘을 외쳐라', '주 최 : BLUE IS ROCK ');
INSERT INTO `tow`.`ticket` (`ticket_num`, `category`, `title`, `register_date`, `open_sale_date`, `image_url`, `basic_info`, `introduction`, `agency_info`) VALUES ('3', '콘서트', 'b', '2024-05-21', '2024-05-24 20:00:00', 'https://cdnticket.melon.co.kr/resource/image/upload/ticketopen/2024/05/20240521171204527523df-c089-4d37-a28f-2da4eb2e6ab5.jpg/melon/resize/130x184/strip/true', '- 공 연 명 : BAND DALDAM concert < 동아리 >', '낡은 책상 위로 올라간 채로 오늘을 외쳐라', '주 최 : BLUE IS ROCK ');
INSERT INTO `tow`.`ticket` (`ticket_num`, `category`, `title`, `register_date`, `open_sale_date`, `image_url`, `basic_info`, `introduction`, `agency_info`) VALUES ('4', '콘서트', 'c', '2024-05-21', '2024-05-24 20:00:00', 'https://cdnticket.melon.co.kr/resource/image/upload/ticketopen/2024/05/20240521171204527523df-c089-4d37-a28f-2da4eb2e6ab5.jpg/melon/resize/130x184/strip/true', '- 공 연 명 : BAND DALDAM concert < 동아리 >', '낡은 책상 위로 올라간 채로 오늘을 외쳐라', '주 최 : BLUE IS ROCK ');
INSERT INTO `tow`.`ticket` (`ticket_num`, `category`, `title`, `register_date`, `open_sale_date`, `image_url`, `basic_info`, `introduction`, `agency_info`) VALUES ('5', '콘서트', 'd', '2024-05-21', '2024-05-24 20:00:00', 'https://cdnticket.melon.co.kr/resource/image/upload/ticketopen/2024/05/20240521171204527523df-c089-4d37-a28f-2da4eb2e6ab5.jpg/melon/resize/130x184/strip/true', '- 공 연 명 : BAND DALDAM concert < 동아리 >', '낡은 책상 위로 올라간 채로 오늘을 외쳐라', '주 최 : BLUE IS ROCK ');

