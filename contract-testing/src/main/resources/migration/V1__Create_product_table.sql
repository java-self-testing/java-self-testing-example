CREATE TABLE `product`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` nvarchar(100) NULL,
  `description` nvarchar(2000) NULL,
  `price` decimal(10, 2) NULL,
  `is_on_sale` boolean,
  PRIMARY KEY (`id`)
);
