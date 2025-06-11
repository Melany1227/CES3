CREATE TABLE `user` (
    `id_user` int NOT NULL AUTO_INCREMENT,
    `name` varchar(50) NOT NULL,
    `lastname` varchar(50) NOT NULL,
    `birthdate` date NOT NULL,
    `email` varchar(100) DEFAULT NULL,
    `password` varchar(40) NOT NULL,
    `is_active` tinyint(1) DEFAULT '1',
    `phone` varchar(15) DEFAULT NULL,
    `gender` enum('male','female') DEFAULT NULL,
    `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    `deleted_at` timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`id_user`),
    UNIQUE KEY `email_UNIQUE` (`email`)
);

CREATE TABLE `db1`.`subject` (
    `id` INT NOT NULL,
    `name` VARCHAR(50) NULL,
    `code` VARCHAR(6) NULL,
    `description` TEXT NOT NULL,
    `credit` INT NOT NULL,
    `faculty` ENUM('engineering', 'art', 'sports') NULL,
    `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `deleted_at` TIMESTAMP NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE
);

CREATE TABLE `db1`.`enrollement` (
     `id_user` INT NOT NULL,
     `id_subject` INT NOT NULL,
     `date_enrollement` TIMESTAMP NOT NULL,
     `state` ENUM('active', 'inactive', 'canceled', 'finalized', 'scheduled') NOT NULL,
     `term` VARCHAR(6) NOT NULL,
     `create_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
     `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
     `deleted_at` TIMESTAMP NULL,
     PRIMARY KEY (`id_user`, `id_subject`)
);