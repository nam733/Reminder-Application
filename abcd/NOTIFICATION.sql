create database notification;

use notification;

CREATE TABLE `register` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `psw` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `notebooks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `notebookname` varchar(255) DEFAULT NULL,
  `reg_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `note` (
  `note_id` int NOT NULL AUTO_INCREMENT,
  `note_name` varchar(250) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `reminder_date` date NOT NULL,
  `status` varchar(50) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `description` varchar(500) NOT NULL,
  `notebook_id` int DEFAULT NULL,
  `reg_id` int DEFAULT NULL,
  PRIMARY KEY (`note_id`),
  UNIQUE KEY `note_name` (`note_name`),
  KEY `notebook_id` (`notebook_id`),
  CONSTRAINT `note_ibfk_1` FOREIGN KEY (`notebook_id`) REFERENCES `notebooks` (`id`),
  CONSTRAINT `CheckEndLaterThanStart` CHECK ((`end_date` >= `start_date`))
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



