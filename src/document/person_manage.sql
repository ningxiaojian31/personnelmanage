/*
Navicat MySQL Data Transfer

Source Server         : 47.107.126.98_3306
Source Server Version : 50724
Source Host           : 47.107.126.98:3306
Source Database       : person_manage

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-03-26 22:10:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `sign` int(11) NOT NULL COMMENT '标记是系统管理员1   还是人事管理员2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='管理员表';

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'ning', '123456', '2');
INSERT INTO `admin` VALUES ('2', 'admin', '123456', '1');

-- ----------------------------
-- Table structure for `birthday_record`
-- ----------------------------
DROP TABLE IF EXISTS `birthday_record`;
CREATE TABLE `birthday_record` (
  `bir_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `bir_type` varchar(12) DEFAULT NULL COMMENT '头胎还是其他胎',
  `bir_prod_insp_hos` varchar(32) DEFAULT NULL COMMENT '产检医院',
  `bir_mater_hos` varchar(32) DEFAULT NULL COMMENT '分娩医院',
  `bir_number` varchar(32) DEFAULT NULL COMMENT '计生证号码',
  `bir_operation_time` date DEFAULT NULL COMMENT '手术日期',
  `emp_id` int(11) NOT NULL COMMENT '员工外键',
  PRIMARY KEY (`bir_id`),
  KEY `bir_emp_id` (`emp_id`),
  CONSTRAINT `bir_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employee_info` (`emp_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='生育纪录表';

-- ----------------------------
-- Records of birthday_record
-- ----------------------------

-- ----------------------------
-- Table structure for `certificates_info`
-- ----------------------------
DROP TABLE IF EXISTS `certificates_info`;
CREATE TABLE `certificates_info` (
  `cer_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `heal_start_time` date DEFAULT NULL COMMENT '健康证办理时间',
  `heal_end_time` date DEFAULT NULL COMMENT '健康证到期时间',
  `heal_organize` varchar(32) DEFAULT NULL COMMENT '健康证机构',
  `heal_have` int(4) DEFAULT NULL COMMENT '健康证是否持有原件 1只有 0没有',
  `fp_number` int(11) NOT NULL COMMENT '计生证编号',
  `fp_household` varchar(32) DEFAULT NULL COMMENT '计生证户籍地',
  `fp_step` varchar(64) DEFAULT NULL COMMENT '计生证避孕措施',
  `fp_place` varchar(255) DEFAULT NULL COMMENT '计生证居住地',
  `fp_phone` varchar(32) DEFAULT NULL COMMENT '计生部门电话',
  `fp_valid_time` varchar(12) DEFAULT NULL COMMENT '计生证有效时间',
  `cer_sign` int(4) NOT NULL COMMENT '标记是健康证还是计生证 1健康 2计生',
  `emp_id` int(11) NOT NULL COMMENT '员工外键',
  PRIMARY KEY (`cer_id`),
  KEY `cer_emp_id` (`emp_id`),
  CONSTRAINT `cer_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employee_info` (`emp_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='证件情况表';

-- ----------------------------
-- Records of certificates_info
-- ----------------------------

-- ----------------------------
-- Table structure for `contract_sign`
-- ----------------------------
DROP TABLE IF EXISTS `contract_sign`;
CREATE TABLE `contract_sign` (
  `con_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `con_type` varchar(32) NOT NULL COMMENT '合同类型',
  `con_enpire_time` date NOT NULL COMMENT '合同到期时间 (需要合同过期提醒)',
  `con_history` varchar(64) DEFAULT NULL COMMENT '合同历史签订情况',
  `emp_id` int(11) NOT NULL COMMENT '员工外键',
  PRIMARY KEY (`con_id`),
  KEY `con_emp_id` (`emp_id`),
  CONSTRAINT `con_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employee_info` (`emp_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='合同签订情况表';

-- ----------------------------
-- Records of contract_sign
-- ----------------------------

-- ----------------------------
-- Table structure for `employee_card`
-- ----------------------------
DROP TABLE IF EXISTS `employee_card`;
CREATE TABLE `employee_card` (
  `es_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `es_start_time` date NOT NULL COMMENT '工作证办理日期',
  `es_end_time` date NOT NULL COMMENT '工作证过期时间（需要设置提醒）',
  `emp_id` int(11) NOT NULL COMMENT '员工外键',
  PRIMARY KEY (`es_id`),
  KEY `ec_emp_id` (`emp_id`),
  CONSTRAINT `ec_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employee_info` (`emp_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='工作证办理情况表';

-- ----------------------------
-- Records of employee_card
-- ----------------------------

-- ----------------------------
-- Table structure for `employee_info`
-- ----------------------------
DROP TABLE IF EXISTS `employee_info`;
CREATE TABLE `employee_info` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `emp_name` varchar(12) NOT NULL COMMENT '姓名',
  `emp_sex` int(4) NOT NULL COMMENT '性别：1为男，2为女',
  `emp_nation` varchar(6) NOT NULL COMMENT '民族',
  `emp_number` varchar(64) NOT NULL COMMENT '工号',
  `emp_birthday` date NOT NULL COMMENT '生日',
  `emp_card` varchar(255) NOT NULL COMMENT '身份证',
  `emp_marry` int(4) NOT NULL COMMENT '是否结婚 1为已婚 2为未婚',
  `emp_depart` varchar(12) NOT NULL COMMENT '部门',
  `emp_pic` varchar(255) NOT NULL COMMENT '个人照片',
  `emp_position` varchar(24) NOT NULL COMMENT '职位',
  `emp_school` varchar(24) NOT NULL COMMENT '毕业院校',
  `emp_phone` varchar(32) NOT NULL COMMENT '联系电话',
  `emp_email` varchar(32) NOT NULL COMMENT '邮箱',
  `emp_addr` varchar(255) NOT NULL COMMENT '居住地',
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='员工信息表';

-- ----------------------------
-- Records of employee_info
-- ----------------------------
INSERT INTO `employee_info` VALUES ('1', 'Justin', '2', '汉族', '00000', '2019-03-15', '440.2369586631', '1', '研发部', 'http://///', '前端开发', '松田学院', '13189569632', '456314749@qq.com', '广州市');
INSERT INTO `employee_info` VALUES ('2', 'ning', '1', '汉族', '222222', '2019-03-15', '440883199703061916', '2', '研发部', 'http://///', '后台开发', '新华学院', '13189461916', '664650322@qq.com', '麻涌镇');
INSERT INTO `employee_info` VALUES ('3', 'xiao', '2', '汉族', '25696', '2019-03-12', '440886933256985632', '1', '运维部', 'http://www.baidu.com', '运维工程师', '东莞理工', '13256985656', '5563256@qq.com', '松山湖');
INSERT INTO `employee_info` VALUES ('4', 'jkjk', '1', 'sdfdsa', 'asf', '2019-03-06', '440123666666', '1', 'asfsa', 'http://localhost:8080/pic/6d14c03a-6e5a-4dcc-9191-0e7fac0203da.jpg', '21321', '24', '13265986546', '2454564@qq.com', 'jasfjsdj');
INSERT INTO `employee_info` VALUES ('5', 'fdsf', '2', 'asdfsa', 'sfa', '2019-03-06', '46464656464564', '1', 'asf', 'http://localhost:8080/pic/c0226ef8-5c54-4300-bb88-bc607b3bfa55.jpg', 'asf', 'asfd', '13265986545', '5464666@qq.com', 'asdfsa');
INSERT INTO `employee_info` VALUES ('8', 'nin', '1', 'iui', 'kyu', '2019-03-13', 'tjtj', '1', 'hf', 'ghrtgh', 'hh', 'gywre', 'dgd', 'dg', 'dg');

-- ----------------------------
-- Table structure for `family_info`
-- ----------------------------
DROP TABLE IF EXISTS `family_info`;
CREATE TABLE `family_info` (
  `fam_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `fam_name` varchar(24) NOT NULL COMMENT '姓名',
  `fam_relation` varchar(12) DEFAULT NULL COMMENT '关系',
  `fam_sex` int(4) DEFAULT NULL COMMENT '性别 1为男  2为女',
  `fam_work_palce` varchar(255) DEFAULT NULL COMMENT '工作单位',
  `fam_phone` varchar(32) DEFAULT NULL COMMENT '联系电话',
  `fam_sign` int(4) NOT NULL COMMENT '标记是何种情况 1父母 2配偶 3子女 4紧急',
  `emp_id` int(11) NOT NULL COMMENT '员工外键',
  PRIMARY KEY (`fam_id`),
  KEY `fam_emp_id` (`emp_id`),
  CONSTRAINT `fam_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employee_info` (`emp_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='家庭情况表';

-- ----------------------------
-- Records of family_info
-- ----------------------------

-- ----------------------------
-- Table structure for `free_charge`
-- ----------------------------
DROP TABLE IF EXISTS `free_charge`;
CREATE TABLE `free_charge` (
  `free_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `free_type` int(4) NOT NULL COMMENT '原持卡片类型 1临时卡 2钱包卡',
  `free_number` varchar(32) DEFAULT NULL COMMENT '卡号',
  `free_sign` int(4) DEFAULT '0' COMMENT '0默认为新办 1为续办（修改过数据即为续办）',
  `emp_id` int(11) NOT NULL COMMENT '员工外键',
  PRIMARY KEY (`free_id`),
  KEY `free_emp_id` (`emp_id`),
  CONSTRAINT `free_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employee_info` (`emp_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='免搭伙费表';

-- ----------------------------
-- Records of free_charge
-- ----------------------------

-- ----------------------------
-- Table structure for `induction_info`
-- ----------------------------
DROP TABLE IF EXISTS `induction_info`;
CREATE TABLE `induction_info` (
  `ind_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `ind_entry_time` date NOT NULL COMMENT '入职时间',
  `ind_quit_time` date NOT NULL COMMENT '离职时间',
  `ind_entry_history` varchar(255) DEFAULT NULL COMMENT '历史就职纪录',
  `emp_id` int(11) NOT NULL COMMENT '员工外键',
  PRIMARY KEY (`ind_id`),
  KEY `ind_emp_id` (`emp_id`),
  CONSTRAINT `ind_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employee_info` (`emp_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='就职情况表';

-- ----------------------------
-- Records of induction_info
-- ----------------------------

-- ----------------------------
-- Table structure for `professional_skills`
-- ----------------------------
DROP TABLE IF EXISTS `professional_skills`;
CREATE TABLE `professional_skills` (
  `ps_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `ps_info` varchar(24) NOT NULL COMMENT '专业技能',
  `ps_level` varchar(12) NOT NULL COMMENT '技能级别',
  `ps_issue_time` date NOT NULL COMMENT '证书发证日期',
  `ps_number` varchar(64) DEFAULT NULL COMMENT '证书号',
  `emp_id` int(11) NOT NULL COMMENT '员工外键',
  PRIMARY KEY (`ps_id`),
  KEY `pro_emp_id` (`emp_id`),
  CONSTRAINT `pro_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employee_info` (`emp_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='员工相关专业技能证书档案表';

-- ----------------------------
-- Records of professional_skills
-- ----------------------------

-- ----------------------------
-- Table structure for `provident_fund_purchase`
-- ----------------------------
DROP TABLE IF EXISTS `provident_fund_purchase`;
CREATE TABLE `provident_fund_purchase` (
  `pfp_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `pfp_start_time` date NOT NULL COMMENT '公积金购买时间',
  `pfp_end_time` date NOT NULL COMMENT '公积金停买时间',
  `emp_id` int(11) NOT NULL COMMENT '员工外键',
  PRIMARY KEY (`pfp_id`),
  KEY `pfp_emp_id` (`emp_id`),
  CONSTRAINT `pfp_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employee_info` (`emp_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公积金购买情况表';

-- ----------------------------
-- Records of provident_fund_purchase
-- ----------------------------

-- ----------------------------
-- Table structure for `purchase_insurance`
-- ----------------------------
DROP TABLE IF EXISTS `purchase_insurance`;
CREATE TABLE `purchase_insurance` (
  `pur_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `pur_start_time` date NOT NULL COMMENT '购保时间',
  `pur_end_time` date NOT NULL COMMENT '停保时间',
  `pur_computer` varchar(64) DEFAULT NULL COMMENT '个人电脑号',
  `emp_id` int(11) NOT NULL COMMENT '员工外键',
  PRIMARY KEY (`pur_id`),
  KEY `pur_emp_id` (`emp_id`),
  CONSTRAINT `pur_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employee_info` (`emp_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='购保情况表';

-- ----------------------------
-- Records of purchase_insurance
-- ----------------------------

-- ----------------------------
-- Table structure for `receive_training`
-- ----------------------------
DROP TABLE IF EXISTS `receive_training`;
CREATE TABLE `receive_training` (
  `tra_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `tra_subsidy` varchar(255) DEFAULT NULL COMMENT '领过的补助',
  `tra_reward` varchar(255) DEFAULT NULL COMMENT '获得过的奖励',
  `emp_id` int(11) NOT NULL COMMENT '员工外键',
  PRIMARY KEY (`tra_id`),
  KEY `tra_emp_id` (`emp_id`),
  CONSTRAINT `tra_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employee_info` (`emp_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='接受过培训表';

-- ----------------------------
-- Records of receive_training
-- ----------------------------

-- ----------------------------
-- Table structure for `retire_info`
-- ----------------------------
DROP TABLE IF EXISTS `retire_info`;
CREATE TABLE `retire_info` (
  `ret_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `ret_name` varchar(24) NOT NULL COMMENT '姓名',
  `ret_sex` int(4) NOT NULL COMMENT '性别 1为男 2为女',
  `ret_nation` varchar(12) NOT NULL COMMENT '民族',
  `ret_birthday` date NOT NULL COMMENT '生日',
  `ret_id_card` varchar(255) NOT NULL COMMENT '身份证号码',
  `ret_bank_card` varchar(255) NOT NULL COMMENT '银行卡',
  `ret_phone` varchar(32) NOT NULL COMMENT '电话号码',
  `ret_addr` varchar(255) NOT NULL COMMENT '居住地',
  `ret_emer_phone` varchar(32) NOT NULL COMMENT '紧急电话',
  PRIMARY KEY (`ret_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='退休人员信息表';

-- ----------------------------
-- Records of retire_info
-- ----------------------------
