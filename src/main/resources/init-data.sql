BEGIN;
INSERT INTO `sys_dictionary_type` VALUES (1, '系统', 'system', 0, '1', '2020-05-06 10:20:27', '1', '2020-05-06 10:20:33');
INSERT INTO `sys_dictionary` VALUES (1, 'system', '默认密码', 'jdauto123456', 'default_password', 0, '1', '2020-05-06 10:21:20', '1', '2020-05-06 10:21:25');

INSERT INTO `sys_employee` (`id`,`login_name`,`password`,`name`,`code`,`type`,`is_enabled`,`is_build_in`,`is_deleted`,`sex`,`email`,`mobile`,`organization_ids`,`organization_names`,`created_by`,`created_time`,`updated_by`,`updated_time`) VALUES (1,'jdauto_admin','','系统管理员','system',1,1,1,0,0,'','','','','1','2020-04-24 10:39:03','1','2020-04-28 17:42:23');
INSERT INTO `sys_employee` (`id`,`login_name`,`password`,`name`,`code`,`type`,`is_enabled`,`is_build_in`,`is_deleted`,`sex`,`email`,`mobile`,`organization_ids`,`organization_names`,`created_by`,`created_time`,`updated_by`,`updated_time`) VALUES (2,'jdauto_task','','任务调用用户','task',1,1,1,0,0,'','','','','1','2020-04-24 10:39:03','1','2020-04-28 17:42:23');
INSERT INTO `sys_employee` (`id`,`login_name`,`password`,`name`,`code`,`type`,`is_enabled`,`is_build_in`,`is_deleted`,`sex`,`email`,`mobile`,`organization_ids`,`organization_names`,`created_by`,`created_time`,`updated_by`,`updated_time`) VALUES (3,'jdauto_api','','API','api',1,1,1,0,0,'','','','','1','2020-04-24 10:39:03','1','2020-04-28 17:42:23');
COMMIT;