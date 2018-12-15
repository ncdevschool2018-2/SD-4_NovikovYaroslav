CREATE TABLE `product` (
  `id_product` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `cost` float NOT NULL,
  `days` int(11) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `pictures` varchar(100) NOT NULL,
  PRIMARY KEY (`id_product`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci