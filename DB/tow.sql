# database name = tow
CREATE SCHEMA IF NOT EXISTS `TOW` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE TOW;

#table > event_sites
CREATE TABLE `event_sites` (
  `id` int NOT NULL AUTO_INCREMENT,
  `event_id` int NOT NULL,
  `sales_site` varchar(50) NOT NULL,
  `detail_link` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `event_id` (`event_id`),
  CONSTRAINT `event_sites_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `tickets` (`id`)
);

#table > tickets
CREATE TABLE `tickets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `event_name` varchar(255) NOT NULL,
  `registration_date` date NOT NULL,
  `ticket_open_date` datetime NOT NULL,
  `pre_sale_date` datetime DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `basic_info` text,
  `event_description` text,
  `agency_info` text,
  `genre` varchar(50) DEFAULT NULL,
  `view_count` int DEFAULT '0',
  `event_start_date` date DEFAULT NULL,
  `event_end_date` date DEFAULT NULL,
  `venue` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);