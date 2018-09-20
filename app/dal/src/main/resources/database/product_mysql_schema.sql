-- --------------------------
-- 产品表
-- --------------------------
CREATE TABLE ams_product_dict (
 `id` BIGINT NOT NULL AUTO_INCREMENT,
 `dict_name` VARCHAR(32) NOT NULL COMMENT '字典名称',
 `key` VARCHAR(20) NOT NULL COMMENT '键',
 `value` VARCHAR(32) NOT NULL COMMENT '值',
 `remark` VARCHAR(100) COMMENT '备注',
 `creater` VARCHAR(18) COMMENT '创建人',
 `modifier` VARCHAR(18) COMMENT '修改人',
 `create_time` DATETIME NOT NULL COMMENT '创建时间',
 `modify_time` DATETIME COMMENT '修改时间',
 PRIMARY KEY (`id`),
 KEY ams_product_dict_index_01 (`dict_name`, `key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='产品字典表';

CREATE TABLE ams_product_info (
 `id` BIGINT NOT NULL AUTO_INCREMENT,
 `product_id` BIGINT NOT NULL COMMENT '产品编号',
 `product_owner_id` BIGINT NOT NULL COMMENT '产品归属(资产方，资金方org_id)',
 `merchant_id` BIGINT COMMENT '商户编号',
 `merchant_type` BIGINT COMMENT '商户类型',
 `deadline` INT(3) COMMENT '产品期限（期数）',
 `fine_rate` VARCHAR(5) COMMENT '罚息利率',
 `grace_days` INT(2) COMMENT '最大宽限天数',
 `assets_rate` VARCHAR(5)  COMMENT '资产商户利率',
 `fund_rate` VARCHAR(5)  COMMENT '资金商户利率',
 `create_time` DATETIME NULL ,
 `modify_time` DATETIME NULL ,
 PRIMARY KEY (`id`),
 UNIQUE KEY ams_product_info_index_01 (`product_id`),
 KEY ams_product_info_index_02 (`merchant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='产品信息';

CREATE TABLE ams_product_item (
 `id` BIGINT NOT NULL AUTO_INCREMENT,
 `product_code` VARCHAR(32) NOT NULL COMMENT '产品代码',
 `product_detail` VARCHAR(50) COMMENT '产品描述',
 `product_type` VARCHAR(2) NOT NULL COMMENT '产品类型',
 `status` VARCHAR(2) NOT NULL COMMENT '产品状态【激活，未激活，逻辑删除】',
 `creater` VARCHAR(18) COMMENT '创建人',
 `modifier` VARCHAR(18) COMMENT '修改人',
 `create_time` DATETIME NOT NULL COMMENT '创建时间',
 `modify_time` DATETIME COMMENT '修改时间',
 PRIMARY KEY (`id`),
 UNIQUE KEY ams_product_item_index_01 (`product_code`),
 KEY ams_product_item_index_02 (`product_type`),
 KEY ams_product_item_index_03 (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='产品项目';

CREATE TABLE ams_product_limit (
 `id` BIGINT NOT NULL AUTO_INCREMENT,
 `product_id` BIGINT NOT NULL COMMENT '产品编号',
 `product_limit` BIGINT NOT NULL COMMENT '产品限额',
 `product_limit_type` VARCHAR(2) NOT NULL COMMENT '产品限额类型',
 `create_time` DATETIME NOT NULL COMMENT '创建时间',
 `modify_time` DATETIME COMMENT '修改时间',
 PRIMARY KEY (`id`),
 KEY ams_product_limit_index_01 (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='产品限额';

CREATE TABLE ams_product_rate_info (
 `id` BIGINT NOT NULL AUTO_INCREMENT,
 `product_id` BIGINT NOT NULL COMMENT '产品编号',
 `product_rate` VARCHAR(10) NOT NULL COMMENT '产品费率',
 `rate_type` VARCHAR(2) NOT NULL COMMENT '费率类型',
 `remark` VARCHAR(20) COMMENT '备注',
 `create_time` DATETIME NOT NULL COMMENT '创建时间',
 `modify_time` DATETIME COMMENT '修改时间',
 PRIMARY KEY (`id`),
 KEY ams_product_rate_info_index_01 (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='产品利率表';