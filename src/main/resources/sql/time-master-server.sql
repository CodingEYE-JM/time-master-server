/*
 Source Server         : 
 Source Server Type    : MySQL
 Source Server Version : 5.7.18
 Source Host           : 
 Source Database       : time_master

 Target Server Type    : MySQL
 Target Server Version : 5.7.18
 File Encoding         : utf-8

 Date: 06/03/2017
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `tm_user`
-- ----------------------------
DROP TABLE IF EXISTS `tm_user`;
CREATE TABLE `tm_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '用户密码，MD5加密',
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `type` varchar(20) NOT NULL COMMENT '用户类型',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `tm_user`
-- ----------------------------
BEGIN;
INSERT INTO `tm_user` VALUES ('1', 'admin', '427338237BD929443EC5D48E24FD2B1A', 'admin@admin.com', '13500135000', 'ALL', now(), now()),('2', 'eater', '72F622A7171133BADE8C904EFFD40882', 'eater@eater.com', '13500135001', 'EATER', now(), now()),('3', 'learner', 'C0A24B98E089B6B0F5D3674430CEBE0C', 'learner@learner.com', '13500135002', 'LEARNER', now(), now());
COMMIT;

-- ----------------------------
--  Table structure for `tm_activity`
-- ----------------------------
DROP TABLE IF EXISTS `tm_activity`;
CREATE TABLE `tm_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '活动表id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `active_date` datetime NOT NULL COMMENT '活动时间',
  `eating` tinyint(1) DEFAULT false COMMENT '吃饭',
  `learning` tinyint(1) DEFAULT false COMMENT '学习',
  `sports` tinyint(1) DEFAULT false COMMENT '运动',
  `working` tinyint(1) DEFAULT false COMMENT '工作',
  `sleeping` tinyint(1) DEFAULT false COMMENT '睡觉',
  `reading` tinyint(1) DEFAULT false COMMENT '读书',
  `playing` tinyint(1) DEFAULT false COMMENT '玩耍',
  `shopping` tinyint(1) DEFAULT false COMMENT '购物',            
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `activity_user_active_date_index` (`username`,`active_date`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `tm_activity`
-- ----------------------------
BEGIN;
INSERT INTO `tm_activity` VALUES ('1', 'eater', now(), true, false, false, false, false, false, false, false, now(), now()),('2', 'learner', now(), false, true, false, false, false, false, false, false, now(), now());
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
