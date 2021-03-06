-- --------------------------
-- 账务表
-- --------------------------
CREATE TABLE `ams_account_borrow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '借款账务表',
  `user_id` varchar(32) NOT NULL COMMENT '借款人帐号',
  `bo_id` varchar(32) DEFAULT NULL COMMENT '借款编号',
  `org_id` bigint(20) NOT NULL,
  `channel` varchar(1) DEFAULT NULL COMMENT '是否走撮合平台（0：非撮合渠道，1：通过撮合平台）',
  `product_code` varchar(32) DEFAULT NULL,
  `product_type` varchar(1) DEFAULT NULL,
  `contract_no` varchar(100) DEFAULT NULL COMMENT '合同编号（借据编号）list(可以单个合同，也支持多合同)',
  `contract_type` varchar(1) DEFAULT NULL COMMENT '合同类型（1：单合同/单借据，2：多合同/多借据）',
  `br_user_id` varchar(100) DEFAULT NULL COMMENT '出借人账号（list - 可以多个出借人，待确定）',
  `loan_amount` decimal(18,2) DEFAULT NULL COMMENT '借款金额',
  `contract_amount` decimal(18,2) DEFAULT NULL COMMENT '合同金额',
  `lend_amount` decimal(18,2) DEFAULT NULL COMMENT '本金金额',
  `capital_amount` decimal(18,2) DEFAULT NULL COMMENT '建帐金额',
  `account_amount` decimal(18,2) DEFAULT NULL,
  `apply_time` timestamp NULL DEFAULT NULL COMMENT '申请时间',
  `repay_rate` varchar(2000) DEFAULT NULL COMMENT '产品对应的费率json格式',
  `repay_floating_rate` decimal(10,2) DEFAULT NULL COMMENT '上浮比率（-20% — +20%）',
  `rate_type` varchar(1) DEFAULT NULL COMMENT '利率类型（1：天，2：月，3：年）',
  `platform_rate` decimal(10,2) DEFAULT NULL COMMENT '平台收益率（if channel=1,通过撮合平台需要计算平台收益）',
  `is_full_fee` varchar(1) DEFAULT NULL COMMENT '是否一次性收取平台fee（if channel=1）',
  `receipt_rate` decimal(10,2) DEFAULT NULL COMMENT '收款利率',
  `capital_advance` decimal(18,2) DEFAULT NULL COMMENT '预收本金',
  `interest_advance` decimal(18,2) DEFAULT NULL COMMENT '预收利息',
  `repay_account_no` varchar(32) DEFAULT NULL COMMENT '还款绑定账号',
  `repay_account_name` varchar(32) DEFAULT NULL COMMENT '还款账号开户名',
  `repay_acct_bank` varchar(32) DEFAULT NULL COMMENT '还款账号开户行',
  `repay_acct_phone` varchar(20) DEFAULT NULL COMMENT '还款账号预留手机号',
  `approve_time` timestamp NULL DEFAULT NULL COMMENT '审批时间',
  `lend_time` timestamp NULL DEFAULT NULL COMMENT '实际放款时间',
  `repay_date` varchar(5) DEFAULT NULL COMMENT '指定还款日',
  `repay_period` varchar(10) DEFAULT NULL COMMENT '还款期数',
  `repay_type` varchar(1) DEFAULT NULL,
  `first_repay_date` date DEFAULT NULL COMMENT '起始还款日',
  `last_repay_date` date DEFAULT NULL COMMENT '最后还款日',
  `loan_usage` varchar(1000) DEFAULT NULL COMMENT '借款用途',
  `repay_status` varchar(1) DEFAULT NULL COMMENT '当前还款状态（1：正常，2：提前部分还款，3：提前全部还款，4：逾期，5：代偿结清，6：追偿结清，7：坏账）',
  `next_repay_date` date DEFAULT NULL COMMENT '下一还款日',
  `total_capital_left` decimal(18,2) DEFAULT NULL COMMENT '截至当前剩余本金（用于全额提前还款试算）',
  `total_capital_accu` decimal(18,2) DEFAULT NULL COMMENT '截至当前累计已还本金金额',
  `interest_accu` decimal(18,2) DEFAULT NULL COMMENT '截至当前累计已还利息总额',
  `service_fee_accu` decimal(18,2) DEFAULT NULL COMMENT '截至当前累计已还服务费用总额',
  `punish_fee_accu` decimal(18,2) DEFAULT NULL COMMENT '截至当前累计已还罚息费用总额',
  `overdue_times` varchar(10) DEFAULT NULL COMMENT '逾期次数',
  `max_overdue_day` varchar(10) DEFAULT NULL COMMENT '最大逾期天数',
  `curr_overdue_day` varchar(10) DEFAULT NULL COMMENT '当前逾期天数',
  `created_time` timestamp NULL DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `updated_time` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL COMMENT '状态',
  `approve_date` date DEFAULT NULL COMMENT '审批日期',
  `lend_date` date DEFAULT NULL COMMENT '实际放款日',
  PRIMARY KEY (`id`,`org_id`),
  KEY `ams_account_borrow_index_01` (`bo_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4
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
 PARTITION CHANNLE_2010 VALUES IN (2010) ENGINE = InnoDB,
 PARTITION CHANNLE_1011 VALUES IN (1011) ENGINE = InnoDB,
 PARTITION CHANNLE_1012 VALUES IN (1012) ENGINE = InnoDB,
 PARTITION CHANNLE_1013 VALUES IN (1013) ENGINE = InnoDB,
 PARTITION CHANNLE_1014 VALUES IN (1014) ENGINE = InnoDB,
 PARTITION CHANNLE_1015 VALUES IN (1015) ENGINE = InnoDB,
 PARTITION CHANNLE_1016 VALUES IN (1016) ENGINE = InnoDB,
 PARTITION CHANNLE_1017 VALUES IN (1017) ENGINE = InnoDB,
 PARTITION CHANNLE_1018 VALUES IN (1018) ENGINE = InnoDB,
 PARTITION CHANNLE_1019 VALUES IN (1019) ENGINE = InnoDB,
 PARTITION CHANNLE_1020 VALUES IN (1020) ENGINE = InnoDB) */;


CREATE TABLE `ams_account_earnings` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '平台收益表',
  `user_id` varchar(32) DEFAULT NULL COMMENT '出借人账号',
  `bo_user_id` varchar(32) DEFAULT NULL COMMENT '借款人账号',
  `bo_id` varchar(32) DEFAULT NULL COMMENT '借款编号',
  `period_num` varchar(10) DEFAULT NULL COMMENT '期数编号',
  `org_id` bigint(20) NOT NULL,
  `is_full_fee` varchar(1) DEFAULT NULL COMMENT '是否一次性收取平台fee',
  `capital_amount` decimal(18,2) DEFAULT NULL COMMENT '当期应收本金',
  `interest_amount` decimal(18,2) DEFAULT NULL COMMENT '当期应收利息',
  `merchant_service_fee` decimal(18,2) DEFAULT NULL COMMENT '应收商户服务费',
  `repay_date` date DEFAULT NULL COMMENT '计划收款日',
  `real_repay_date` date DEFAULT NULL COMMENT '实际收款/到账日',
  `repay_status` varchar(2) DEFAULT NULL COMMENT '还款状态(0:未到期，1：已逾期，2：正常还款结清，3：提前还款结清，4：逾期还款结清，5：代偿还款结清，5：提前总账务结清，6：坏账，9：代扣中)',
  `overdue_day` varchar(10) DEFAULT NULL COMMENT '逾期天数',
  `service_fee_accu` decimal(18,2) DEFAULT NULL COMMENT '截至当期服务费用总额',
  `punish_fee_accu` decimal(18,2) DEFAULT NULL COMMENT '截至当期罚息费用累计',
  `punish_updated_time` timestamp NULL DEFAULT NULL COMMENT '应收罚息更新时间',
  `created_time` timestamp NULL DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `updated_time` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL COMMENT '状态',
  `service_fee_id` varchar(32) DEFAULT NULL COMMENT '费用id',
  PRIMARY KEY (`id`,`org_id`),
  UNIQUE KEY `ams_account_earnings_index_01` (`bo_id`,`user_id`,`period_num`,`org_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4
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
 PARTITION CHANNLE_2010 VALUES IN (2010) ENGINE = InnoDB,
 PARTITION CHANNLE_1011 VALUES IN (1011) ENGINE = InnoDB,
 PARTITION CHANNLE_1012 VALUES IN (1012) ENGINE = InnoDB,
 PARTITION CHANNLE_1013 VALUES IN (1013) ENGINE = InnoDB,
 PARTITION CHANNLE_1014 VALUES IN (1014) ENGINE = InnoDB,
 PARTITION CHANNLE_1015 VALUES IN (1015) ENGINE = InnoDB,
 PARTITION CHANNLE_1016 VALUES IN (1016) ENGINE = InnoDB,
 PARTITION CHANNLE_1017 VALUES IN (1017) ENGINE = InnoDB,
 PARTITION CHANNLE_1018 VALUES IN (1018) ENGINE = InnoDB,
 PARTITION CHANNLE_1019 VALUES IN (1019) ENGINE = InnoDB,
 PARTITION CHANNLE_1020 VALUES IN (1020) ENGINE = InnoDB) */;


CREATE TABLE `ams_account_earnings_service_fee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `org_id` bigint(20) NOT NULL,
  `service_fee_id` varchar(32) DEFAULT NULL,
  `fee_name` varchar(32) DEFAULT NULL,
  `fee_type` varchar(5) DEFAULT NULL,
  `fee_amount` decimal(18,2) DEFAULT NULL,
  `created_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(20) DEFAULT NULL,
  `updated_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(20) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`,`org_id`),
  KEY `ams_account_earnings_service_fee_index_01` (`service_fee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4
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
 PARTITION CHANNLE_2010 VALUES IN (2010) ENGINE = InnoDB,
 PARTITION CHANNLE_1011 VALUES IN (1011) ENGINE = InnoDB,
 PARTITION CHANNLE_1012 VALUES IN (1012) ENGINE = InnoDB,
 PARTITION CHANNLE_1013 VALUES IN (1013) ENGINE = InnoDB,
 PARTITION CHANNLE_1014 VALUES IN (1014) ENGINE = InnoDB,
 PARTITION CHANNLE_1015 VALUES IN (1015) ENGINE = InnoDB,
 PARTITION CHANNLE_1016 VALUES IN (1016) ENGINE = InnoDB,
 PARTITION CHANNLE_1017 VALUES IN (1017) ENGINE = InnoDB,
 PARTITION CHANNLE_1018 VALUES IN (1018) ENGINE = InnoDB,
 PARTITION CHANNLE_1019 VALUES IN (1019) ENGINE = InnoDB,
 PARTITION CHANNLE_1020 VALUES IN (1020) ENGINE = InnoDB) */;


CREATE TABLE `ams_account_plat_ledger` (
  `id` int(11) NOT NULL,
  `org_id` int(11) NOT NULL,
  `service_fee` decimal(18,2) DEFAULT NULL COMMENT '应收服务总费用',
  `frozen_fee` decimal(18,2) DEFAULT NULL COMMENT '冻结费用',
  `available_fee` decimal(18,2) DEFAULT NULL COMMENT '可用金额',
  `created_time` timestamp NULL DEFAULT NULL,
  `created_by` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  `updated_time` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(20) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`,`org_id`),
  KEY `ams_account_plat_ledger_index_01` (`id`)
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
 PARTITION CHANNLE_2010 VALUES IN (2010) ENGINE = InnoDB,
 PARTITION CHANNLE_1011 VALUES IN (1011) ENGINE = InnoDB,
 PARTITION CHANNLE_1012 VALUES IN (1012) ENGINE = InnoDB,
 PARTITION CHANNLE_1013 VALUES IN (1013) ENGINE = InnoDB,
 PARTITION CHANNLE_1014 VALUES IN (1014) ENGINE = InnoDB,
 PARTITION CHANNLE_1015 VALUES IN (1015) ENGINE = InnoDB,
 PARTITION CHANNLE_1016 VALUES IN (1016) ENGINE = InnoDB,
 PARTITION CHANNLE_1017 VALUES IN (1017) ENGINE = InnoDB,
 PARTITION CHANNLE_1018 VALUES IN (1018) ENGINE = InnoDB,
 PARTITION CHANNLE_1019 VALUES IN (1019) ENGINE = InnoDB,
 PARTITION CHANNLE_1020 VALUES IN (1020) ENGINE = InnoDB) */;


CREATE TABLE `ams_account_plat_ledger_detail` (
  `id` int(11) NOT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `bo_user_id` varchar(32) DEFAULT NULL,
  `bo_id` varchar(32) DEFAULT NULL,
  `contract_no` varchar(32) DEFAULT NULL COMMENT '合同编号（借据编号）注：一个bo_id可能对应多个合同，每个合同独立一个收款计划',
  `period_num` varchar(32) DEFAULT NULL,
  `org_id` int(11) NOT NULL,
  `channel` varchar(1) DEFAULT NULL COMMENT '是否走撮合平台（0：非撮合渠道，1：通过撮合平台）',
  `capital_amount` decimal(18,2) DEFAULT NULL COMMENT '当期应收本金',
  `interest_amount` decimal(18,2) DEFAULT NULL COMMENT '当期应收利息',
  `service_fee` decimal(18,2) DEFAULT NULL COMMENT '应收服务费用',
  `punish_fee` decimal(18,2) DEFAULT NULL COMMENT '应收罚息或违约费用',
  `receipt_date` date DEFAULT NULL COMMENT '计划收款日',
  `real_receipt_date` date DEFAULT NULL COMMENT '实际收款/到账日',
  `receipt_type` varchar(1) DEFAULT NULL COMMENT 'debit/credit',
  `pay_third_channel` varchar(32) DEFAULT NULL COMMENT '代扣支付渠道',
  `pay_third_jnl` varchar(32) DEFAULT NULL COMMENT '代扣支付流水号',
  `plat_receipt_third_channel` varchar(32) DEFAULT NULL COMMENT '平台费用入账支付渠道',
  `plat_receipt_third_jnl` varchar(32) DEFAULT NULL COMMENT '平台费用入账支付流水',
  `receipt_status` varchar(1) DEFAULT NULL COMMENT '收款状态(0:未到帐，1：逾期，2：正常到账，3：提前到账，4：逾期到账，5：提前结清，6：代偿结清，7：坏账，8：债转结清，9：代扣中)',
  `overdue_day` varchar(10) DEFAULT NULL COMMENT '逾期天数',
  `total_capital_left` decimal(18,2) DEFAULT NULL COMMENT '截至当期剩余本金',
  `total_capital_accu` decimal(18,2) DEFAULT NULL COMMENT '截至当期本金金额',
  `interest_accu` decimal(18,2) DEFAULT NULL COMMENT '截至当期利息总额',
  `service_fee_accu` decimal(18,2) DEFAULT NULL COMMENT '截至当期服务费用总额',
  `punish_fee_accu` decimal(18,2) DEFAULT NULL COMMENT '截至当期罚息费用累计',
  `punish_updated_time` timestamp NULL DEFAULT NULL COMMENT '应收罚息更新时间',
  `created_time` timestamp NULL DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `updated_time` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`org_id`),
  KEY `ams_account_plat_ledger_detail_index_01` (`bo_id`)
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
 PARTITION CHANNLE_2010 VALUES IN (2010) ENGINE = InnoDB,
 PARTITION CHANNLE_1011 VALUES IN (1011) ENGINE = InnoDB,
 PARTITION CHANNLE_1012 VALUES IN (1012) ENGINE = InnoDB,
 PARTITION CHANNLE_1013 VALUES IN (1013) ENGINE = InnoDB,
 PARTITION CHANNLE_1014 VALUES IN (1014) ENGINE = InnoDB,
 PARTITION CHANNLE_1015 VALUES IN (1015) ENGINE = InnoDB,
 PARTITION CHANNLE_1016 VALUES IN (1016) ENGINE = InnoDB,
 PARTITION CHANNLE_1017 VALUES IN (1017) ENGINE = InnoDB,
 PARTITION CHANNLE_1018 VALUES IN (1018) ENGINE = InnoDB,
 PARTITION CHANNLE_1019 VALUES IN (1019) ENGINE = InnoDB,
 PARTITION CHANNLE_1020 VALUES IN (1020) ENGINE = InnoDB) */;


CREATE TABLE `ams_account_repay_plan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '还款计划表',
  `user_id` varchar(32) DEFAULT NULL COMMENT '借款人帐号',
  `bo_id` varchar(32) DEFAULT NULL COMMENT '借款编号',
  `period_num` varchar(32) DEFAULT NULL,
  `org_id` bigint(20) NOT NULL COMMENT '商户（渠道）编码',
  `channel` varchar(1) DEFAULT NULL COMMENT '是否走撮合平台（0：非撮合渠道，1：通过撮合平台）',
  `capital_amount` decimal(18,2) DEFAULT NULL COMMENT '当期应还本金',
  `interest_amount` decimal(18,2) DEFAULT NULL COMMENT '当期应还利息',
  `service_fee` decimal(18,2) DEFAULT NULL COMMENT '相关服务费用',
  `punish_fee` decimal(18,2) DEFAULT NULL COMMENT '罚息或违约费用',
  `punish_fee_owner` varchar(1) DEFAULT NULL COMMENT '罚息或违约金归属（1：平台，2：资金方）',
  `repay_date` date DEFAULT NULL COMMENT '计划还款日',
  `real_repay_date` date DEFAULT NULL COMMENT '实际还款/扣款日',
  `repay_status` varchar(1) DEFAULT NULL COMMENT '还款状态(0:未到期，1：已逾期，2：正常还款结清，3：提前还款结清，4：逾期还款结清，5：代偿还款结清，5：提前总账务结清，6：坏账，9：代扣中)',
  `overdue_day` varchar(10) DEFAULT NULL COMMENT '逾期天数',
  `return_amount` decimal(18,2) DEFAULT NULL COMMENT '使用减息券等返还借入客户的资金',
  `total_capital_left` decimal(18,2) DEFAULT NULL COMMENT '截至当期剩余本金',
  `total_capital_accu` decimal(18,2) DEFAULT NULL COMMENT '截至当期累计已还本金金额',
  `interest_accu` decimal(18,2) DEFAULT NULL COMMENT '截至当期累计已还利息总额',
  `service_fee_accu` decimal(18,2) DEFAULT NULL COMMENT '截至当期服务费用总额',
  `punish_fee_accu` decimal(18,2) DEFAULT NULL COMMENT '截至当期罚息费用总额',
  `punish_updated_time` timestamp NULL DEFAULT NULL COMMENT '罚息更新时间',
  `created_time` timestamp NULL DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `updated_time` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL COMMENT '状态',
  `service_fee_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`,`org_id`),
  UNIQUE KEY `ams_account_repay_plan_index_01` (`bo_id`,`user_id`,`period_num`,`org_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4
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
 PARTITION CHANNLE_2010 VALUES IN (2010) ENGINE = InnoDB,
 PARTITION CHANNLE_1011 VALUES IN (1011) ENGINE = InnoDB,
 PARTITION CHANNLE_1012 VALUES IN (1012) ENGINE = InnoDB,
 PARTITION CHANNLE_1013 VALUES IN (1013) ENGINE = InnoDB,
 PARTITION CHANNLE_1014 VALUES IN (1014) ENGINE = InnoDB,
 PARTITION CHANNLE_1015 VALUES IN (1015) ENGINE = InnoDB,
 PARTITION CHANNLE_1016 VALUES IN (1016) ENGINE = InnoDB,
 PARTITION CHANNLE_1017 VALUES IN (1017) ENGINE = InnoDB,
 PARTITION CHANNLE_1018 VALUES IN (1018) ENGINE = InnoDB,
 PARTITION CHANNLE_1019 VALUES IN (1019) ENGINE = InnoDB,
 PARTITION CHANNLE_1020 VALUES IN (1020) ENGINE = InnoDB) */;


CREATE TABLE `ams_account_repay_serial` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `serial_number` varchar(32) DEFAULT NULL COMMENT '流水号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '借款人帐号',
  `bo_id` varchar(32) DEFAULT NULL COMMENT '借款编号',
  `period_num` varchar(32) DEFAULT NULL COMMENT '期数编号',
  `org_id` bigint(20) NOT NULL COMMENT '商户（渠道）编码',
  `capital_amount` decimal(18,2) DEFAULT NULL COMMENT '当期应还本金',
  `interest_amount` decimal(18,2) DEFAULT NULL COMMENT '当期应还利息',
  `repay_status` varchar(2) DEFAULT NULL COMMENT '还款状态(0:还款失败，1：还款成功，2：还款中)',
  `repay_amount` decimal(18,2) DEFAULT NULL COMMENT '还款金额',
  `repay_time` datetime DEFAULT NULL COMMENT '还款时间',
  `created_time` datetime DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `repay_type` varchar(2) DEFAULT NULL COMMENT '还款类型：ALLPRE_REPAYED("1", "借款人全额提前还款账务结清"),',
  `status` varchar(2) DEFAULT NULL COMMENT '状态(0-更新失败；1-更新成功)',
  `remark` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`,`org_id`),
  KEY `ams_account_repay_index_01` (`serial_number`),
  KEY `ams_account_repay_index_02` (`bo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4
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
 PARTITION CHANNLE_2010 VALUES IN (2010) ENGINE = InnoDB,
 PARTITION CHANNLE_1011 VALUES IN (1011) ENGINE = InnoDB,
 PARTITION CHANNLE_1012 VALUES IN (1012) ENGINE = InnoDB,
 PARTITION CHANNLE_1013 VALUES IN (1013) ENGINE = InnoDB,
 PARTITION CHANNLE_1014 VALUES IN (1014) ENGINE = InnoDB,
 PARTITION CHANNLE_1015 VALUES IN (1015) ENGINE = InnoDB,
 PARTITION CHANNLE_1016 VALUES IN (1016) ENGINE = InnoDB,
 PARTITION CHANNLE_1017 VALUES IN (1017) ENGINE = InnoDB,
 PARTITION CHANNLE_1018 VALUES IN (1018) ENGINE = InnoDB,
 PARTITION CHANNLE_1019 VALUES IN (1019) ENGINE = InnoDB,
 PARTITION CHANNLE_1020 VALUES IN (1020) ENGINE = InnoDB) */;


CREATE TABLE `ams_account_repay_service_fee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `org_id` bigint(20) NOT NULL,
  `service_fee_id` varchar(32) DEFAULT NULL,
  `fee_name` varchar(32) DEFAULT NULL,
  `fee_type` varchar(5) DEFAULT NULL,
  `fee_amount` decimal(18,2) DEFAULT NULL,
  `created_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(20) DEFAULT NULL,
  `updated_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` varchar(20) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`,`org_id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8mb4
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
 PARTITION CHANNLE_2010 VALUES IN (2010) ENGINE = InnoDB,
 PARTITION CHANNLE_1011 VALUES IN (1011) ENGINE = InnoDB,
 PARTITION CHANNLE_1012 VALUES IN (1012) ENGINE = InnoDB,
 PARTITION CHANNLE_1013 VALUES IN (1013) ENGINE = InnoDB,
 PARTITION CHANNLE_1014 VALUES IN (1014) ENGINE = InnoDB,
 PARTITION CHANNLE_1015 VALUES IN (1015) ENGINE = InnoDB,
 PARTITION CHANNLE_1016 VALUES IN (1016) ENGINE = InnoDB,
 PARTITION CHANNLE_1017 VALUES IN (1017) ENGINE = InnoDB,
 PARTITION CHANNLE_1018 VALUES IN (1018) ENGINE = InnoDB,
 PARTITION CHANNLE_1019 VALUES IN (1019) ENGINE = InnoDB,
 PARTITION CHANNLE_1020 VALUES IN (1020) ENGINE = InnoDB) */;

-- ----------------------------
-- Table structure for ams_customer_info
-- ----------------------------
DROP TABLE IF EXISTS `ams_customer_info`;
CREATE TABLE `ams_customer_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(32) NOT NULL COMMENT '客户帐号',
  `user_name` varchar(10) DEFAULT NULL COMMENT '客户姓名',
  `gender` varchar(2) DEFAULT NULL COMMENT ' ManGender("1","男"),',
  `id_type` varchar(2) DEFAULT NULL COMMENT '  ShengFen("1","身份证")',
  `id_no` varchar(32) DEFAULT NULL,
  `org_id` bigint(20) NOT NULL,
  `org_auth_type` varchar(2) DEFAULT NULL COMMENT '认证类型（证件类型。。。）',
  `mobile` varchar(20) DEFAULT NULL,
  `bank_code` varchar(32) DEFAULT NULL COMMENT '第一次平台交易验证银行卡对应银行行号',
  `card_no` varchar(32) DEFAULT NULL COMMENT '第一次平台交易验证银行卡卡号',
  `email` varchar(32) DEFAULT NULL,
  `home_address` varchar(100) DEFAULT NULL COMMENT '住宅详细地址',
  `home_phone` varchar(20) DEFAULT NULL,
  `con_address` varchar(100) DEFAULT NULL COMMENT '通讯地址',
  `con_zipcode` varchar(32) DEFAULT NULL,
  `qualification` varchar(32) DEFAULT NULL COMMENT '教育程度（最高学历）',
  `degree` varchar(32) DEFAULT NULL COMMENT '学位',
  `graduate_inst` varchar(32) DEFAULT NULL COMMENT '毕业院校',
  `graduate_year` varchar(32) DEFAULT NULL,
  `socail_identity` varchar(10) DEFAULT NULL,
  `years_of_work` varchar(10) DEFAULT NULL,
  `emp_name` varchar(32) DEFAULT NULL,
  `emp_structure` varchar(2) DEFAULT NULL,
  `emp_type` varchar(2) DEFAULT NULL COMMENT '单位行业类别',
  `emp_postition` varchar(32) DEFAULT NULL,
  `emp_title` varchar(32) DEFAULT NULL COMMENT '当前职称',
  `emp_phone` varchar(20) DEFAULT NULL,
  `emp_province` varchar(32) DEFAULT NULL COMMENT '社会身份',
  `emp_city` varchar(32) DEFAULT NULL,
  `emp_zone` varchar(32) DEFAULT NULL COMMENT '单位所在区',
  `emp_address` varchar(100) DEFAULT NULL,
  `marital_status` varchar(2) DEFAULT NULL COMMENT '婚姻状况',
  `child_status` varchar(2) DEFAULT NULL COMMENT '子女状况',
  `house_condition` varchar(2) DEFAULT NULL,
  `contact_name` varchar(10) DEFAULT NULL COMMENT '联系人姓名',
  `contact_relation` varchar(10) DEFAULT NULL COMMENT '联系人和客户关系',
  `contact_mobile` varchar(20) DEFAULT NULL COMMENT '联系人姓名',
  `created_time` timestamp NULL DEFAULT NULL,
  `created_by` varchar(20) DEFAULT NULL COMMENT '客户信息表',
  `updated_time` timestamp NULL DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL,
  `status` varchar(2) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`,`org_id`),
  KEY `ams_customer_info_index_01` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COMMENT='客户信息表'
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

