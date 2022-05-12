DROP TABLE IF EXISTS `DataBaseConfigs`;
CREATE TABLE `DataBaseConfigs` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `driverClassName` varchar(40) DEFAULT NULL COMMENT '驱动类名',
  `url` varchar(20) DEFAULT NULL COMMENT '连接地址',
  `username` varchar(20) DEFAULT NULL COMMENT '账号',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `connectorType` varchar(20) DEFAULT NULL,
  `sql` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;