create database if not exists cloud;

use cloud;

CREATE TABLE if not exists payment
(
    id     BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    serial VARCHAR(200) DEFAULT '' comment '支付流水号',
    PRIMARY KEY (id)
) ENGINE = INNODB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4;