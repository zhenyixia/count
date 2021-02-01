-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.20-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 导出  表 springboot01.tbl_run_detail 结构
CREATE TABLE IF NOT EXISTS `tbl_run_detail` (
  `id` bigint(21) NOT NULL AUTO_INCREMENT,
  `kilometer` decimal(9,2) DEFAULT NULL COMMENT '本次跑步的公里数',
  `address` varchar(100) DEFAULT NULL COMMENT '运动地点',
  `run_date` varchar(15) DEFAULT NULL COMMENT '跑步日期',
  `year` int(4) DEFAULT NULL COMMENT '年，数据格式如：2021',
  `month` int(2) DEFAULT NULL COMMENT '月，数据格式为：1，2，...12',
  `day` int(2) DEFAULT NULL COMMENT '日',
  `week_day` varchar(5) DEFAULT NULL COMMENT '周几，数据范围为：一，二，...，六，日',
  `run_second` int(11) DEFAULT NULL COMMENT '运动时长，单位为秒',
  `time_by_km` varchar(15) DEFAULT NULL COMMENT '平均配速，即每公里用时',
  `km_by_hour` decimal(3,1) DEFAULT NULL COMMENT '平均速度，每小时跑多少公里，如6.7公里/时',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录更新时间',
  PRIMARY KEY (`id`),
  KEY `tbl_run_detail_run_date` (`run_date`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='运动表';

-- 正在导出表  springboot01.tbl_run_detail 的数据：~0 rows (大约)
DELETE FROM `tbl_run_detail`;
/*!40000 ALTER TABLE `tbl_run_detail` DISABLE KEYS */;
INSERT INTO `tbl_run_detail` (`id`, `kilometer`, `address`, `run_date`, `year`, `month`, `day`, `week_day`, `run_second`, `time_by_km`, `km_by_hour`, `update_time`) VALUES
	(1, 1.00, '东滩社区', '2021/1/31', 2021, 1, 31, '日', 698, '11分38秒', 5.0, '2021-01-31 09:12:45'),
	(2, 1.10, '东滩社区', '2021/1/30', 2021, 1, 30, '六', 599, '9分5秒', 7.0, '2021-01-31 09:12:45'),
	(3, 2.35, '东滩社区', '2021/1/30', 2021, 1, 30, '六', 966, '6分51秒', 9.0, '2021-01-31 09:12:45'),
	(4, 2.33, '东滩社区', '2021/1/29', 2021, 1, 29, '五', 1940, '13分53秒', 4.0, '2021-01-31 14:32:05'),
	(5, 1.02, '东滩社区', '2021/1/28', 2021, 1, 28, '四', 601, '9分49秒', 6.0, '2021-01-31 14:32:05'),
	(6, 1.40, '东滩社区', '2021/1/27', 2021, 1, 27, '三', 725, '8分38秒', 7.0, '2021-01-31 14:32:05'),
	(7, 1.50, '东滩社区', '2021/1/27', 2021, 1, 27, '三', 939, '10分26秒', 6.0, '2021-01-31 14:32:05'),
	(8, 1.62, '东滩社区', '2021/1/26', 2021, 1, 26, '二', 735, '7分34秒', 8.0, '2021-01-31 14:32:05'),
	(9, 0.65, '东滩社区', '2021/1/25', 2021, 1, 25, '一', 412, '10分34秒', 6.0, '2021-01-31 14:32:05'),
	(10, 1.63, '东滩社区', '2021/1/23', 2021, 1, 23, '六', 807, '8分15秒', 7.0, '2021-01-31 15:40:22'),
	(11, 1.62, '东滩社区', '2021/1/22', 2021, 1, 22, '五', 1069, '11分0秒', 5.0, '2021-01-31 15:40:22'),
	(12, 1.51, '东滩社区', '2021/1/21', 2021, 1, 21, '四', 830, '9分10秒', 7.0, '2021-01-31 15:40:22'),
	(13, 1.72, '东滩社区', '2021/1/20', 2021, 1, 20, '三', 873, '8分28秒', 7.0, '2021-01-31 15:40:22'),
	(14, 1.20, '东滩社区', '2021/1/20', 2021, 1, 20, '三', 849, '11分48秒', 5.0, '2021-01-31 15:40:22'),
	(15, 1.06, '东滩社区', '2021/1/19', 2021, 1, 19, '二', 595, '9分21秒', 6.0, '2021-01-31 15:40:22'),
	(16, 1.92, '东滩社区', '2021/1/17', 2021, 1, 17, '日', 1092, '9分29秒', 6.0, '2021-01-31 15:40:22'),
	(17, 1.33, '东滩社区', '2021/1/17', 2021, 1, 17, '日', 1126, '14分7秒', 4.0, '2021-01-31 15:40:22'),
	(18, 1.09, '东滩社区', '2021/1/16', 2021, 1, 16, '六', 1037, '15分51秒', 4.0, '2021-01-31 15:40:22'),
	(19, 2.06, '东滩社区', '2021/1/15', 2021, 1, 15, '五', 1090, '8分49秒', 7.0, '2021-01-31 15:40:22'),
	(20, 0.43, '东滩社区', '2021/1/14', 2021, 1, 14, '四', 189, '7分20秒', 8.0, '2021-01-31 15:40:22'),
	(21, 1.28, '东滩社区', '2021/1/14', 2021, 1, 14, '四', 1085, '14分8秒', 4.0, '2021-01-31 15:40:22'),
	(22, 1.31, '东滩社区', '2021/1/13', 2021, 1, 13, '三', 954, '12分8秒', 5.0, '2021-01-31 15:40:22'),
	(23, 2.12, '东滩社区', '2021/1/12', 2021, 1, 12, '二', 1003, '7分53秒', 8.0, '2021-01-31 15:40:22'),
	(24, 1.47, '东滩社区', '2021/1/12', 2021, 1, 12, '二', 883, '10分1秒', 6.0, '2021-01-31 15:40:22'),
	(25, 2.16, '东滩社区', '2021/1/11', 2021, 1, 11, '一', 1005, '7分45秒', 8.0, '2021-01-31 15:40:22'),
	(26, 1.06, '东滩社区', '2021/1/11', 2021, 1, 11, '一', 1012, '15分55秒', 4.0, '2021-01-31 15:40:22'),
	(27, 1.11, '东滩社区', '2021/1/10', 2021, 1, 10, '日', 922, '13分51秒', 4.0, '2021-01-31 15:43:46'),
	(28, 2.67, '东滩社区', '2021/1/9', 2021, 1, 9, '六', 1605, '10分1秒', 6.0, '2021-01-31 15:43:46'),
	(29, 1.31, '东滩社区', '2021/1/9', 2021, 1, 9, '六', 1125, '14分19秒', 4.0, '2021-01-31 15:43:46'),
	(30, 1.42, '东滩社区', '2021/1/8', 2021, 1, 8, '五', 1685, '19分47秒', 3.0, '2021-01-31 15:43:46'),
	(31, 1.22, '东滩社区', '2021/1/7', 2021, 1, 7, '四', 1474, '20分8秒', 3.0, '2021-01-31 15:43:46'),
	(32, 1.71, '东滩社区', '2021/1/6', 2021, 1, 6, '三', 961, '9分22秒', 6.0, '2021-01-31 15:43:46'),
	(33, 1.50, '东滩社区', '2021/1/6', 2021, 1, 6, '三', 901, '10分1秒', 6.0, '2021-01-31 15:43:46'),
	(34, 2.75, '东滩社区', '2021/1/5', 2021, 1, 5, '二', 1822, '11分3秒', 5.0, '2021-01-31 15:43:46'),
	(35, 1.12, '东滩社区', '2021/1/5', 2021, 1, 5, '二', 1010, '15分2秒', 4.0, '2021-01-31 15:43:46'),
	(36, 1.04, '东滩社区', '2021/1/4', 2021, 1, 4, '一', 1106, '17分43秒', 3.0, '2021-01-31 15:43:46'),
	(37, 2.28, '东滩社区', '2020/12/31', 2020, 12, 31, '四', 1007, '7分22秒', 8.0, '2021-01-31 15:51:03'),
	(38, 1.31, '东滩社区', '2020/12/31', 2020, 12, 31, '四', 1212, '15分25秒', 4.0, '2021-01-31 15:51:03'),
	(39, 1.08, '东滩社区', '2020/12/30', 2020, 12, 30, '三', 1009, '15分34秒', 4.0, '2021-01-31 15:54:26'),
	(40, 1.92, '东滩社区', '2020/12/29', 2020, 12, 29, '二', 1238, '10分45秒', 6.0, '2021-01-31 15:54:26'),
	(41, 2.45, '东滩社区', '2020/12/28', 2020, 12, 28, '一', 1598, '10分52秒', 6.0, '2021-01-31 15:57:40'),
	(42, 1.27, '东滩社区', '2020/12/27', 2020, 12, 27, '日', 906, '11分53秒', 5.0, '2021-01-31 15:57:40');
/*!40000 ALTER TABLE `tbl_run_detail` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;