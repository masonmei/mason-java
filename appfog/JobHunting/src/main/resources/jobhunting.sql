/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.100
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : 192.168.1.100
 Source Database       : jobhunting

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : utf-8

 Date: 10/27/2012 23:01:28 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `company`
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(100) NOT NULL,
  `provice` varchar(20) NOT NULL,
  `city` varchar(20) DEFAULT NULL,
  `business_type` varchar(50) DEFAULT NULL,
  `scale` int(11) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `company_label`
-- ----------------------------
DROP TABLE IF EXISTS `company_label`;
CREATE TABLE `company_label` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `company_id` bigint(20) NOT NULL,
  `label_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `companyid` (`company_id`),
  KEY `labelid` (`label_id`),
  CONSTRAINT `companyid` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  CONSTRAINT `labelid` FOREIGN KEY (`label_id`) REFERENCES `label` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `interview`
-- ----------------------------
DROP TABLE IF EXISTS `interview`;
CREATE TABLE `interview` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `interview_name` varchar(100) NOT NULL,
  `date` datetime NOT NULL,
  `location` varchar(500) DEFAULT NULL,
  `notes` varchar(1000) DEFAULT NULL,
  `contact_info` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `interview_material`
-- ----------------------------
DROP TABLE IF EXISTS `interview_material`;
CREATE TABLE `interview_material` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `weight` int(11) NOT NULL,
  `question` varchar(1000) NOT NULL,
  `answer` varchar(1000) DEFAULT NULL,
  `add_date` datetime DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `job`
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `job_title` varchar(100) NOT NULL,
  `company_id` bigint(20) NOT NULL,
  `publish_date` datetime DEFAULT NULL,
  `required_tech` varchar(255) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`),
  KEY `jobcompany` (`company_id`),
  CONSTRAINT `jobcompany` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `label`
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `label_name` varchar(50) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `company_id` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  `content` text NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `newscompany` (`company_id`),
  CONSTRAINT `newscompany` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `offer`
-- ----------------------------
DROP TABLE IF EXISTS `offer`;
CREATE TABLE `offer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `offer_name` varchar(100) NOT NULL,
  `received_date` date NOT NULL,
  `work_date` date DEFAULT NULL,
  `salary` int(11) NOT NULL,
  `salary_description` text,
  `company` varchar(255) NOT NULL,
  `workplace` varchar(255) NOT NULL,
  `note` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) NOT NULL,
  `company_id` bigint(20) NOT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `short_desc` varchar(255) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`),
  KEY `productcompany` (`company_id`),
  KEY `productcategory` (`category_id`),
  CONSTRAINT `productcategory` FOREIGN KEY (`category_id`) REFERENCES `product_category` (`id`) ON DELETE SET NULL,
  CONSTRAINT `productcompany` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `product_category`
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(100) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parentcategory` (`parent_id`),
  CONSTRAINT `parentcategory` FOREIGN KEY (`parent_id`) REFERENCES `product_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `email` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
