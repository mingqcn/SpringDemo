-- MySQL dump 10.13  Distrib 5.7.28, for Linux (x86_64)
--
-- Host: 47.52.88.176    Database: oomall
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart_item`
--

DROP TABLE IF EXISTS `cart_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_item`
--

/*!40000 ALTER TABLE `cart_item` DISABLE KEYS */;
INSERT INTO `cart_item` VALUES (1,2,'2019-11-24 18:22:31',NULL,1,1),(2,3,'2019-11-24 18:22:49',NULL,1,2);
/*!40000 ALTER TABLE `cart_item` ENABLE KEYS */;


--
-- Table structure for table `coupon`
--

DROP TABLE IF EXISTS `coupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `coupon_sn` varchar(40) DEFAULT NULL,
  `begin_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `be_deleted` tinyint(1) DEFAULT NULL,
  `coupon_rule_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupon`
--


/*!40000 ALTER TABLE `coupon` DISABLE KEYS */;
INSERT INTO `coupon` VALUES (1,'SF0001','2019-11-23 21:25:37','2019-12-23 21:25:44',0,'2019-11-23 21:26:03',NULL,0,1),(2,'SF0002','2019-12-24 13:32:33','2020-11-24 13:32:44',0,'2019-11-24 13:32:55',NULL,0,1),(3,'SF0003','2019-10-24 13:34:18','2019-11-23 13:34:27',0,'2019-11-24 13:34:35',NULL,0,2),(4,'SF0004','2019-11-24 13:35:16','2019-12-24 13:35:21',1,'2019-11-24 13:35:31',NULL,0,2);
/*!40000 ALTER TABLE `coupon` ENABLE KEYS */;

--
-- Table structure for table `coupon_rule`
--

DROP TABLE IF EXISTS `coupon_rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coupon_rule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `descr` varchar(5000) DEFAULT NULL,
  `begin_time` datetime DEFAULT NULL,
  `pic_url` varchar(255) DEFAULT NULL,
  `brief` varchar(10) DEFAULT NULL,
  `valid_period` int(11) DEFAULT NULL,
  `goods_ids1` varchar(5000) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `be_deleted` tinyint(1) DEFAULT NULL,
  `strategy` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coupon_rule`
--


/*!40000 ALTER TABLE `coupon_rule` DISABLE KEYS */;
INSERT INTO `coupon_rule` VALUES (1,'测试优惠卷1',NULL,'2019-11-23 21:28:30',NULL,NULL,1,'{"gIDs":[1,2]}','2019-11-23 21:28:39',NULL,0,'{"name":"xmu.oomall.domain.coupon.CashOffStrategy","obj":{"threshold":1000.01,"offCash":10.01}}'),(2,'测试优惠卷2',NULL,'2019-11-24 13:36:25',NULL,NULL,4,'{"gIDs":[1]}','2019-11-24 13:36:43',NULL,0,'{"name":"xmu.oomall.domain.coupon.PercentageStrategy","obj":{"threshold":99.01,"percentage":0.9}}');
/*!40000 ALTER TABLE `coupon_rule` ENABLE KEYS */;


--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_sn` varchar(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `short_name` varchar(50) DEFAULT NULL,
  `english_name` varchar(50) DEFAULT NULL,
  `bar_code` varchar(30) DEFAULT NULL,
  `stock_unit` varchar(10) DEFAULT NULL,
  `length` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `gross_weight` int(11) DEFAULT NULL,
  `net_weight` int(11) DEFAULT NULL,
  `category_name` varchar(100) DEFAULT NULL,
  `brand_name` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `be_new` int(11) DEFAULT NULL,
  `be_hot` int(11) DEFAULT NULL,
  `gallery` varchar(5000) DEFAULT NULL,
  `brief` varchar(500) DEFAULT NULL,
  `pic_url` varchar(100) DEFAULT NULL,
  `share_url` varchar(100) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `be_deleted` int(11) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `brand_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--


/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,'G001','测试商品1','测试商品短名1','English name 1','111111111111','台',10,10,10,10,9,'分类1','品牌1',1,0,0,'从v ','尺寸','','','2019-11-24 23:45:21',NULL,0,1,1),(2,'G002','测试商品2','测试商品短名2','English Name 2','222222222222','条',20,20,20,20,19,'分类2','品牌2',1,1,1,'烦烦烦','订单',NULL,NULL,'2019-11-24 23:45:25',NULL,NULL,1,1);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;


--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `consignee` varchar(50) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `good_price` decimal(10,0) DEFAULT NULL,
  `coupon_price` decimal(10,0) DEFAULT NULL,
  `freight_price` decimal(10,0) DEFAULT NULL,
  `integral_price` decimal(10,0) DEFAULT NULL,
  `ship_sn` varchar(20) DEFAULT NULL,
  `ship_channel` varchar(255) DEFAULT NULL,
  `ship_time` datetime DEFAULT NULL,
  `confirm_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `address_detail` varchar(255) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `be_deleted` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--


/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;


--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_sn` varchar(50) DEFAULT NULL,
  `product_property` varchar(255) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `retail_price` decimal(10,0) DEFAULT NULL,
  `purchase_price` decimal(10,0) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `be_deleted` int(11) DEFAULT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--


/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'P001',NULL,10,100,99,'2019-11-24 18:20:45',NULL,0,1),(2,'P002',NULL,11,101,100,'2019-11-24 18:21:39',NULL,0,2);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-24 23:59:58
