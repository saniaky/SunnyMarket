BEGIN;

CREATE TABLE `users` (
  `id` INT(6) UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(100) UNIQUE NOT NULL,
  `password` char(40),
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE='utf8_general_ci';

COMMIT;