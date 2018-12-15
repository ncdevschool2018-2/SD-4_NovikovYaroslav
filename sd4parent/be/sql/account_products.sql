CREATE TABLE `account_products` (
  `id_account_products` int(11) NOT NULL AUTO_INCREMENT,
  `id_account` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `date_beg` date NOT NULL,
  `date_end` date NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_account_products`),
  UNIQUE KEY `account_products_id_account_products_uindex` (`id_account_products`),
  KEY `id_account_idx` (`id_account`),
  KEY `id_product_idx` (`id_product`),
  CONSTRAINT `AccountProductsAccountFK` FOREIGN KEY (`id_account`) REFERENCES `account` (`id_account`),
  CONSTRAINT `AccountProductsProductFK` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci