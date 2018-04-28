/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : bbgame_authority

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2018-04-03 11:52:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bbgame_resources
-- ----------------------------
DROP TABLE IF EXISTS `bbgame_resources`;
CREATE TABLE `bbgame_resources` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `delete_flag` varchar(4) DEFAULT 'NO' COMMENT '是否逻辑删除 (是:YES,否:NO)',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` bigint(20) DEFAULT NULL,
  `name` varchar(120) DEFAULT NULL COMMENT '资源名称',
  `type` varchar(120) DEFAULT NULL COMMENT '资源类型',
  `parentId` bigint(20) DEFAULT NULL COMMENT '父类id',
  `sort` varchar(8) DEFAULT NULL COMMENT '排序',
  `desc` bigint(20) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbgame_resources
-- ----------------------------

-- ----------------------------
-- Table structure for bbgame_role
-- ----------------------------
DROP TABLE IF EXISTS `bbgame_role`;
CREATE TABLE `bbgame_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `delete_flag` varchar(4) DEFAULT 'NO' COMMENT '是否逻辑删除 (是:YES,否:NO)',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` bigint(20) DEFAULT NULL,
  `name` bigint(20) DEFAULT NULL COMMENT '角色名称',
  `desc` bigint(20) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbgame_role
-- ----------------------------

-- ----------------------------
-- Table structure for bbgame_role_resources
-- ----------------------------
DROP TABLE IF EXISTS `bbgame_role_resources`;
CREATE TABLE `bbgame_role_resources` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `delete_flag` varchar(4) DEFAULT 'NO' COMMENT '是否逻辑删除 (是:YES,否:NO)',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` bigint(20) DEFAULT NULL,
  `roleId` varchar(120) DEFAULT NULL COMMENT '角色Id',
  `type` varchar(120) DEFAULT NULL COMMENT '资源类型',
  `parentId` bigint(20) DEFAULT NULL COMMENT '父类id',
  `desc` bigint(20) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbgame_role_resources
-- ----------------------------

-- ----------------------------
-- Table structure for bbgame_usr
-- ----------------------------
DROP TABLE IF EXISTS `bbgame_usr`;
CREATE TABLE `bbgame_usr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `delete_flag` varchar(4) DEFAULT 'NO' COMMENT '是否逻辑删除 (是:YES,否:NO)',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` bigint(20) DEFAULT NULL,
  `account` varchar(120) DEFAULT NULL COMMENT '玩家账号',
  `password` varchar(100) DEFAULT NULL COMMENT '设备号',
  `email` varchar(120) DEFAULT NULL COMMENT '注册邮箱',
  `mobile` varchar(30) DEFAULT NULL COMMENT '手机号码',
  `nick_name` varchar(150) DEFAULT NULL COMMENT '玩家昵称',
  `devUnique` varchar(30) DEFAULT NULL COMMENT '设备号',
  `ip` varchar(100) DEFAULT NULL COMMENT 'ip',
  `status` smallint(6) DEFAULT NULL COMMENT '状态',
  `uid` varchar(32) DEFAULT NULL COMMENT '唯一用户编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbgame_usr
-- ----------------------------

-- ----------------------------
-- Table structure for bbgame_usr_role
-- ----------------------------
DROP TABLE IF EXISTS `bbgame_usr_role`;
CREATE TABLE `bbgame_usr_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `delete_flag` varchar(4) DEFAULT 'NO' COMMENT '是否逻辑删除 (是:YES,否:NO)',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `version` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbgame_usr_role
-- ----------------------------
