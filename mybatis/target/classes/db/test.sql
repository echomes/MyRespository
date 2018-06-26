/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-06-26 14:53:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `line`
-- ----------------------------
DROP TABLE IF EXISTS `line`;
CREATE TABLE `line` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '线名称',
  `from` varchar(100) DEFAULT NULL COMMENT '起始节点',
  `to` varchar(100) DEFAULT NULL COMMENT '结束节点',
  `time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '写入时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of line
-- ----------------------------
INSERT INTO `line` VALUES ('1', '线1', '1', '2', '2018-06-26 11:34:16');
INSERT INTO `line` VALUES ('2', '线2', '5', '1', '2018-06-26 14:30:09');
INSERT INTO `line` VALUES ('3', '线3', '2', '3', '2018-06-26 11:34:51');
INSERT INTO `line` VALUES ('4', '线4', '3', '4', '2018-06-26 14:29:55');
INSERT INTO `line` VALUES ('5', '线5', '4', '5', '2018-06-26 14:29:28');

-- ----------------------------
-- Table structure for `node`
-- ----------------------------
DROP TABLE IF EXISTS `node`;
CREATE TABLE `node` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '节点名称',
  `x` float DEFAULT NULL COMMENT 'x坐标',
  `y` float DEFAULT NULL COMMENT 'y坐标',
  `time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '写入时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of node
-- ----------------------------
INSERT INTO `node` VALUES ('1', '节点1', '-127', '-75', '2018-06-26 14:35:44');
INSERT INTO `node` VALUES ('2', '节点2', '-125', '75', '2018-06-26 14:36:08');
INSERT INTO `node` VALUES ('3', '节点3', '30', '109', '2018-06-26 14:36:34');
INSERT INTO `node` VALUES ('4', '节点4', '142', '19', '2018-06-26 14:36:53');
INSERT INTO `node` VALUES ('5', '节点5', '54', '-116', '2018-06-26 14:37:15');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL DEFAULT 'user_default',
  `age` int(11) DEFAULT NULL,
  `birth` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '11111', '145', '2018-06-06 16:01:00');
INSERT INTO `user` VALUES ('2', '测试_1', '1', '2018-06-06 16:01:00');
INSERT INTO `user` VALUES ('3', '测试_2', '2', '2018-06-06 16:01:00');
INSERT INTO `user` VALUES ('4', '测试_3', '3', '2018-06-06 16:01:00');
INSERT INTO `user` VALUES ('5', '测试_4', '4', '2018-06-06 16:01:00');
INSERT INTO `user` VALUES ('6', '测试_5', '5', '2018-06-06 16:01:00');
INSERT INTO `user` VALUES ('7', '测试_6', '6', '2018-06-06 16:01:00');
INSERT INTO `user` VALUES ('8', '测试_7', '7', '2018-06-06 16:01:00');
INSERT INTO `user` VALUES ('9', '测试_8', '8', '2018-06-06 16:01:00');
INSERT INTO `user` VALUES ('10', '测试_9', '9', '2018-06-06 16:01:00');
INSERT INTO `user` VALUES ('11', '测试_10', '10', '2018-06-06 16:01:00');
INSERT INTO `user` VALUES ('12', '测试_11', '11', '2018-06-06 16:01:00');
INSERT INTO `user` VALUES ('13', '测试_12', '12', '2018-06-06 16:01:00');
INSERT INTO `user` VALUES ('14', '测试_13', '13', '2018-06-06 16:01:00');
INSERT INTO `user` VALUES ('15', '测试_14', '14', '2018-06-06 16:01:00');
INSERT INTO `user` VALUES ('16', '测试_15', '15', '2018-06-06 16:01:00');
INSERT INTO `user` VALUES ('17', '测试_16', '16', '2018-06-06 16:01:00');
INSERT INTO `user` VALUES ('18', '测试_17', '17', '2018-06-06 16:01:00');
INSERT INTO `user` VALUES ('19', '测试_18', '18', '2018-06-06 16:01:00');
INSERT INTO `user` VALUES ('20', '测试_19', '19', '2018-06-06 16:01:00');
INSERT INTO `user` VALUES ('21', 'aaa', '154', '2018-06-07 10:30:02');
INSERT INTO `user` VALUES ('22', 'testaaaa', '1452', '2018-06-07 10:32:46');
INSERT INTO `user` VALUES ('23', 'aaa', '145', '2018-06-07 14:12:55');
INSERT INTO `user` VALUES ('24', 'bbb', '14514', '2018-06-07 14:12:55');
INSERT INTO `user` VALUES ('25', 'aaa', '145', '2018-06-07 14:13:52');
INSERT INTO `user` VALUES ('26', 'bbb', '14514', '2018-06-07 14:13:52');

-- ----------------------------
-- Procedure structure for `addUser`
-- ----------------------------
DROP PROCEDURE IF EXISTS `addUser`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addUser`(IN `name` varchar(20),IN `age` int)
BEGIN
	INSERT INTO user(name,age,birth) VALUES(name,age,NOW());

END
;;
DELIMITER ;
