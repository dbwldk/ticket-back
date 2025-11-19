# database name = tow
CREATE SCHEMA IF NOT EXISTS `TOW` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE TOW;

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
  `event_start_date` date DEFAULT NULL,
  `event_end_date` date DEFAULT NULL,
  `venue` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `region` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#table > event_sites
CREATE TABLE `event_sites` (
  `id` int NOT NULL AUTO_INCREMENT,
  `event_id` int NOT NULL,
  `sales_site` varchar(50) NOT NULL,
  `detail_link` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `event_id` (`event_id`),
  CONSTRAINT `event_sites_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `tickets` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ;

#table > ticket_views (조회수 분리)
CREATE TABLE `ticket_views` (
  `id` int NOT NULL AUTO_INCREMENT,
  `view_cnt` int DEFAULT '0',
  `ticket_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ticket_views_id` (`ticket_id`),
  CONSTRAINT `fk_ticket_views_id` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#table > naver_user
CREATE TABLE `naver_user` (
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `naver_token` varchar(255) DEFAULT NULL,
  `age` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

# table > ticket_reservation
CREATE TABLE `ticket_reservation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `ticket_id` int NOT NULL,
  `ticket_open_date` timestamp NOT NULL,
  `notification_hours` int DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `email_sent` tinyint DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `tk_res_email_idx` (`email`),
  KEY `tk_res_tk_id_idx` (`ticket_id`),
  CONSTRAINT `tk_res_email` FOREIGN KEY (`email`) REFERENCES `naver_user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tk_res_tk_id` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

# table > ticket_like
CREATE TABLE `ticket_like` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ticket_id` int NOT NULL,
  `u_id` varchar(255) NOT NULL,
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `tlk_ticket_id_idx` (`ticket_id`),
  KEY `tlk_u_id_idx` (`u_id`),
  CONSTRAINT `tlk_ticket_id` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tlk_u_id` FOREIGN KEY (`u_id`) REFERENCES `naver_user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

# table > user_pwd_token
CREATE TABLE `user_pwd_token` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `createdAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `upt_email_idx` (`email`),
  CONSTRAINT `upt_email` FOREIGN KEY (`email`) REFERENCES `naver_user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

# table > email_check
CREATE TABLE `email_check` (
  `id` int NOT NULL,
  `email` varchar(255) NOT NULL,
  `check_token` varchar(255) NOT NULL,
  `createAt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
