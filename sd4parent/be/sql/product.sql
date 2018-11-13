CREATE TABLE `product` (
  `id_product` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `cost` float NOT NULL,
  `days` int(11) NOT NULL,
  `description` varchar(200) NOT NULL,
  `pictures` varchar(100) NOT NULL,
  PRIMARY KEY (`id_product`)
) ENGINE=InnoDB AUTO_INCREMENT=7