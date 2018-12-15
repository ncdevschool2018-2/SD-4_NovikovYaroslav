CREATE TABLE `purse` (
  `id_purse` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(45) NOT NULL,
  `balance` double NOT NULL DEFAULT '0',
  `id_account` int(11) NOT NULL,
  PRIMARY KEY (`id_purse`),
  KEY `id_account_idx` (`id_account`),
  CONSTRAINT `PurseAccountFK` FOREIGN KEY (`id_account`) REFERENCES `account` (`id_account`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci