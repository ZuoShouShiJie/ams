--------商户表
CREATE TABLE `ams_merchant_info` (
  `id` int(11) NOT NULL COMMENT '商户信息表',
  `org_id` int(11) NOT NULL,
  `org_name` varchar(32) DEFAULT NULL COMMENT '商户名称',
  `org_type` varchar(1) DEFAULT NULL COMMENT '商户类型（1：资产方，2：资金方）',
  `status` varchar(1) DEFAULT NULL,
  `rate` decimal(18,2) DEFAULT NULL COMMENT '商户利率',
  `created_time` timestamp NULL DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `updated_time` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`org_id`),
  KEY `ams_merchant_info_index_01` (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
/*!50100 PARTITION BY LIST (org_id)
(PARTITION CHANNLE_1000 VALUES IN (1000) ENGINE = InnoDB,
 PARTITION CHANNLE_1001 VALUES IN (1001) ENGINE = InnoDB,
 PARTITION CHANNLE_1002 VALUES IN (1002) ENGINE = InnoDB,
 PARTITION CHANNLE_1003 VALUES IN (1003) ENGINE = InnoDB,
 PARTITION CHANNLE_1004 VALUES IN (1004) ENGINE = InnoDB,
 PARTITION CHANNLE_1005 VALUES IN (1005) ENGINE = InnoDB,
 PARTITION CHANNLE_1006 VALUES IN (1006) ENGINE = InnoDB,
 PARTITION CHANNLE_1007 VALUES IN (1007) ENGINE = InnoDB,
 PARTITION CHANNLE_1008 VALUES IN (1008) ENGINE = InnoDB,
 PARTITION CHANNLE_1009 VALUES IN (1009) ENGINE = InnoDB,
 PARTITION CHANNLE_1010 VALUES IN (1010) ENGINE = InnoDB,
 PARTITION CHANNLE_2000 VALUES IN (2000) ENGINE = InnoDB,
 PARTITION CHANNLE_2001 VALUES IN (2001) ENGINE = InnoDB,
 PARTITION CHANNLE_2002 VALUES IN (2002) ENGINE = InnoDB,
 PARTITION CHANNLE_2003 VALUES IN (2003) ENGINE = InnoDB,
 PARTITION CHANNLE_2004 VALUES IN (2004) ENGINE = InnoDB,
 PARTITION CHANNLE_2005 VALUES IN (2005) ENGINE = InnoDB,
 PARTITION CHANNLE_2006 VALUES IN (2006) ENGINE = InnoDB,
 PARTITION CHANNLE_2007 VALUES IN (2007) ENGINE = InnoDB,
 PARTITION CHANNLE_2008 VALUES IN (2008) ENGINE = InnoDB,
 PARTITION CHANNLE_2009 VALUES IN (2009) ENGINE = InnoDB,
 PARTITION CHANNLE_2010 VALUES IN (2010) ENGINE = InnoDB) */;

CREATE TABLE `ams_merchant_limit` (
  `id` int(11) NOT NULL,
  `org_id` int(11) NOT NULL,
  `single_amount_limit` decimal(18,2) DEFAULT NULL COMMENT '单笔限额',
  `day_amount_limit` decimal(18,2) DEFAULT NULL COMMENT '每日金额限制',
  `month_amount_limit` decimal(18,2) DEFAULT NULL COMMENT '每月金额限制',
  `total_amount_limit` decimal(18,2) DEFAULT NULL COMMENT '总金额限制',
  `status` varchar(1) DEFAULT NULL,
  `created_time` timestamp NULL DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `updated_time` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`org_id`),
  KEY `ams_merchant_limit_index_01` (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
/*!50100 PARTITION BY LIST (org_id)
(PARTITION CHANNLE_1000 VALUES IN (1000) ENGINE = InnoDB,
 PARTITION CHANNLE_1001 VALUES IN (1001) ENGINE = InnoDB,
 PARTITION CHANNLE_1002 VALUES IN (1002) ENGINE = InnoDB,
 PARTITION CHANNLE_1003 VALUES IN (1003) ENGINE = InnoDB,
 PARTITION CHANNLE_1004 VALUES IN (1004) ENGINE = InnoDB,
 PARTITION CHANNLE_1005 VALUES IN (1005) ENGINE = InnoDB,
 PARTITION CHANNLE_1006 VALUES IN (1006) ENGINE = InnoDB,
 PARTITION CHANNLE_1007 VALUES IN (1007) ENGINE = InnoDB,
 PARTITION CHANNLE_1008 VALUES IN (1008) ENGINE = InnoDB,
 PARTITION CHANNLE_1009 VALUES IN (1009) ENGINE = InnoDB,
 PARTITION CHANNLE_1010 VALUES IN (1010) ENGINE = InnoDB,
 PARTITION CHANNLE_2000 VALUES IN (2000) ENGINE = InnoDB,
 PARTITION CHANNLE_2001 VALUES IN (2001) ENGINE = InnoDB,
 PARTITION CHANNLE_2002 VALUES IN (2002) ENGINE = InnoDB,
 PARTITION CHANNLE_2003 VALUES IN (2003) ENGINE = InnoDB,
 PARTITION CHANNLE_2004 VALUES IN (2004) ENGINE = InnoDB,
 PARTITION CHANNLE_2005 VALUES IN (2005) ENGINE = InnoDB,
 PARTITION CHANNLE_2006 VALUES IN (2006) ENGINE = InnoDB,
 PARTITION CHANNLE_2007 VALUES IN (2007) ENGINE = InnoDB,
 PARTITION CHANNLE_2008 VALUES IN (2008) ENGINE = InnoDB,
 PARTITION CHANNLE_2009 VALUES IN (2009) ENGINE = InnoDB,
 PARTITION CHANNLE_2010 VALUES IN (2010) ENGINE = InnoDB) */;