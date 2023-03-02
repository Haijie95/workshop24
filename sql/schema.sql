CREATE TABLE `orders` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(128) NOT NULL,
  `order_date` date DEFAULT NULL,
  `ship_address` varchar(128) NOT NULL,
  `notes` text,
  `tax` decimal(2,2) NOT NULL DEFAULT '0.05',
  PRIMARY KEY (`order_id`)
);

CREATE TABLE `order_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product` varchar(128) NOT NULL,
  `unit_price` decimal(5,2) NOT NULL,
  `discount` decimal(2,1) DEFAULT '1.0',
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_orders_id` FOREIGN KEY (`id`) REFERENCES `orders` (`order_id`)
)

