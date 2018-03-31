/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : railway_labor

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-03-24 14:36:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_career_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_career_info`;
CREATE TABLE `t_career_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `employee_id` bigint(20) DEFAULT NULL COMMENT '员工id',
  `type_of_work` varchar(10) DEFAULT NULL COMMENT '岗位/工种',
  `sequence_old` varchar(15) DEFAULT NULL COMMENT '原所属序列',
  `grade_old` varchar(10) DEFAULT NULL COMMENT '原评定等级',
  `star_detail` varchar(10) DEFAULT NULL COMMENT '岗位星级详情',
  `star_integral` varchar(10) DEFAULT NULL COMMENT '岗位星级积分',
  `skill_detail` varchar(10) DEFAULT NULL COMMENT '技能等级/职称详情',
  `skill_integral` varchar(10) DEFAULT NULL COMMENT '技能等级/职称积分',
  `fault_detail` varchar(10) DEFAULT NULL COMMENT '发现故障详情',
  `fault_integral` varchar(10) DEFAULT NULL COMMENT '发现故障积分',
  `project_detail` varchar(10) DEFAULT NULL COMMENT '课题成果详情',
  `project_integral` varchar(10) DEFAULT NULL COMMENT '课题成果积分',
  `honor_detail` varchar(10) DEFAULT NULL COMMENT '个人荣誉详情',
  `honor_integral` varchar(10) DEFAULT NULL COMMENT '个人荣誉积分',
  `quasirating` varchar(10) DEFAULT NULL COMMENT '拟晋升等级',
  `remarks` text,
  `creator` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='职业生涯信息表';

-- ----------------------------
-- Records of t_career_info
-- ----------------------------
INSERT INTO `t_career_info` VALUES ('1', '1', '1', '12', '1', null, null, null, null, null, null, null, null, null, null, null, '1', '1', '2018-03-16 00:43:54', '1', '2018-03-16 00:43:59', '0');

-- ----------------------------
-- Table structure for `t_department`
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(20) DEFAULT NULL COMMENT '部门名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父部门id',
  `descr` varchar(50) DEFAULT NULL COMMENT '部门描述',
  `remarks` text,
  `creator` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='员工部门表';

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '1', '1', '12', '1', '1', '2018-03-16 00:43:54', '1', '2018-03-16 00:43:59', '0');

-- ----------------------------
-- Table structure for `t_employee`
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `job_number` varchar(10) DEFAULT NULL COMMENT '工号',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `team_id` bigint(20) DEFAULT NULL COMMENT '组id',
  `position_id` bigint(20) DEFAULT NULL COMMENT '职务id',
  `remarks` text COMMENT '备注',
  `creator` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='员工表';

-- ----------------------------
-- Records of t_employee
-- ----------------------------
INSERT INTO `t_employee` VALUES ('1', '1', '1', '123', '1', '1', '1', '2018-03-16 00:43:54', '1', '2018-03-16 00:43:59', '0');

-- ----------------------------
-- Table structure for `t_evaluation_abrogate`
-- ----------------------------
DROP TABLE IF EXISTS `t_evaluation_abrogate`;
CREATE TABLE `t_evaluation_abrogate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `employee_id` bigint(20) DEFAULT NULL COMMENT '员工id',
  `no_comment_condition` varchar(10) DEFAULT NULL COMMENT '不参评条件',
  `evaluate_date` varchar(10) DEFAULT NULL COMMENT '评定日期',
  `remarks` text,
  `creator` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='不参评表';

-- ----------------------------
-- Records of t_evaluation_abrogate
-- ----------------------------
INSERT INTO `t_evaluation_abrogate` VALUES ('1', '1', null, null, '1', '1', '2018-03-16 00:43:54', '1', '2018-03-16 00:43:59', '0');

-- ----------------------------
-- Table structure for `t_evaluation_condition`
-- ----------------------------
DROP TABLE IF EXISTS `t_evaluation_condition`;
CREATE TABLE `t_evaluation_condition` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(20) DEFAULT NULL COMMENT '条件名称',
  `content` varchar(100) DEFAULT NULL COMMENT '条件',
  `remarks` text,
  `creator` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='评定条件表';

-- ----------------------------
-- Records of t_evaluation_condition
-- ----------------------------
INSERT INTO `t_evaluation_condition` VALUES ('1', '1', '1', '1', '1', '2018-03-16 00:43:54', '1', '2018-03-16 00:43:59', '0');

-- ----------------------------
-- Table structure for `t_evaluation_normal`
-- ----------------------------
DROP TABLE IF EXISTS `t_evaluation_normal`;
CREATE TABLE `t_evaluation_normal` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `employee_id` bigint(20) DEFAULT NULL COMMENT '员工id',
  `score_type` varchar(10) DEFAULT NULL COMMENT '积分分类',
  `score_name` varchar(10) DEFAULT NULL COMMENT '积分名称',
  `first_level` varchar(10) DEFAULT NULL COMMENT '一级标准',
  `second_level` varchar(10) DEFAULT NULL COMMENT '二级标准',
  `score_content` varchar(10) DEFAULT NULL COMMENT '积分内容',
  `score` varchar(10) DEFAULT NULL COMMENT '积分分数',
  `evaluate_date` varchar(10) DEFAULT NULL COMMENT '评定日期',
  `remarks` text,
  `creator` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='参评表';

-- ----------------------------
-- Records of t_evaluation_normal
-- ----------------------------
INSERT INTO `t_evaluation_normal` VALUES ('1', '1', null, null, null, null, null, null, null, '1', '1', '2018-03-16 00:43:54', '1', '2018-03-16 00:43:59', '0');

-- ----------------------------
-- Table structure for `t_evaluation_promote`
-- ----------------------------
DROP TABLE IF EXISTS `t_evaluation_promote`;
CREATE TABLE `t_evaluation_promote` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `employee_id` bigint(20) DEFAULT NULL COMMENT '员工id',
  `promote_condition` varchar(10) DEFAULT NULL COMMENT '破格条件',
  `evaluate_date` varchar(10) DEFAULT NULL COMMENT '评定日期',
  `remarks` text,
  `creator` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='破格表';

-- ----------------------------
-- Records of t_evaluation_promote
-- ----------------------------
INSERT INTO `t_evaluation_promote` VALUES ('1', '1', null, null, '1', '1', '2018-03-16 00:43:54', '1', '2018-03-16 00:43:59', '0');

-- ----------------------------
-- Table structure for `t_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(10) DEFAULT NULL COMMENT '权限名称',
  `type` varchar(10) DEFAULT NULL COMMENT '权限类型',
  `value` varchar(15) DEFAULT NULL COMMENT '权限值',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父权限id',
  `level` varchar(20) DEFAULT NULL COMMENT '层级',
  `order` tinyint(4) DEFAULT NULL COMMENT '排序',
  `descr` varchar(50) DEFAULT NULL COMMENT '权限描述',
  `remarks` text,
  `creator` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', '1', '1', '12', '1', '123', null, null, '1', '1', '2018-03-16 00:43:54', '1', '2018-03-16 00:43:59', '0');

-- ----------------------------
-- Table structure for `t_position`
-- ----------------------------
DROP TABLE IF EXISTS `t_position`;
CREATE TABLE `t_position` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(20) DEFAULT NULL COMMENT '职务名称',
  `descr` varchar(50) DEFAULT NULL COMMENT '职务描述',
  `remarks` text,
  `creator` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='职务表';

-- ----------------------------
-- Records of t_position
-- ----------------------------
INSERT INTO `t_position` VALUES ('1', '1', '12', '1', '1', '2018-03-16 00:43:54', '1', '2018-03-16 00:43:59', '0');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `parent_id` bigint(10) DEFAULT NULL COMMENT '父角色id',
  `descr` varchar(50) DEFAULT NULL COMMENT '角色描述',
  `remarks` text,
  `creator` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', '1', '1', '12', '1', '1', '2018-03-16 00:43:54', '1', '2018-03-16 00:43:59', '0');

-- ----------------------------
-- Table structure for `t_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id',
  `permission_id` bigint(20) DEFAULT NULL COMMENT '权限id',
  `remarks` text,
  `creator` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色-权限表';

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('1', '1', '1', '1', '1', '2018-03-16 00:43:54', '1', '2018-03-16 00:43:59', '0');

-- ----------------------------
-- Table structure for `t_sys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dict`;
CREATE TABLE `t_sys_dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(10) DEFAULT NULL COMMENT '名称',
  `key` varchar(10) DEFAULT NULL COMMENT '键',
  `value` varchar(15) DEFAULT NULL COMMENT '值',
  `type` varchar(20) DEFAULT NULL COMMENT '类型',
  `level` varchar(32) DEFAULT NULL COMMENT '层级',
  `group` varchar(20) DEFAULT NULL COMMENT '分组',
  `remarks` text,
  `creator` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of t_sys_dict
-- ----------------------------
INSERT INTO `t_sys_dict` VALUES ('1', '1', '1', '12', '123', '1', null, '1', '1', '2018-03-16 00:43:54', '1', '2018-03-16 00:43:59', '0');

-- ----------------------------
-- Table structure for `t_team`
-- ----------------------------
DROP TABLE IF EXISTS `t_team`;
CREATE TABLE `t_team` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(20) DEFAULT NULL COMMENT '组名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父组id',
  `department_id` bigint(20) DEFAULT NULL COMMENT '部门id',
  `descr` varchar(50) DEFAULT NULL COMMENT '组描述',
  `remarks` text,
  `creator` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='组表';

-- ----------------------------
-- Records of t_team
-- ----------------------------
INSERT INTO `t_team` VALUES ('1', '1', '1', null, '12', '1', '1', '2018-03-16 00:43:54', '1', '2018-03-16 00:43:59', '0');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(10) DEFAULT NULL,
  `account` varchar(10) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `remarks` text,
  `creator` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '1', '1', '12', '123', '1', '1', '1', '2018-03-16 00:43:54', '1', '2018-03-16 00:43:59', '0');

-- ----------------------------
-- Table structure for `t_user_permission`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_permission`;
CREATE TABLE `t_user_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `permission_id` bigint(10) DEFAULT NULL COMMENT '权限id',
  `remarks` text,
  `creator` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户-权限表';

-- ----------------------------
-- Records of t_user_permission
-- ----------------------------
INSERT INTO `t_user_permission` VALUES ('1', '1', '1', '1', '1', '2018-03-16 00:43:54', '1', '2018-03-16 00:43:59', '0');

-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(10) DEFAULT NULL COMMENT '角色id',
  `remarks` text,
  `creator` bigint(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户-角色表';

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1', '1', '1', '1', '2018-03-16 00:43:54', '1', '2018-03-16 00:43:59', '0');
