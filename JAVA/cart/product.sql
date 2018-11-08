create database cart;

--use  cart;

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) DEFAULT NULL, --NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into product values(1,'黑色的丝袜',500);
insert into product values(2,'充气娃娃',2500);
insert into product values(3,'皮鞭',180);
insert into product values(4,'蜡烛',0.20);