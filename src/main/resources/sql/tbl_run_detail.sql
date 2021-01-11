CREATE TABLE `tbl_run_detail` (
	`id` BIGINT(21) NOT NULL AUTO_INCREMENT,
	`kilometer` DECIMAL(9,2) NULL DEFAULT NULL COMMENT '本次跑步的公里数',
	`address` VARCHAR(100) NULL DEFAULT NULL COMMENT '运动地点',
	`run_date` DATETIME NULL DEFAULT NULL COMMENT '跑步时间',
	`run_second` INT(11) NULL DEFAULT NULL COMMENT '运动时长，单位为秒',
	`time_by_km` INT(11) NULL DEFAULT NULL COMMENT '平均配速，即跑每公里用时多长时间，单位为秒，显示时可转化为几分几秒（8:56）',
	`km_by_hour` DECIMAL(3,1) NULL DEFAULT NULL COMMENT '平均速度，每小时跑多少公里，如6.7公里/时',
	`update_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
	PRIMARY KEY (`id`)
)
COMMENT='运动表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=20
;
