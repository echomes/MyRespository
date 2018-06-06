/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-06-06 16:04:57
*/

SET FOREIGN_KEY_CHECKS=0;

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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '测试_0', '0', '2018-06-06 16:01:00');
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
