-- create table for techcon
CREATE DATABASE `techcon`;
USE techcon;
CREATE TABLE `Sessions` (
      `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
      `start_time` int(10) unsigned NOT NULL,
      `end_time` int(10) unsigned NOT NULL,
      `title` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL,
      `description` varchar(4096) CHARACTER SET utf8mb4 DEFAULT NULL,
      `slide_url` varchar(1024) CHARACTER SET utf8mb4 DEFAULT NULL,
      `movie_url` varchar(1024) CHARACTER SET utf8mb4 DEFAULT NULL,
      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

CREATE TABLE `Speakers` (
      `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
      `name` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL,
      `title` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL,
      `github_id` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL,
      `twitter_id` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL,
      `description` varchar(4096) CHARACTER SET utf8mb4 DEFAULT NULL,
      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

CREATE TABLE `SpeakerRelations` (
      `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
      `session_id` int(10) unsigned NOT NULL,
      `speaker_id` int(10) unsigned NOT NULL,
      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

CREATE TABLE `Tags` (
      `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
      `name` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL,
      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

CREATE TABLE `TagRelations` (
      `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
      `session_id` int(10) unsigned NOT NULL,
      `tag_id` int(10) unsigned NOT NULL,
      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

