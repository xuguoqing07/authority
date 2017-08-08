/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : auth

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-08-03 13:44:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for a_admins
-- ----------------------------
DROP TABLE IF EXISTS `a_admins`;
CREATE TABLE `a_admins` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roleId` int(11) DEFAULT NULL COMMENT '角色Id',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱(默认按照邮箱登陆)',
  `password` varchar(255) DEFAULT NULL COMMENT '密码,(加密,sha256)',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `trueName` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `qq` varchar(255) DEFAULT NULL COMMENT 'qq号',
  `loginCount` int(11) DEFAULT NULL COMMENT '登陆次数',
  `lastLoginIp` varchar(255) DEFAULT NULL COMMENT '上次登陆IP',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态:0:禁用,1:启用',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `lastLoginTime` datetime DEFAULT NULL COMMENT '上次登陆时间',
  PRIMARY KEY (`id`),
  KEY `fk_roleid` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='管理员表';

-- ----------------------------
-- Records of a_admins
-- ----------------------------

-- ----------------------------
-- Table structure for a_menu
-- ----------------------------
DROP TABLE IF EXISTS `a_menu`;
CREATE TABLE `a_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parentId` int(11) DEFAULT NULL COMMENT '上一级菜单的ID(树形结构)',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `url` varchar(255) DEFAULT NULL COMMENT 'url:存储的是菜单对应的url的一部分(项目名以后内容)',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `leafStatus` tinyint(4) DEFAULT NULL COMMENT '叶子状态:0:非叶子节点,1:叶子节点;(叶子:木有子节点)',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态:0:禁用,1:启用',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `pubTime` datetime DEFAULT NULL COMMENT '发布时间(用来排序)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='菜单表';

-- ----------------------------
-- Records of a_menu
-- ----------------------------

-- ----------------------------
-- Table structure for a_role
-- ----------------------------
DROP TABLE IF EXISTS `a_role`;
CREATE TABLE `a_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态:0:禁用,1:启用',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `pubTime` datetime DEFAULT NULL COMMENT '发布时间(用来排序)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表_模板表';

-- ----------------------------
-- Records of a_role
-- ----------------------------

-- ----------------------------
-- Table structure for a_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `a_role_menu`;
CREATE TABLE `a_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roleId` int(11) DEFAULT NULL COMMENT '名称',
  `menuId` int(11) DEFAULT NULL COMMENT '内容',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态:0:禁用,1:启用',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `pubTime` datetime DEFAULT NULL COMMENT '发布时间(用来排序)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色_菜单表(多对多)';

-- ----------------------------
-- Records of a_role_menu
-- ----------------------------
SET FOREIGN_KEY_CHECKS=1;
