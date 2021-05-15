/*
Navicat MySQL Data Transfer

Source Server         : 182.61.52.221_3306
Source Server Version : 50733
Source Host           : 182.61.52.221:3306
Source Database       : LioveeCommunity

Target Server Type    : MYSQL
Target Server Version : 50733
File Encoding         : 65001

Date: 2021-05-15 19:28:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_apartment
-- ----------------------------
DROP TABLE IF EXISTS `t_apartment`;
CREATE TABLE `t_apartment` (
  `apartment_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '出租Id',
  `contacts` varchar(10) DEFAULT NULL COMMENT '联系人',
  `room_num` varchar(5) DEFAULT NULL COMMENT '房间号',
  `phone_num` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `intentional_lessor` varchar(20) DEFAULT NULL COMMENT '意向出租人',
  `status` int(1) DEFAULT NULL COMMENT '1未租2已租3到期4已被选',
  `month_rent` double DEFAULT NULL COMMENT '月租',
  `rent_time` int(11) DEFAULT NULL COMMENT '欲租时长',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `url` varchar(255) DEFAULT NULL COMMENT '文件存储路径',
  PRIMARY KEY (`apartment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_docking
-- ----------------------------
DROP TABLE IF EXISTS `t_docking`;
CREATE TABLE `t_docking` (
  `docking_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '对接Id',
  `applicant` varchar(20) DEFAULT NULL COMMENT '请求人',
  `applicant_phone` varchar(20) DEFAULT NULL COMMENT '请求的电话号码',
  `helper` varchar(20) DEFAULT NULL COMMENT '帮扶者',
  `helper_phone` varchar(20) DEFAULT NULL COMMENT '帮扶者电话号码',
  `helper_type` varchar(10) DEFAULT NULL COMMENT '帮扶类型',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `comtent` varchar(255) DEFAULT NULL COMMENT '评价',
  PRIMARY KEY (`docking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_help
-- ----------------------------
DROP TABLE IF EXISTS `t_help`;
CREATE TABLE `t_help` (
  `help_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '请求ID',
  `tags` varchar(20) DEFAULT NULL COMMENT '请求类型 1卫生2绿化3治安4文化5医疗6社交7民主8教育9生活',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `content` varchar(255) DEFAULT NULL COMMENT '请求内容',
  `help_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '请求帮助时间',
  `give_user_id` bigint(20) unsigned zerofill DEFAULT NULL COMMENT '给予帮助人Id',
  `appointment_time` datetime DEFAULT NULL COMMENT '预约时间',
  PRIMARY KEY (`help_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `message_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '信息Id',
  `content` text COMMENT '请求信息',
  `publish_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  `user_id` bigint(10) DEFAULT NULL COMMENT '发布者',
  `file_path` varchar(255) DEFAULT NULL COMMENT '文件地址',
  `flag` int(2) DEFAULT NULL COMMENT '插入1社区/2企业信息',
  `company` varchar(20) DEFAULT NULL COMMENT '公司名称',
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `phone_num` varchar(11) NOT NULL COMMENT '手机号码',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `user_name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `home_address` varchar(50) DEFAULT NULL COMMENT '家庭住址',
  `remain` decimal(10,2) DEFAULT NULL COMMENT '余额',
  `rights` int(2) DEFAULT NULL COMMENT '角色1管理员 2普通用户',
  `remain_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '充值时间',
  `birth` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '出生日期',
  `idCard` varchar(255) DEFAULT NULL COMMENT '身份证号码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
