/*
 Navicat Premium Data Transfer

 Source Server         : docker
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : 65001

 Date: 21/07/2022 20:03:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for DataBaseConfigs
-- ----------------------------
DROP TABLE IF EXISTS `DataBaseConfigs`;
CREATE TABLE `DataBaseConfigs`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `driverClassName` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '驱动类名',
  `url` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '连接地址',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
  `connectorType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Sql` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `port` int(15) NULL DEFAULT NULL,
  `tablename` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `basename` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of DataBaseConfigs
-- ----------------------------
INSERT INTO `DataBaseConfigs` VALUES (23, 'mysql.jdbc.driver', '192.168.10.1', 'root', '123456', '123', NULL, 3306, 'click', 'test');
INSERT INTO `DataBaseConfigs` VALUES (24, 'com.mysql', '192.168.73', 'nidefuqin', '123456', NULL, 'abababab', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for Hdfs
-- ----------------------------
DROP TABLE IF EXISTS `Hdfs`;
CREATE TABLE `Hdfs`  (
  `Url` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of Hdfs
-- ----------------------------
INSERT INTO `Hdfs` VALUES ('192.168.10.11231234', 9, 'json');
INSERT INTO `Hdfs` VALUES ('192.168.10.11231234', 10, 'csv');

-- ----------------------------
-- Table structure for KaFKA
-- ----------------------------
DROP TABLE IF EXISTS `KaFKA`;
CREATE TABLE `KaFKA`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `Url` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'Url',
  `port` int(11) NULL DEFAULT NULL COMMENT '端口号',
  `Topic` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主题',
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of KaFKA
-- ----------------------------
INSERT INTO `KaFKA` VALUES (19, 'hadoop102', 9092, 'kfkSQL');
INSERT INTO `KaFKA` VALUES (20, 'hadoop102', 9092, 'kfkPort');
INSERT INTO `KaFKA` VALUES (21, '192.168.10.11231234', 9092, 'ad');

-- ----------------------------
-- Table structure for Sockets
-- ----------------------------
DROP TABLE IF EXISTS `Sockets`;
CREATE TABLE `Sockets`  (
  `Port` int(11) NULL DEFAULT NULL,
  `Url` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of Sockets
-- ----------------------------
INSERT INTO `Sockets` VALUES (667, '192.168.10.11231234', 1);
INSERT INTO `Sockets` VALUES (111, '192.168.10.11231234', 5);

-- ----------------------------
-- Table structure for jobflow
-- ----------------------------
DROP TABLE IF EXISTS `jobflow`;
CREATE TABLE `jobflow`  (
  `jobid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `jsondata` varchar(5255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jobjson` varchar(5255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`jobid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of jobflow
-- ----------------------------
INSERT INTO `jobflow` VALUES ('01d6ed9ba6d646d0acfa66380aacd47f', '{\"dragbody_operation\":[],\"dragbody_list\":[{\"id\":\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":238.381,\"left\":160.7,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},{\"id\":\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":649.762,\"left\":228.7,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"}],\"linklist\":[{\"source\":\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\",\"target\":\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\"}],\"bodymap\":{\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\":{\"id\":\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":238.381,\"left\":160.7,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\":{\"id\":\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":649.762,\"left\":228.7,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"}},\"bodybaseinfo\":{\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\":{\"types\":\"kafka\",\"port\":9092,\"id\":20,\"url\":\"hadoop102\",\"topic\":\"kfkPort\"},\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"}},\"opcodeinfo\":{}}', '[{\"operators\":[],\"source\":{\"types\":\"kafka\",\"port\":9092,\"id\":20,\"url\":\"hadoop102\",\"topic\":\"kfkPort\"},\"dest\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"}}]');
INSERT INTO `jobflow` VALUES ('0a25c0bf8c4347c9b8fd2980589392eb', '{\"dragbody_operation\":[{\"id\":\"79643600-dbef-11ec-bb16-614b09b3ac18\",\"name\":\"testname\",\"top\":609.391,\"left\":178,\"opcode\":\"映算子\",\"sourcetype\":\"operation\"},{\"id\":\"79dac590-dbef-11ec-bb16-614b09b3ac18\",\"name\":\"testname\",\"top\":496.391,\"left\":453,\"opcode\":\"滤算子\",\"sourcetype\":\"operation\"}],\"dragbody_list\":[{\"id\":\"76d88210-dbef-11ec-bb16-614b09b3ac18\",\"name\":\"testname\",\"top\":148.391,\"left\":108,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},{\"id\":\"781dfa60-dbef-11ec-bb16-614b09b3ac18\",\"name\":\"testname\",\"top\":475.391,\"left\":885,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"}],\"linklist\":[{\"source\":\"76d88210-dbef-11ec-bb16-614b09b3ac18\",\"target\":\"79643600-dbef-11ec-bb16-614b09b3ac18\"},{\"source\":\"79643600-dbef-11ec-bb16-614b09b3ac18\",\"target\":\"79dac590-dbef-11ec-bb16-614b09b3ac18\"},{\"source\":\"79dac590-dbef-11ec-bb16-614b09b3ac18\",\"target\":\"781dfa60-dbef-11ec-bb16-614b09b3ac18\"}],\"bodymap\":{\"76d88210-dbef-11ec-bb16-614b09b3ac18\":{\"id\":\"76d88210-dbef-11ec-bb16-614b09b3ac18\",\"name\":\"testname\",\"top\":148.391,\"left\":108,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},\"781dfa60-dbef-11ec-bb16-614b09b3ac18\":{\"id\":\"781dfa60-dbef-11ec-bb16-614b09b3ac18\",\"name\":\"testname\",\"top\":475.391,\"left\":885,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"},\"79643600-dbef-11ec-bb16-614b09b3ac18\":{\"id\":\"79643600-dbef-11ec-bb16-614b09b3ac18\",\"name\":\"testname\",\"top\":609.391,\"left\":178,\"opcode\":\"映算子\",\"sourcetype\":\"operation\"},\"79dac590-dbef-11ec-bb16-614b09b3ac18\":{\"id\":\"79dac590-dbef-11ec-bb16-614b09b3ac18\",\"name\":\"testname\",\"top\":496.391,\"left\":453,\"opcode\":\"滤算子\",\"sourcetype\":\"operation\"}},\"bodybaseinfo\":{\"76d88210-dbef-11ec-bb16-614b09b3ac18\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"},\"781dfa60-dbef-11ec-bb16-614b09b3ac18\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"}},\"opcodeinfo\":{\"79643600-dbef-11ec-bb16-614b09b3ac18\":{\"type\":\"OpMap\",\"key\":\"1\"},\"79dac590-dbef-11ec-bb16-614b09b3ac18\":{\"type\":\"OpFilt\",\"key\":\"123\"}}}', '[{\"operators\":[{\"type\":\"OpMap\",\"key\":\"1\"},{\"type\":\"OpFilt\",\"key\":\"123\"}],\"source\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"},\"dest\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"}}]');
INSERT INTO `jobflow` VALUES ('1fec94088d3d6b13f4724532b6b8b7ab', '{\"dragbody_operation\":[],\"dragbody_list\":[{\"id\":\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":238.381,\"left\":160.7,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},{\"id\":\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":649.762,\"left\":228.7,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"}],\"linklist\":[{\"source\":\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\",\"target\":\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\"}],\"bodymap\":{\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\":{\"id\":\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":238.381,\"left\":160.7,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\":{\"id\":\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":649.762,\"left\":228.7,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"}},\"bodybaseinfo\":{\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\":{\"types\":\"kafka\",\"port\":9092,\"id\":20,\"url\":\"hadoop102\",\"topic\":\"kfkPort\"},\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"}},\"opcodeinfo\":{}}', '[{\"operators\":[],\"source\":{\"types\":\"kafka\",\"port\":9092,\"id\":20,\"url\":\"hadoop102\",\"topic\":\"kfkPort\"},\"dest\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"}}]');
INSERT INTO `jobflow` VALUES ('621ffd334ee0d2896d78e92acd38ed79', '{\"dragbody_operation\":[],\"dragbody_list\":[{\"id\":\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":238.381,\"left\":160.7,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},{\"id\":\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":649.762,\"left\":228.7,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"}],\"linklist\":[{\"source\":\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\",\"target\":\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\"}],\"bodymap\":{\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\":{\"id\":\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":238.381,\"left\":160.7,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\":{\"id\":\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":649.762,\"left\":228.7,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"}},\"bodybaseinfo\":{\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\":{\"types\":\"kafka\",\"port\":9092,\"id\":20,\"url\":\"hadoop102\",\"topic\":\"kfkPort\"},\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"}},\"opcodeinfo\":{}}', '[{\"operators\":[],\"source\":{\"types\":\"kafka\",\"port\":9092,\"id\":20,\"url\":\"hadoop102\",\"topic\":\"kfkPort\"},\"dest\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"}}]');
INSERT INTO `jobflow` VALUES ('6a65c30f2102661c5a735535daf9f2a1', '{\"dragbody_operation\":[],\"dragbody_list\":[{\"id\":\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":238.381,\"left\":160.7,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},{\"id\":\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":649.762,\"left\":228.7,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"}],\"linklist\":[{\"source\":\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\",\"target\":\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\"}],\"bodymap\":{\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\":{\"id\":\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":238.381,\"left\":160.7,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\":{\"id\":\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":649.762,\"left\":228.7,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"}},\"bodybaseinfo\":{\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\":{\"types\":\"kafka\",\"port\":9092,\"id\":20,\"url\":\"hadoop102\",\"topic\":\"kfkPort\"},\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"}},\"opcodeinfo\":{}}', '[{\"operators\":[],\"source\":{\"types\":\"kafka\",\"port\":9092,\"id\":20,\"url\":\"hadoop102\",\"topic\":\"kfkPort\"},\"dest\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"}}]');
INSERT INTO `jobflow` VALUES ('76d9489810e5c4aeab6201fa756f0b3f', '{\"dragbody_operation\":[{\"id\":\"79643600-dbef-11ec-bb16-614b09b3ac18\",\"name\":\"testname\",\"top\":609.391,\"left\":178,\"opcode\":\"映算子\",\"sourcetype\":\"operation\"},{\"id\":\"79dac590-dbef-11ec-bb16-614b09b3ac18\",\"name\":\"testname\",\"top\":496.391,\"left\":453,\"opcode\":\"滤算子\",\"sourcetype\":\"operation\"}],\"dragbody_list\":[{\"id\":\"76d88210-dbef-11ec-bb16-614b09b3ac18\",\"name\":\"testname\",\"top\":148.391,\"left\":108,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},{\"id\":\"781dfa60-dbef-11ec-bb16-614b09b3ac18\",\"name\":\"testname\",\"top\":475.391,\"left\":885,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"}],\"linklist\":[{\"source\":\"76d88210-dbef-11ec-bb16-614b09b3ac18\",\"target\":\"79643600-dbef-11ec-bb16-614b09b3ac18\"},{\"source\":\"79643600-dbef-11ec-bb16-614b09b3ac18\",\"target\":\"79dac590-dbef-11ec-bb16-614b09b3ac18\"},{\"source\":\"79dac590-dbef-11ec-bb16-614b09b3ac18\",\"target\":\"781dfa60-dbef-11ec-bb16-614b09b3ac18\"}],\"bodymap\":{\"76d88210-dbef-11ec-bb16-614b09b3ac18\":{\"id\":\"76d88210-dbef-11ec-bb16-614b09b3ac18\",\"name\":\"testname\",\"top\":148.391,\"left\":108,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},\"781dfa60-dbef-11ec-bb16-614b09b3ac18\":{\"id\":\"781dfa60-dbef-11ec-bb16-614b09b3ac18\",\"name\":\"testname\",\"top\":475.391,\"left\":885,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"},\"79643600-dbef-11ec-bb16-614b09b3ac18\":{\"id\":\"79643600-dbef-11ec-bb16-614b09b3ac18\",\"name\":\"testname\",\"top\":609.391,\"left\":178,\"opcode\":\"映算子\",\"sourcetype\":\"operation\"},\"79dac590-dbef-11ec-bb16-614b09b3ac18\":{\"id\":\"79dac590-dbef-11ec-bb16-614b09b3ac18\",\"name\":\"testname\",\"top\":496.391,\"left\":453,\"opcode\":\"滤算子\",\"sourcetype\":\"operation\"}},\"bodybaseinfo\":{\"76d88210-dbef-11ec-bb16-614b09b3ac18\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"},\"781dfa60-dbef-11ec-bb16-614b09b3ac18\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"}},\"opcodeinfo\":{\"79643600-dbef-11ec-bb16-614b09b3ac18\":{\"type\":\"OpMap\",\"key\":\"1\"},\"79dac590-dbef-11ec-bb16-614b09b3ac18\":{\"type\":\"OpFilt\",\"key\":\"123\"}}}', '[{\"operators\":[{\"type\":\"OpMap\",\"key\":\"1\"},{\"type\":\"OpFilt\",\"key\":\"123\"}],\"source\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"},\"dest\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"}}]');
INSERT INTO `jobflow` VALUES ('90a0796d628e633289b48d45870236da', '{\"dragbody_operation\":[],\"dragbody_list\":[{\"id\":\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":238.381,\"left\":160.7,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},{\"id\":\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":649.762,\"left\":228.7,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"}],\"linklist\":[{\"source\":\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\",\"target\":\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\"}],\"bodymap\":{\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\":{\"id\":\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":238.381,\"left\":160.7,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\":{\"id\":\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":649.762,\"left\":228.7,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"}},\"bodybaseinfo\":{\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\":{\"types\":\"kafka\",\"port\":9092,\"id\":20,\"url\":\"hadoop102\",\"topic\":\"kfkPort\"},\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"}},\"opcodeinfo\":{}}', '[{\"operators\":[],\"source\":{\"types\":\"kafka\",\"port\":9092,\"id\":20,\"url\":\"hadoop102\",\"topic\":\"kfkPort\"},\"dest\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"}}]');
INSERT INTO `jobflow` VALUES ('b08a9961874a29770b2cbcc540325dd9', '{\"dragbody_operation\":[{\"id\":\"c372d930-dbff-11ec-8307-791cb78ec8f0\",\"name\":\"testname\",\"top\":363.391,\"left\":260,\"opcode\":\"滤算子\",\"sourcetype\":\"operation\"}],\"dragbody_list\":[{\"id\":\"c20629d0-dbff-11ec-8307-791cb78ec8f0\",\"name\":\"testname\",\"top\":52.3906,\"left\":217,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},{\"id\":\"c56692e0-dbff-11ec-8307-791cb78ec8f0\",\"name\":\"testname\",\"top\":276.391,\"left\":571,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"}],\"linklist\":[{\"source\":\"c20629d0-dbff-11ec-8307-791cb78ec8f0\",\"target\":\"c372d930-dbff-11ec-8307-791cb78ec8f0\"},{\"source\":\"c372d930-dbff-11ec-8307-791cb78ec8f0\",\"target\":\"c56692e0-dbff-11ec-8307-791cb78ec8f0\"}],\"bodymap\":{\"c20629d0-dbff-11ec-8307-791cb78ec8f0\":{\"id\":\"c20629d0-dbff-11ec-8307-791cb78ec8f0\",\"name\":\"testname\",\"top\":52.3906,\"left\":217,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},\"c372d930-dbff-11ec-8307-791cb78ec8f0\":{\"id\":\"c372d930-dbff-11ec-8307-791cb78ec8f0\",\"name\":\"testname\",\"top\":363.391,\"left\":260,\"opcode\":\"滤算子\",\"sourcetype\":\"operation\"},\"c56692e0-dbff-11ec-8307-791cb78ec8f0\":{\"id\":\"c56692e0-dbff-11ec-8307-791cb78ec8f0\",\"name\":\"testname\",\"top\":276.391,\"left\":571,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"}},\"bodybaseinfo\":{\"c20629d0-dbff-11ec-8307-791cb78ec8f0\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"},\"c56692e0-dbff-11ec-8307-791cb78ec8f0\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"}},\"opcodeinfo\":{\"c372d930-dbff-11ec-8307-791cb78ec8f0\":{\"type\":\"OpFilt\",\"key\":\"123\"}}}', '[{\"operators\":[{\"type\":\"OpFilt\",\"key\":\"123\"}],\"source\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"},\"dest\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"}}]');
INSERT INTO `jobflow` VALUES ('cc4e5fb90da7898ea8eebe553b65db4e', '{\"dragbody_operation\":[],\"dragbody_list\":[{\"id\":\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":238.381,\"left\":160.7,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},{\"id\":\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":649.762,\"left\":228.7,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"}],\"linklist\":[{\"source\":\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\",\"target\":\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\"}],\"bodymap\":{\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\":{\"id\":\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":238.381,\"left\":160.7,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\":{\"id\":\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\",\"name\":\"testname\",\"top\":649.762,\"left\":228.7,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"}},\"bodybaseinfo\":{\"c14ff4d0-dbe1-11ec-a6e5-e936007a41c4\":{\"types\":\"kafka\",\"port\":9092,\"id\":20,\"url\":\"hadoop102\",\"topic\":\"kfkPort\"},\"c26e5d20-dbe1-11ec-a6e5-e936007a41c4\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"}},\"opcodeinfo\":{}}', '[{\"operators\":[],\"source\":{\"types\":\"kafka\",\"port\":9092,\"id\":20,\"url\":\"hadoop102\",\"topic\":\"kfkPort\"},\"dest\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"}}]');
INSERT INTO `jobflow` VALUES ('d20220452c030f03a4bdd26faccd7713', '{\"dragbody_operation\":[{\"id\":\"c372d930-dbff-11ec-8307-791cb78ec8f0\",\"name\":\"testname\",\"top\":363.391,\"left\":260,\"opcode\":\"滤算子\",\"sourcetype\":\"operation\"}],\"dragbody_list\":[{\"id\":\"c20629d0-dbff-11ec-8307-791cb78ec8f0\",\"name\":\"testname\",\"top\":52.3906,\"left\":217,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},{\"id\":\"c56692e0-dbff-11ec-8307-791cb78ec8f0\",\"name\":\"testname\",\"top\":276.391,\"left\":571,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"}],\"linklist\":[{\"source\":\"c20629d0-dbff-11ec-8307-791cb78ec8f0\",\"target\":\"c372d930-dbff-11ec-8307-791cb78ec8f0\"},{\"source\":\"c372d930-dbff-11ec-8307-791cb78ec8f0\",\"target\":\"c56692e0-dbff-11ec-8307-791cb78ec8f0\"}],\"bodymap\":{\"c20629d0-dbff-11ec-8307-791cb78ec8f0\":{\"id\":\"c20629d0-dbff-11ec-8307-791cb78ec8f0\",\"name\":\"testname\",\"top\":52.3906,\"left\":217,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},\"c372d930-dbff-11ec-8307-791cb78ec8f0\":{\"id\":\"c372d930-dbff-11ec-8307-791cb78ec8f0\",\"name\":\"testname\",\"top\":363.391,\"left\":260,\"opcode\":\"滤算子\",\"sourcetype\":\"operation\"},\"c56692e0-dbff-11ec-8307-791cb78ec8f0\":{\"id\":\"c56692e0-dbff-11ec-8307-791cb78ec8f0\",\"name\":\"testname\",\"top\":276.391,\"left\":571,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"}},\"bodybaseinfo\":{\"c20629d0-dbff-11ec-8307-791cb78ec8f0\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"},\"c56692e0-dbff-11ec-8307-791cb78ec8f0\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"}},\"opcodeinfo\":{\"c372d930-dbff-11ec-8307-791cb78ec8f0\":{\"type\":\"OpFilt\",\"key\":\"aa1\"}}}', '[{\"operators\":[{\"type\":\"OpFilt\",\"key\":\"aa1\"}],\"source\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"},\"dest\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"}}]');
INSERT INTO `jobflow` VALUES ('fe30807613b119bbc1fa495cbd5fa737', '{\"dragbody_operation\":[{\"id\":\"ed2cae60-dbfd-11ec-9bc6-a3ab3e01bdd8\",\"name\":\"testname\",\"top\":445.391,\"left\":161,\"opcode\":\"计算子\",\"sourcetype\":\"operation\"},{\"id\":\"ee149d60-dbfd-11ec-9bc6-a3ab3e01bdd8\",\"name\":\"testname\",\"top\":466.391,\"left\":401,\"opcode\":\"滤算子\",\"sourcetype\":\"operation\"},{\"id\":\"ef241190-dbfd-11ec-9bc6-a3ab3e01bdd8\",\"name\":\"testname\",\"top\":380.391,\"left\":569,\"opcode\":\"時算子\",\"sourcetype\":\"operation\"}],\"dragbody_list\":[{\"id\":\"e882fc70-dbfd-11ec-9bc6-a3ab3e01bdd8\",\"name\":\"testname\",\"top\":43.3906,\"left\":126,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},{\"id\":\"e9e105d0-dbfd-11ec-9bc6-a3ab3e01bdd8\",\"name\":\"testname\",\"top\":77.3906,\"left\":837,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"}],\"linklist\":[{\"source\":\"e882fc70-dbfd-11ec-9bc6-a3ab3e01bdd8\",\"target\":\"ed2cae60-dbfd-11ec-9bc6-a3ab3e01bdd8\"},{\"source\":\"ed2cae60-dbfd-11ec-9bc6-a3ab3e01bdd8\",\"target\":\"ee149d60-dbfd-11ec-9bc6-a3ab3e01bdd8\"},{\"source\":\"ee149d60-dbfd-11ec-9bc6-a3ab3e01bdd8\",\"target\":\"ef241190-dbfd-11ec-9bc6-a3ab3e01bdd8\"},{\"source\":\"ef241190-dbfd-11ec-9bc6-a3ab3e01bdd8\",\"target\":\"e9e105d0-dbfd-11ec-9bc6-a3ab3e01bdd8\"}],\"bodymap\":{\"e882fc70-dbfd-11ec-9bc6-a3ab3e01bdd8\":{\"id\":\"e882fc70-dbfd-11ec-9bc6-a3ab3e01bdd8\",\"name\":\"testname\",\"top\":43.3906,\"left\":126,\"opcode\":\"source\",\"sourcetype\":\"Kafka\"},\"e9e105d0-dbfd-11ec-9bc6-a3ab3e01bdd8\":{\"id\":\"e9e105d0-dbfd-11ec-9bc6-a3ab3e01bdd8\",\"name\":\"testname\",\"top\":77.3906,\"left\":837,\"opcode\":\"target\",\"sourcetype\":\"Kafka\"},\"ed2cae60-dbfd-11ec-9bc6-a3ab3e01bdd8\":{\"id\":\"ed2cae60-dbfd-11ec-9bc6-a3ab3e01bdd8\",\"name\":\"testname\",\"top\":445.391,\"left\":161,\"opcode\":\"计算子\",\"sourcetype\":\"operation\"},\"ee149d60-dbfd-11ec-9bc6-a3ab3e01bdd8\":{\"id\":\"ee149d60-dbfd-11ec-9bc6-a3ab3e01bdd8\",\"name\":\"testname\",\"top\":466.391,\"left\":401,\"opcode\":\"滤算子\",\"sourcetype\":\"operation\"},\"ef241190-dbfd-11ec-9bc6-a3ab3e01bdd8\":{\"id\":\"ef241190-dbfd-11ec-9bc6-a3ab3e01bdd8\",\"name\":\"testname\",\"top\":380.391,\"left\":569,\"opcode\":\"時算子\",\"sourcetype\":\"operation\"}},\"bodybaseinfo\":{\"e882fc70-dbfd-11ec-9bc6-a3ab3e01bdd8\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"},\"e9e105d0-dbfd-11ec-9bc6-a3ab3e01bdd8\":{\"types\":\"kafka\",\"port\":9092,\"id\":20,\"url\":\"hadoop102\",\"topic\":\"kfkPort\"}},\"opcodeinfo\":{\"ed2cae60-dbfd-11ec-9bc6-a3ab3e01bdd8\":{\"type\":\"OpCount\",\"key\":\"1\"},\"ee149d60-dbfd-11ec-9bc6-a3ab3e01bdd8\":{\"type\":\"OpFilt\",\"key\":\"123\"},\"ef241190-dbfd-11ec-9bc6-a3ab3e01bdd8\":{\"type\":\"OpTime\",\"key\":\"15\"}}}', '[{\"operators\":[{\"type\":\"OpCount\",\"key\":\"1\"},{\"type\":\"OpFilt\",\"key\":\"123\"},{\"type\":\"OpTime\",\"key\":\"15\"}],\"source\":{\"types\":\"kafka\",\"port\":9092,\"id\":19,\"url\":\"hadoop102\",\"topic\":\"kfkSQL\"},\"dest\":{\"types\":\"kafka\",\"port\":9092,\"id\":20,\"url\":\"hadoop102\",\"topic\":\"kfkPort\"}}]');

-- ----------------------------
-- Table structure for kafka

-- ----------------------------
-- Table structure for kats2
-- ----------------------------
DROP TABLE IF EXISTS `kats2`;
CREATE TABLE `kats2`  (
  `asdfasd` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of kats2
-- ----------------------------

-- ----------------------------
-- Table structure for modbus
-- ----------------------------
DROP TABLE IF EXISTS `modbus`;
CREATE TABLE `modbus`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `port` int(11) NULL DEFAULT NULL,
  `data` varchar(2048) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of modbus
-- ----------------------------
INSERT INTO `modbus` VALUES (2, 33023, '[{\"type\":12,\"slave_id\":12,\"offset\":4,\"datatype\":23},{\"type\":132,\"slave_id\":2,\"offset\":3,\"datatype\":2}]', 'sdfasdfadswe');
INSERT INTO `modbus` VALUES (3, 123, '[{\"type\":1,\"slave_id\":1,\"offset\":1,\"datatype\":1},{\"type\":2,\"slave_id\":2,\"offset\":2,\"datatype\":2}]', '12312312345sdfawsefaew');

-- ----------------------------
-- Table structure for opcua
-- ----------------------------
DROP TABLE IF EXISTS `opcua`;
CREATE TABLE `opcua`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `serverUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `isAnonymous` tinyint(1) NULL DEFAULT NULL,
  `identifier` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of opcua
-- ----------------------------
INSERT INTO `opcua` VALUES (1, 'csfasef', 'sdfawe', 'awefawf', 0, 'asfaewafwef');
INSERT INTO `opcua` VALUES (2, 'sdfdsf', 'asfawef ', 'sdfwsef', 1, 'sdfe');

-- ----------------------------
-- Table structure for redis
-- ----------------------------
DROP TABLE IF EXISTS `redis`;
CREATE TABLE `redis`  (
  `Url` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `port` int(11) NULL DEFAULT NULL,
  `Topic` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `Id` int(64) NOT NULL AUTO_INCREMENT,
  `Username` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `Password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `Tablename` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of redis
-- ----------------------------
INSERT INTO `redis` VALUES ('192.168.10.11231234', 9881, 'terst', 11, '2134', '123456', 'tabed');
INSERT INTO `redis` VALUES ('192.168.10.11231234', 123, 'setse', 13, 'root', '123456', 'nate');

-- ----------------------------
-- Table structure for rtmp
-- ----------------------------
DROP TABLE IF EXISTS `rtmp`;
CREATE TABLE `rtmp`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Url` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rtmp
-- ----------------------------
INSERT INTO `rtmp` VALUES (2, 'asdfasdf ');
INSERT INTO `rtmp` VALUES (3, 'sdfwesdfc');

-- ----------------------------
-- Table structure for rtsp
-- ----------------------------
DROP TABLE IF EXISTS `rtsp`;
CREATE TABLE `rtsp`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Url` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rtsp
-- ----------------------------
INSERT INTO `rtsp` VALUES (2, '192.168.10.11231234');
INSERT INTO `rtsp` VALUES (3, 'sdfsdf ');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `birth` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, 'dsfsdf', '2022-05-18');
INSERT INTO `student` VALUES (32, 'asdf', '2022-04-22');

-- ----------------------------
-- Table structure for student_copy1
-- ----------------------------
DROP TABLE IF EXISTS `student_copy1`;
CREATE TABLE `student_copy1`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `birth` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student_copy1
-- ----------------------------
INSERT INTO `student_copy1` VALUES (1, 'dsfsdf', '2022-05-18');
INSERT INTO `student_copy1` VALUES (32, 'asdf', '2022-04-22');

-- ----------------------------
-- Table structure for test1
-- ----------------------------
DROP TABLE IF EXISTS `test1`;
CREATE TABLE `test1`  (
  `a1` int(255) NULL DEFAULT NULL,
  `a2` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `a3` int(255) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of test1
-- ----------------------------
INSERT INTO `test1` VALUES (234, '123', 123);
INSERT INTO `test1` VALUES (234, '567', 234);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '123',
  `priority` int(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`, `name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'a', '123', 1);
INSERT INTO `user` VALUES (2, 'hxy', '123', 2);

-- ----------------------------
-- Table structure for userjob
-- ----------------------------
DROP TABLE IF EXISTS `userjob`;
CREATE TABLE `userjob`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `jobId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userId` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userjob
-- ----------------------------
INSERT INTO `userjob` VALUES (1, '123213', 123123);
INSERT INTO `userjob` VALUES (2, 'wqe', 1233);
INSERT INTO `userjob` VALUES (3, 'asd123', 2123);

SET FOREIGN_KEY_CHECKS = 1;
