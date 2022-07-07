/*
 Navicat Premium Data Transfer

 Source Server         : MYSQL
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : 127.0.0.1:13306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 04/06/2022 15:40:48
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
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Hdfs
-- ----------------------------
INSERT INTO `Hdfs` VALUES ('192.168.10.11231234', 9, 'json');

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
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
DROP TABLE IF EXISTS `kafka`;
CREATE TABLE `kafka`  (
    `ktes` varchar(225) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kafka
-- ----------------------------
INSERT INTO `kafka` VALUES ('nihaozheliwsdfasd');
INSERT INTO `kafka` VALUES ('');
INSERT INTO `kafka` VALUES ('nihasdfasdf');
INSERT INTO `kafka` VALUES ('nameshuojiexialaishishenasdf');
INSERT INTO `kafka` VALUES ('sadfsadfsdfasd');
INSERT INTO `kafka` VALUES ('asdfsdfa');
INSERT INTO `kafka` VALUES ('asdfasdfsa');
INSERT INTO `kafka` VALUES ('asdfasdfasd');
INSERT INTO `kafka` VALUES ('asdfa');
INSERT INTO `kafka` VALUES ('sdfas');
INSERT INTO `kafka` VALUES ('dfasdf');
INSERT INTO `kafka` VALUES ('asdf');
INSERT INTO `kafka` VALUES ('asd');
INSERT INTO `kafka` VALUES ('fasd');
INSERT INTO `kafka` VALUES ('fas');
INSERT INTO `kafka` VALUES ('dfa');
INSERT INTO `kafka` VALUES ('sdf');

-- ----------------------------
-- Table structure for kats2
-- ----------------------------
DROP TABLE IF EXISTS `kats2`;
CREATE TABLE `kats2`  (
    `asdfasd` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kats2
-- ----------------------------

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
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of redis
-- ----------------------------
INSERT INTO `redis` VALUES ('192.168.10.11231234', 9881, 'terst', 11, '2134', '123456', 'tabed');
INSERT INTO `redis` VALUES ('192.168.10.11231234', 123, 'setse', 13, 'root', '123456', 'nate');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
                            `id` int(11) NOT NULL,
                            `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
                            `birth` date NULL DEFAULT NULL,
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

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
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test1
-- ----------------------------
INSERT INTO `test1` VALUES (234, '123', 123);
INSERT INTO `test1` VALUES (234, '567', 234);

SET FOREIGN_KEY_CHECKS = 1;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `id` int(15) NOT NULL AUTO_INCREMENT,
                        `name` varchar(10) NOT NULL,
                        `pwd` varchar(10) NOT NULL DEFAULT '123',
                        `priority` int(1) NOT NULL DEFAULT '1',
                        PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`pwd`,`priority`) values
    (1,'a','123',1);

/*Table structure for table `userjob` */

DROP TABLE IF EXISTS `userjob`;

CREATE TABLE `userjob` (
                           `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户id',
                           `jobId` varchar(50) DEFAULT NULL,
                           `userId` int(20) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `userjob` */

insert  into `userjob`(`id`,`jobId`,`userId`) values
                                                  (1,'123213',123123),
                                                  (2,'wqe',1233),
                                                  (3,'asd123',2123);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
