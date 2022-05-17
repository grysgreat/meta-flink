DROP TABLE IF EXISTS `DataBaseConfigs`;
CREATE TABLE `DataBaseConfigs` (
`id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
`driverClassName` varchar(40) DEFAULT NULL COMMENT '驱动类名',
`url` varchar(20) DEFAULT NULL COMMENT '连接地址',
`username` varchar(20) DEFAULT NULL COMMENT '账号',
`password` varchar(20) DEFAULT NULL COMMENT '密码',
`connectorType` varchar(20) DEFAULT NULL,
`Sql` varchar(100) DEFAULT NULL,
`port` int(15) DEFAULT NULL,
`tablename` varchar(25) DEFAULT NULL,
`basename` varchar(25) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `KaFKA`;
CREATE TABLE `KaFKA` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `Url` varchar(40) DEFAULT NULL COMMENT 'Url',
  `DestPort` int(11) DEFAULT NULL COMMENT '端口号',
  `Topic` varchar(20) DEFAULT NULL COMMENT '主题',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `redis`;
CREATE TABLE `redis` (
`Url` varchar(15) DEFAULT NULL,
`DestPort` int(11) DEFAULT NULL,
`Topic` varchar(100) DEFAULT NULL,
`Id` int(11) NOT NULL AUTO_INCREMENT,
`Username` varchar(20) DEFAULT NULL,
`Password` varchar(20) DEFAULT NULL,
`Tablename` varchar(20) DEFAULT NULL,
PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `Hdfs`;
CREATE TABLE `Hdfs` (
                        `Url` varchar(100) DEFAULT NULL,
                        `Id` int(11) NOT NULL AUTO_INCREMENT,
                        PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
DROP TABLE IF EXISTS `Sockets`;
CREATE TABLE `Sockets` (
                           `Port` int(11) DEFAULT NULL,
                           `Url` varchar(100) DEFAULT NULL,
                           `Id` int(11) NOT NULL AUTO_INCREMENT,
                           PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;