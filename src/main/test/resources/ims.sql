SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `url` varchar(30) DEFAULT NULL,
  `isNav` tinyint(4) DEFAULT '0',
  `code` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '用户列表', '/user/list', '1', 'user:list');
INSERT INTO `sys_permission` VALUES ('2', '添加新用户', '', '0', 'user:add');
INSERT INTO `sys_permission` VALUES ('3', '删除用户', '', '0', 'user:delete');
INSERT INTO `sys_permission` VALUES ('4', '查看用户角色', '', '0', 'user:showroles');
INSERT INTO `sys_permission` VALUES ('5', '添加用户角色关联', '', '0', 'user:corelationrole');
INSERT INTO `sys_permission` VALUES ('6', '角色列表', '/role/list', '1', 'role:list');
INSERT INTO `sys_permission` VALUES ('7', '添加新角色', '', '0', 'role:add');
INSERT INTO `sys_permission` VALUES ('8', '删除角色', '', '0', 'role:delete');
INSERT INTO `sys_permission` VALUES ('9', '查看角色信息', '', '0', 'role:findinfo');
INSERT INTO `sys_permission` VALUES ('10', '添加角色权限关联', '', '0', 'role:corelationperm');
INSERT INTO `sys_permission` VALUES ('11', '查看角色权限', '', '0', 'role:showperms');
INSERT INTO `sys_permission` VALUES ('12', '权限列表', '/perm/list', '1', 'perm:list');
INSERT INTO `sys_permission` VALUES ('13', '添加新权限', '', '0', 'perm:add');
INSERT INTO `sys_permission` VALUES ('14', '删除权限', '', '0', 'perm:delete');
INSERT INTO `sys_permission` VALUES ('15', '更新权限信息', '', '0', 'perm:update');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL,
  `description` varchar(30) DEFAULT NULL,
  `code` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '用户管理员', '用户管理', 'userAdmin');
INSERT INTO `sys_role` VALUES ('2', '类目管理员', '类目管理', 'classAdmin');
INSERT INTO `sys_role` VALUES ('3', '商品管理员', '商品管理', 'commodityAdmin');
INSERT INTO `sys_role` VALUES ('4', '评论管理员', '评论管理', 'commentAdmin');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleId` bigint(20) DEFAULT NULL,
  `permissionId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_3` (`roleId`),
  KEY `FK_Reference_4` (`permissionId`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`permissionId`) REFERENCES `sys_permission` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '8', '1');
INSERT INTO `sys_role_permission` VALUES ('2', '8', '2');
INSERT INTO `sys_role_permission` VALUES ('3', '8', '3');
INSERT INTO `sys_role_permission` VALUES ('4', '8', '4');
INSERT INTO `sys_role_permission` VALUES ('5', '8', '5');
INSERT INTO `sys_role_permission` VALUES ('6', '8', '6');
INSERT INTO `sys_role_permission` VALUES ('7', '8', '7');
INSERT INTO `sys_role_permission` VALUES ('8', '8', '8');
INSERT INTO `sys_role_permission` VALUES ('9', '8', '9');
INSERT INTO `sys_role_permission` VALUES ('10', '8', '10');
INSERT INTO `sys_role_permission` VALUES ('11', '8', '11');
INSERT INTO `sys_role_permission` VALUES ('12', '8', '12');
INSERT INTO `sys_role_permission` VALUES ('13', '8', '13');
INSERT INTO `sys_role_permission` VALUES ('14', '8', '14');
INSERT INTO `sys_role_permission` VALUES ('15', '8', '15');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(15) DEFAULT NULL,
  `password` char(32) DEFAULT NULL,
  `salt` char(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '1637fcf8b38df9216beeab1ee78cabb8', '84012b1f7ab582eb1a0eb46ed08fb5a9');
INSERT INTO `sys_user` VALUES ('2', 'lailai', '0e04ce8cf9e1dfa071940aac54fb7d87', '4eb75ed8d81b48a0e6e612694ee91582');
INSERT INTO `sys_user` VALUES ('3', 'mingming', 'e1ad6a808a8bddbd858c98befc16b763', '90ccceaeff871d1c764f51574961b244');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `roleId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_1` (`userId`),
  KEY `FK_Reference_2` (`roleId`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`userId`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '8');
INSERT INTO `sys_user_role` VALUES ('2', '1', '9');
INSERT INTO `sys_user_role` VALUES ('3', '1', '10');
INSERT INTO `sys_user_role` VALUES ('4', '1', '11');