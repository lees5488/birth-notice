-- mysql 8
CREATE TABLE `birth_notice` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `pinyin` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '拼音',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名字',
  `nick` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '昵称',
  `new_birth` datetime DEFAULT NULL,
  `old_birth` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `notes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `id_card` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '身份证号',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '0' COMMENT '电话',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '邮箱',
  `send_type` smallint(4) NOT NULL DEFAULT '1' COMMENT '发送状态、8的状态为只通知自己',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- mysql 5.7
CREATE TABLE `birth_notice` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `pinyin` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '拼音',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名字',
  `nick` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '昵称',
  `new_birth` datetime DEFAULT NULL,
  `old_birth` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `id_card` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '身份证号',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '电话',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '邮箱',
  `send_type` smallint(4) NOT NULL DEFAULT '1' COMMENT '发送状态、8的状态为只通知自己',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci AUTO_INCREMENT=1 ;


INSERT INTO `birth`.`birth_notice` (`id`, `pinyin`, `name`, `nick`, `new_birth`, `old_birth`, `notes`, `id_card`, `phone`, `email`, `send_type`) VALUES ('2', 'zhangsan', '張三', '张姗姗', NULL, '19951104', '1', '', '17191073042', '1111111@163.com', '1');
INSERT INTO `birth`.`birth_notice` (`id`, `pinyin`, `name`, `nick`, `new_birth`, `old_birth`, `notes`, `id_card`, `phone`, `email`, `send_type`) VALUES ('4', 'lisi', '李四', '李思思', NULL, '19930817', '1', '', '12345678910', '', '1');
INSERT INTO `birth`.`birth_notice` (`id`, `pinyin`, `name`, `nick`, `new_birth`, `old_birth`, `notes`, `id_card`, `phone`, `email`, `send_type`) VALUES ('5', 'wangwu', '王五', '王武武', NULL, '19941213', NULL, '', '16666666666', '', '1');
INSERT INTO `birth`.`birth_notice` (`id`, `pinyin`, `name`, `nick`, `new_birth`, `old_birth`, `notes`, `id_card`, `phone`, `email`, `send_type`) VALUES ('6', 'zhaoliu', '赵六', '赵柳柳', NULL, '19901203', NULL, '', '13111111111', '', '8');


-- mysql 8
CREATE TABLE `period` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `period_time_start` datetime DEFAULT NULL,
  `period_time_end` datetime DEFAULT NULL,
  `notes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `apart` tinyint(2) DEFAULT NULL,
  `user_id` mediumint(9) DEFAULT NULL,
  `interval` tinyint(2) DEFAULT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- mysql 5.7

CREATE TABLE `period` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `period_time_start` datetime DEFAULT NULL,
  `period_time_end` datetime DEFAULT NULL,
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `apart` tinyint(2) DEFAULT NULL,
  `user_id` mediumint(9) DEFAULT NULL,
  `interval` tinyint(2) DEFAULT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

