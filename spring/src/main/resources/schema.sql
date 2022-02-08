CREATE TABLE user (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `username` varchar(255) DEFAULT '' COMMENT '用户名',
    `password` varchar(255) DEFAULT '' COMMENT '密码',
    `createAt` datetime NOT NULL,
    `updateAt` datetime NOT NULL
);
