/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : stock

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2016-05-16 00:47:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bill_pairing
-- ----------------------------
DROP TABLE IF EXISTS `bill_pairing`;
CREATE TABLE `bill_pairing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stockCode` varchar(255) DEFAULT NULL,
  `stockName` varchar(255) DEFAULT NULL,
  `organization` varchar(255) DEFAULT NULL,
  `buyDate` date DEFAULT NULL,
  `buyPrice` decimal(11,2) DEFAULT NULL,
  `buyAmount` decimal(11,2) DEFAULT NULL,
  `buyPiece` decimal(11,2) DEFAULT NULL,
  `sellDate` date DEFAULT NULL,
  `sellPrice` decimal(11,2) DEFAULT NULL,
  `sellAmount` decimal(11,2) DEFAULT NULL,
  `sellPiece` decimal(11,2) DEFAULT NULL,
  `priceRange` decimal(11,3) DEFAULT NULL,
  `days` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for paybill
-- ----------------------------
DROP TABLE IF EXISTS `paybill`;
CREATE TABLE `paybill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stockCode` varchar(255) DEFAULT NULL,
  `stockName` varchar(255) DEFAULT NULL,
  `organization` varchar(255) DEFAULT NULL,
  `buyDate` date DEFAULT NULL,
  `buyPrice` decimal(11,2) DEFAULT NULL,
  `buyAmount` decimal(11,2) DEFAULT NULL,
  `buyPiece` decimal(11,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `date` (`buyDate`),
  KEY `organization` (`organization`),
  KEY `stockcode` (`stockCode`)
) ENGINE=InnoDB AUTO_INCREMENT=32780 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sellorder
-- ----------------------------
DROP TABLE IF EXISTS `sellorder`;
CREATE TABLE `sellorder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stockCode` varchar(255) DEFAULT NULL,
  `stockName` varchar(255) DEFAULT NULL,
  `organization` varchar(255) DEFAULT NULL,
  `sellDate` date DEFAULT NULL,
  `sellPrice` decimal(11,2) DEFAULT NULL,
  `sellAmount` decimal(11,2) DEFAULT NULL,
  `sellPiece` decimal(11,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `date` (`sellDate`),
  KEY `organization` (`organization`),
  KEY `selldate` (`sellDate`)
) ENGINE=InnoDB AUTO_INCREMENT=16397 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for stock_trace
-- ----------------------------
DROP TABLE IF EXISTS `stock_trace`;
CREATE TABLE `stock_trace` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stockName` varchar(255) DEFAULT NULL,
  `stockCode` varchar(255) DEFAULT NULL,
  `organization` varchar(255) DEFAULT NULL,
  `buyDate` date DEFAULT NULL,
  `buyPrice` decimal(10,2) DEFAULT NULL,
  `buySize` int(11) DEFAULT NULL,
  `sellDate` date DEFAULT NULL,
  `sellPrice` decimal(10,2) DEFAULT NULL,
  `sellSize` int(11) DEFAULT NULL,
  `range` double(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `stock_code_index` (`stockCode`),
  KEY `organization_index` (`organization`)
) ENGINE=InnoDB AUTO_INCREMENT=33499 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for topbill
-- ----------------------------
DROP TABLE IF EXISTS `topbill`;
CREATE TABLE `topbill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stockName` varchar(255) DEFAULT NULL,
  `stockCode` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `openingPrice` decimal(10,2) DEFAULT NULL,
  `closingPrice` decimal(10,2) DEFAULT NULL,
  `change` decimal(10,2) DEFAULT NULL,
  `organization` varchar(255) DEFAULT NULL,
  `buyAmount` decimal(10,2) DEFAULT NULL,
  `buyPercent` varchar(255) DEFAULT NULL,
  `sellAmount` decimal(10,2) DEFAULT NULL,
  `sellPercent` varchar(255) DEFAULT NULL,
  `netAmount` decimal(10,2) DEFAULT NULL,
  `turnover` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orgnization` (`organization`),
  KEY `stockcode` (`stockCode`)
) ENGINE=InnoDB AUTO_INCREMENT=305573 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ts_version
-- ----------------------------
DROP TABLE IF EXISTS `ts_version`;
CREATE TABLE `ts_version` (
  `id` int(11) NOT NULL,
  `ts` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- View structure for seller
-- ----------------------------
DROP VIEW IF EXISTS `seller`;
CREATE ALGORITHM=UNDEFINED DEFINER=``@`` SQL SECURITY DEFINER  VIEW `seller` AS select `topbill_price`.`id` AS `id`,`topbill_price`.`stockName` AS `stockName`,`topbill_price`.`stockCode` AS `stockCode`,`topbill_price`.`date` AS `date`,`topbill_price`.`closingPrice` AS `closingPrice`,`topbill_price`.`openingPrice` AS `openingPrice`,`topbill_price`.`change` AS `change`,`topbill_price`.`organization` AS `organization`,`topbill_price`.`buyAmount` AS `buyAmount`,`topbill_price`.`buyPercent` AS `buyPercent`,`topbill_price`.`sellAmount` AS `sellAmount`,`topbill_price`.`sellPercent` AS `sellPercent`,`topbill_price`.`netAmount` AS `netAmount`,`topbill_price`.`turnover` AS `turnover`,`topbill_price`.`price` AS `price` from `topbill_price` where (`topbill_price`.`organization` <> '机构专用') ;
