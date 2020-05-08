
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary`;
CREATE TABLE `sys_dictionary` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `type` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '字典类型值',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '字典数据名称',
  `value` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '字典数据值',
  `key_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '唯一标识',
  `order_num` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '序号',
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '创建人',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '更新人',
  `updated_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_key_type` (`key_name`,`type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='数据字典对应值';

-- ----------------------------
-- Table structure for sys_dictionary_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionary_type`;
CREATE TABLE `sys_dictionary_type` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '类型名称',
  `type` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '字典类型',
  `order_num` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '序号',
  `created_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '创建人',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '更新人',
  `updated_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_value` (`type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='数据字典类型表';

-- ----------------------------
-- Table structure for sys_employee
-- ----------------------------
DROP TABLE IF EXISTS `sys_employee`;
CREATE TABLE `sys_employee` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `login_name` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '登录名称',
  `password` varchar(400) COLLATE utf8_bin NOT NULL COMMENT '登录密码',
  `name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '员工姓名',
  `code` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '员工code',
  `type` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '用户类型',
  `is_enabled` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '是否启用',
  `is_build_in` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否内置员工',
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '是否删除',
  `sex` tinyint(4) unsigned NOT NULL DEFAULT '0' COMMENT '员工性别',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '员工邮箱',
  `mobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '手机号码',
  `organization_ids` text CHARACTER SET utf8 COLLATE utf8_bin COMMENT '所属组织id列表，以逗号分隔',
  `organization_names` text CHARACTER SET utf8 COLLATE utf8_bin COMMENT '组织名称列表，以逗号分隔',
  `created_by` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_by` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '更新人',
  `updated_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_code` (`code`) USING BTREE COMMENT '角色code唯一键',
  UNIQUE KEY `uk_login_name` (`login_name`) USING BTREE COMMENT '登录名称唯一键',
  UNIQUE KEY `uk_email` (`email`) COMMENT '邮箱唯一键',
  UNIQUE KEY `uk_mobile` (`mobile`) COMMENT '手机号码唯一键'
) ENGINE=InnoDB AUTO_INCREMENT=100  DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='员工';

-- ----------------------------
-- Table structure for sys_employee_organization_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_employee_organization_relation`;
CREATE TABLE `sys_employee_organization_relation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `employee_id` bigint(20) unsigned NOT NULL COMMENT '员工id',
  `organization_id` bigint(20) unsigned NOT NULL COMMENT '组织id',
  `created_by` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_by` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '更新人',
  `updated_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='员工组织关系';

-- ----------------------------
-- Table structure for sys_employee_privilege_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_employee_privilege_relation`;
CREATE TABLE `sys_employee_privilege_relation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户权限id',
  `employee_id` bigint(20) unsigned NOT NULL COMMENT '员工id',
  `privilege_id` bigint(20) unsigned NOT NULL COMMENT '权限id',
  `type` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '权限类型（0添加1删除）',
  `created_by` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_by` varchar(0) COLLATE utf8_bin NOT NULL COMMENT '更新人',
  `updated_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='员工权限表';

-- ----------------------------
-- Table structure for sys_employee_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_employee_role_relation`;
CREATE TABLE `sys_employee_role_relation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '员工角色id',
  `employee_id` bigint(20) unsigned NOT NULL COMMENT '员工id',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色id',
  `created_by` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_by` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '更新人',
  `updated_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户角色';

-- ----------------------------
-- Table structure for sys_employee_social_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_employee_social_relation`;
CREATE TABLE `sys_employee_social_relation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `employee_id` bigint(20) unsigned NOT NULL COMMENT '员工id',
  `provider_id` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '供应商id',
  `provider_user_id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '供应商用户id',
  `created_by` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_by` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '更新人',
  `updated_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_employee_id_provider_id_provider_user_id` (`employee_id`,`provider_id`,`provider_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='员工三方登录对应关系表';

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `parent_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT '父id，为0代表root节点',
  `code` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '组织代码',
  `name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '组织名称',
  `order_num` int(11) NOT NULL DEFAULT '0' COMMENT '排序编号',
  `description` text COLLATE utf8_bin COMMENT '组织描述',
  `parent_ids` text COLLATE utf8_bin NOT NULL COMMENT '父id组织列表，以'',''进行分割',
  `is_enabled` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '是否启用',
  `created_by` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_by` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '修改人',
  `updated_time` datetime NOT NULL COMMENT '修改时间',
  `dms_ref_id` varchar(36) COLLATE utf8_bin DEFAULT NULL COMMENT 'dms关联组织id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_code` (`code`) USING BTREE COMMENT '组织code唯一',
  KEY `idx_parent_id` (`parent_id`) USING BTREE COMMENT '父组织id索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='系统组织';

-- ----------------------------
-- Table structure for sys_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_privilege`;
CREATE TABLE `sys_privilege` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `parent_id` bigint(20) NOT NULL COMMENT '父级别id',
  `code` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '权限code',
  `type` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '权限类型（0菜单、1按钮）',
  `name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '权限名称',
  `description` varchar(400) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '权限描述',
  `order_num` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '排序编号',
  `created_by` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_by` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '更新人',
  `updated_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_code` (`code`) COMMENT '权限code唯一键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='权限表';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '角色名称',
  `code` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '角色code',
  `description` varchar(400) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '角色描述',
  `is_enabled` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '是否内置',
  `created_by` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_by` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '更新人',
  `updated_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_code` (`code`) USING BTREE COMMENT '角色唯一code'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色';

-- ----------------------------
-- Table structure for sys_role_organization_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_organization_relation`;
CREATE TABLE `sys_role_organization_relation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色id',
  `organization_id` bigint(20) unsigned NOT NULL COMMENT '组织id',
  `created_by` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_by` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '修改人',
  `updated_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色组织关系表';

-- ----------------------------
-- Table structure for sys_role_privilege_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_privilege_relation`;
CREATE TABLE `sys_role_privilege_relation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色权限id',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色id',
  `privilege_id` bigint(20) unsigned NOT NULL COMMENT '权限id',
  `created_by` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '创建人',
  `created_time` datetime NOT NULL COMMENT '创建时间',
  `updated_by` varchar(36) COLLATE utf8_bin NOT NULL COMMENT '更新人',
  `updated_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色权限关系表';

SET FOREIGN_KEY_CHECKS = 1;
