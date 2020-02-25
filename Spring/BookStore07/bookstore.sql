/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.5.28 : Database - bookstore_0519
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookstore_0519` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookstore_0519`;

/*Table structure for table `bs_book` */

DROP TABLE IF EXISTS `bs_book`;

CREATE TABLE `bs_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `author` varchar(200) NOT NULL,
  `price` double(11,2) DEFAULT NULL,
  `sales` int(11) unsigned DEFAULT NULL,
  `stock` int(11) unsigned DEFAULT NULL,
  `img_path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

/*Data for the table `bs_book` */

insert  into `bs_book`(`id`,`title`,`author`,`price`,`sales`,`stock`,`img_path`) values (5,'wo说不能改','奥利橙橙',99.00,99,0,'static/img/default.jpg'),(9,'来啊 快活啊','反正有 大把时光',233.00,200,0,'/static/img/default.jpg'),(11,'苏东坡传4','林语堂',19.30,200,0,'/static/img/default.jpg'),(12,'百年孤独','马尔克斯',29.50,200,0,'/static/img/default.jpg'),(13,'扶桑','严歌苓',19.80,102,98,'/static/img/default.jpg'),(15,'给孩子的诗','北岛',22.20,105,95,'/static/img/default.jpg'),(16,'为奴十二年','所罗门',16.50,104,96,'/static/img/default.jpg'),(17,'平凡的世界','路遥',55.00,102,98,'/static/img/default.jpg'),(18,'悟空传','今何在',14.00,100,100,'/static/img/default.jpg'),(19,'硬派健身','斌卡',31.20,100,100,'/static/img/default.jpg'),(20,'从晚清到民国','唐德刚',39.90,104,96,'/static/img/default.jpg'),(21,'三体','刘慈欣',56.50,200,0,'/static/img/default.jpg'),(22,'看见','柴静',19.50,100,100,'/static/img/default.jpg'),(23,'活着','余华',11.00,100,100,'/static/img/default.jpg'),(24,'小王子','安托万',19.20,101,99,'/static/img/default.jpg'),(25,'我们liang','杨绛',11.30,101,99,'/static/img/default.jpg'),(26,'生命不息,折腾不止','罗永浩',25.20,200,0,'/static/img/default.jpg'),(27,'皮囊','蔡崇达',23.90,200,0,'/static/img/default.jpg'),(28,'恰到好处的幸福','毕淑敏',16.40,200,0,'/static/img/default.jpg'),(29,'艾伦·图灵传','安德鲁',47.20,200,0,'/static/img/default.jpg'),(30,'大数据预测','埃里克',37.20,106,94,'/static/img/default.jpg'),(31,'人月神话','布鲁克斯',55.90,102,98,'/static/img/default.jpg'),(32,'C语言入门经典','霍尔顿',45.00,102,98,'/static/img/default.jpg'),(33,'数学之美3','吴军',29.90,101,99,'/static/img/default.jpg'),(34,'Java编程思想','埃史尔',70.50,102,98,'/static/img/default.jpg'),(35,'设计模式之禅','秦小波',20.20,100,100,'/static/img/default.jpg'),(38,'喜爱夜蒲','方法',21.00,1223,100,'/static/img/default.jpg'),(39,'黄帝内经','九天玄女',99.00,9999,1,'/static/img/default.jpg'),(40,'金瓶梅','小潘',10.00,1,0,'/static/img/default.jpg'),(41,'JAVA入门到放弃','坑',100.00,100,1,'/static/img/default.jpg'),(42,'提款姬','冯友兰',44.50,102,98,'/static/img/default.jpg'),(43,'鱼尾文',' 劳伦',19.33,101,99,'/static/img/default.jpg'),(44,'冯德顺嘿嘿嘿','hahaha',111.00,222,333,'/static/img/default.jpg'),(45,'来啊  开黑啊','666',666.00,666,666,'/static/img/default.jpg');

/*Table structure for table `bs_order` */

DROP TABLE IF EXISTS `bs_order`;

CREATE TABLE `bs_order` (
  `id` char(30) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `total_money` double(11,2) DEFAULT NULL,
  `status` int(2) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `bs_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `bs_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bs_order` */

insert  into `bs_order`(`id`,`create_date`,`total_money`,`status`,`user_id`) values ('14709719150931','2016-08-12 11:18:35',0.00,1,1),('14709720088002','2016-08-12 11:20:08',0.00,2,2),('14709748642071','2016-08-12 12:07:44',108.33,1,1),('14709749513651','2016-08-12 12:09:11',108.33,1,1),('14709826419072','2016-08-12 14:17:21',97.60,1,2),('14709909441592','2016-08-12 16:35:44',227.00,0,2),('14709919901575','2016-08-12 16:53:10',682217.50,0,5),('147105032109218','2016-08-13 09:05:21',68.13,2,18),('147105128146118','2016-08-13 09:21:21',97.60,1,18),('147105156051918','2016-08-13 09:26:00',11263.00,0,18),('147105157299118','2016-08-13 09:26:12',11263.00,1,18),('147105165059218','2016-08-13 09:27:30',10699.85,0,18),('147105178821218','2016-08-13 09:29:48',98.20,0,18),('147105191723618','2016-08-13 09:31:57',9437.40,0,18),('14710519985125','2016-08-13 09:33:18',10699.85,0,5),('147105354258918','2016-08-13 09:59:02',97.60,0,18),('147105566901418','2016-08-13 10:34:29',32.80,0,18),('147105611297618','2016-08-13 10:41:52',32.80,0,18),('147105701857818','2016-08-13 10:56:58',38.66,0,18),('147105713114918','2016-08-13 10:58:51',38.66,0,18),('147105895731518','2016-08-13 11:29:17',38.66,0,18),('147106008239518','2016-08-13 11:48:02',57.99,0,18),('147106013632818','2016-08-13 11:48:56',38.66,0,18),('14762330544485','2016-10-12 08:44:14',57.99,0,5),('14762373402035','2016-10-12 09:55:40',79.80,0,5),('14762373574885','2016-10-12 09:55:57',38.60,0,5),('14762374330105','2016-10-12 09:57:13',38.60,0,5),('147623778723210','2016-10-12 10:03:07',38.66,0,10),('14782240879339','2016-11-04 09:48:07',38.70,0,9),('14782281695649','2016-11-04 10:56:09',30.50,0,9),('14782282158349','2016-11-04 10:56:55',48.80,0,9),('14782282281159','2016-11-04 10:57:08',48.80,0,9),('147822861131620','2016-11-04 11:03:31',38.66,0,20),('147954500870710','2016-11-19 16:43:28',79.80,0,10),('147954672892931','2016-11-19 17:12:08',35.80,0,31),('147954689956531','2016-11-19 17:14:59',38.66,0,31),('14813523807322','2016-12-10 14:46:20',38.66,0,2),('14813564445012','2016-12-10 15:54:04',44.40,0,2),('148135663906610','2016-12-10 15:57:19',38.60,0,10),('2017061704501195132','2017-06-17 16:50:11',252.30,0,32);

/*Table structure for table `bs_order_item` */

DROP TABLE IF EXISTS `bs_order_item`;

CREATE TABLE `bs_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `price` double(11,2) DEFAULT NULL,
  `author` varchar(200) DEFAULT NULL,
  `b_count` int(11) DEFAULT NULL,
  `total_price` double(11,2) DEFAULT NULL,
  `order_id` char(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `bs_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `bs_order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

/*Data for the table `bs_order_item` */

insert  into `bs_order_item`(`id`,`title`,`price`,`author`,`b_count`,`total_price`,`order_id`) values (1,'提款姬',44.50,'冯友兰',2,89.00,'14709748642071'),(2,'鱼尾文',19.33,' 劳伦',1,19.33,'14709748642071'),(3,'提款姬',44.50,'冯友兰',2,89.00,'14709749513651'),(4,'鱼尾文',19.33,' 劳伦',1,19.33,'14709749513651'),(5,'苏东坡传4',19.30,'林语堂',2,38.60,'14709826419072'),(6,'百年孤独',29.50,'马尔克斯',2,59.00,'14709826419072'),(7,'扶桑',19.80,'严歌苓',2,39.60,'14709909441592'),(8,'给孩子的诗',22.20,'北岛',2,44.40,'14709909441592'),(9,'为奴十二年',16.50,'所罗门',2,33.00,'14709909441592'),(10,'平凡的世界',55.00,'路遥',2,110.00,'14709909441592'),(11,'百年孤独',29.50,'马尔克斯',23123,682128.50,'14709919901575'),(12,'提款姬',44.50,'冯友兰',2,89.00,'14709919901575'),(13,'鱼尾文',19.33,' 劳伦',1,19.33,'147105032109218'),(14,'苏东坡传4',19.30,'林语堂',1,19.30,'147105032109218'),(15,'百年孤独',29.50,'马尔克斯',1,29.50,'147105032109218'),(16,'苏东坡传4',19.30,'林语堂',2,38.60,'147105128146118'),(17,'百年孤独',29.50,'马尔克斯',2,59.00,'147105128146118'),(18,'提款姬',44.50,'冯友兰',100,4450.00,'147105156051918'),(19,'鱼尾文',19.33,' 劳伦',100,1933.00,'147105156051918'),(20,'苏东坡传4',19.30,'林语堂',100,1930.00,'147105156051918'),(21,'百年孤独',29.50,'马尔克斯',100,2950.00,'147105156051918'),(22,'提款姬',44.50,'冯友兰',100,4450.00,'147105157299118'),(23,'鱼尾文',19.33,' 劳伦',100,1933.00,'147105157299118'),(24,'苏东坡传4',19.30,'林语堂',100,1930.00,'147105157299118'),(25,'百年孤独',29.50,'马尔克斯',100,2950.00,'147105157299118'),(26,'提款姬',44.50,'冯友兰',95,4227.50,'147105165059218'),(27,'鱼尾文',19.33,' 劳伦',95,1836.35,'147105165059218'),(28,'苏东坡传4',19.30,'林语堂',95,1833.50,'147105165059218'),(29,'百年孤独',29.50,'马尔克斯',95,2802.50,'147105165059218'),(30,'鱼尾文',19.33,' 劳伦',2,38.66,'147105895731518'),(31,'鱼尾文',19.33,' 劳伦',3,57.99,'147106008239518'),(32,'鱼尾文',19.33,' 劳伦',2,38.66,'147106013632818'),(33,'鱼尾文',19.33,' 劳伦',3,57.99,'14762330544485'),(34,'从晚清到民国',39.90,'唐德刚',2,79.80,'14762373402035'),(35,'从晚清到民国',39.90,'唐德刚',2,79.80,'14762373402035'),(36,'鱼尾文',19.33,' 劳伦',2,38.66,'147623778723210'),(37,'鱼尾文',19.33,' 劳伦',2,38.66,'147623778723210'),(38,'给孩子的诗',22.20,'北岛',1,22.20,'14782240879339'),(39,'为奴十二年',16.50,'所罗门',1,16.50,'14782240879339'),(40,'小王子',19.20,'安托万',1,19.20,'14782281695649'),(41,'我们liang',11.30,'杨绛',1,11.30,'14782281695649'),(42,'鱼尾文',19.33,' 劳伦',2,38.66,'147822861131620'),(43,'从晚清到民国',39.90,'唐德刚',2,79.80,'147954500870710'),(44,'鱼尾文',19.33,' 劳伦',2,38.66,'147954689956531'),(45,'鱼尾文',19.33,' 劳伦',2,38.66,'14813523807322'),(46,'给孩子的诗',22.20,'北岛',2,44.40,'14813564445012');

/*Table structure for table `bs_user` */

DROP TABLE IF EXISTS `bs_user`;

CREATE TABLE `bs_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `bs_user` */

insert  into `bs_user`(`id`,`username`,`password`,`email`) values (1,'张三','123456','aa@qq.com'),(2,'admin666','123456',NULL),(5,'admin66','123456','aaa@qq.com'),(9,'cccccc','cccccc','cc@qq.com'),(10,'aaaaaa','123456','aa@qq.com'),(17,'askdfhafn','456123','sfds@163.com'),(18,'admin123','123456','qqq@qq.com'),(19,'leifengyang','123123123','55@qq.com'),(20,'hahaha','123456','15648@hotmail.com'),(21,'admin678','123456','qqq@qq.com'),(22,'admin6','123456','222@qq.com'),(23,'1','2','3'),(24,'2','2','3'),(25,'3','2','3'),(26,'4','2','3'),(27,'5','2','3'),(28,'6','2','3'),(29,'9','2','3'),(30,'qwerty','123456','asad@asd.com'),(31,'hhhhhh','123456',NULL),(32,'hahaha123','123456',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
