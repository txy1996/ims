/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : ims

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 25/01/2018 18:02:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `device` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `os` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `browser` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 231 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login_log
-- ----------------------------
INSERT INTO `login_log` VALUES (1, 'admin', '2018-01-09 14:44:34', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (2, 'admin', '2018-01-09 15:00:00', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (10, 'hh', '2018-01-09 16:14:21', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (11, 'admin', '2018-01-09 16:15:56', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (12, 'tt', '2018-01-09 16:21:38', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (13, 'admin', '2018-01-09 16:21:59', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (14, 'hh', '2018-01-09 16:22:19', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (15, 'tt', '2018-01-09 16:33:47', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (16, 'admin', '2018-01-09 16:34:45', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (17, 'admin', '2018-01-09 16:40:48', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (18, 'mm', '2018-01-09 16:47:49', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (19, 'admin', '2018-01-09 16:48:35', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (20, 'mm', '2018-01-09 16:48:55', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (21, 'admin', '2018-01-09 16:50:07', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (22, 'mm', '2018-01-09 16:51:15', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (23, 'admin', '2018-01-09 16:57:15', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (24, 'admin', '2018-01-09 17:00:02', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (25, 'admin', '2018-01-09 17:02:56', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (26, 'admin', '2018-01-09 17:03:27', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (27, 'admin', '2018-01-09 17:44:53', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (28, 'mm', '2018-01-09 17:48:58', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (29, 'hh', '2018-01-09 17:49:07', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (30, 'admin', '2018-01-09 17:49:53', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (31, 'admin', '2018-01-09 18:11:09', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (32, 'admin', '2018-01-09 18:11:09', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (33, 'admin', '2018-01-11 16:26:30', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (34, 'admin', '2018-01-11 16:48:57', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (35, 'admin', '2018-01-11 19:18:50', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (36, 'admin', '2018-01-11 19:20:30', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (37, 'admin', '2018-01-11 19:24:53', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (38, 'admin', '2018-01-11 19:31:07', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (39, 'admin', '2018-01-11 20:12:19', '127.0.0.1', '安卓手机', 'Android 6.x', 'Chrome Mobile55.0.2883.87');
INSERT INTO `login_log` VALUES (40, 'admin', '2018-01-12 14:28:14', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (41, 'admin', '2018-01-12 21:26:34', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (42, 'admin', '2018-01-12 22:54:32', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (43, 'admin', '2018-01-12 23:02:03', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (44, 'admin', '2018-01-13 11:21:09', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (45, 'ert11', '2018-01-13 14:20:44', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (46, 'admin', '2018-01-13 19:28:43', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (47, 'admin', '2018-01-13 19:52:28', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (48, 'admin', '2018-01-13 20:03:38', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (49, 'admin', '2018-01-13 21:26:21', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (50, 'admin', '2018-01-13 22:13:30', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (51, 'admin', '2018-01-13 22:16:29', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (52, 'admin', '2018-01-14 11:09:43', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (53, 'admin', '2018-01-14 11:15:39', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (54, 'admin', '2018-01-14 11:17:26', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (55, 'admin', '2018-01-14 11:18:10', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (56, 'admin', '2018-01-15 20:00:41', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (57, 'admin', '2018-01-15 20:29:11', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (58, 'admin', '2018-01-15 20:33:33', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (59, 'admin', '2018-01-16 12:47:51', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (60, 'admin', '2018-01-16 12:51:29', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (61, 'admin', '2018-01-18 15:48:15', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (62, 'admin', '2018-01-18 17:24:48', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (63, 'admin', '2018-01-18 17:45:20', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (64, 'admin', '2018-01-18 18:32:14', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (65, 'admin', '2018-01-18 18:38:45', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (66, 'admin', '2018-01-19 11:22:36', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (67, 'admin', '2018-01-19 12:30:08', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (68, 'admin', '2018-01-19 12:43:25', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (69, 'admin', '2018-01-19 13:34:38', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (70, 'admin', '2018-01-19 13:34:43', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (71, 'admin', '2018-01-19 13:46:17', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (72, 'admin', '2018-01-19 17:50:49', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (73, 'admin', '2018-01-19 17:50:49', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (74, 'admin', '2018-01-19 18:07:04', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (75, 'admin', '2018-01-19 20:14:47', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (76, 'admin', '2018-01-19 20:17:25', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (77, 'admin', '2018-01-19 20:18:15', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (78, 'admin', '2018-01-19 20:22:03', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (79, 'admin', '2018-01-19 21:01:47', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (80, 'admin', '2018-01-19 21:04:36', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (81, 'admin', '2018-01-19 22:06:05', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (82, 'admin', '2018-01-19 22:30:01', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (83, 'admin', '2018-01-19 22:52:22', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (84, 'admin', '2018-01-19 22:52:39', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (85, 'admin', '2018-01-19 22:55:53', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (86, 'admin', '2018-01-19 22:56:30', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (87, 'admin', '2018-01-19 22:58:42', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (88, 'admin', '2018-01-19 22:59:57', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (89, 'admin', '2018-01-19 23:03:33', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (90, 'admin', '2018-01-19 23:12:41', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (91, 'admin', '2018-01-19 23:18:17', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (92, 'admin', '2018-01-19 23:49:03', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (93, 'admin', '2018-01-20 00:25:24', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (94, 'admin', '2018-01-20 01:00:21', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (95, 'admin', '2018-01-20 01:05:16', '192.168.1.106', '安卓手机', 'Android Mobile', 'Chrome Mobile40.0.2214.89');
INSERT INTO `login_log` VALUES (96, 'admin', '2018-01-20 01:06:28', '192.168.1.106', '安卓手机', 'Android Mobile', 'Chrome Mobile40.0.2214.89');
INSERT INTO `login_log` VALUES (97, 'admin', '2018-01-20 01:10:00', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (98, 'admin', '2018-01-20 01:15:09', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (99, 'admin', '2018-01-20 01:17:12', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (100, 'admin', '2018-01-20 01:17:40', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (101, 'admin', '2018-01-20 01:30:18', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (102, 'admin', '2018-01-20 01:52:36', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (103, 'admin', '2018-01-20 01:56:43', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (104, 'admin', '2018-01-20 02:44:01', '192.168.1.104', 'iPhone', 'Mac OS X (iPhone)', 'Mobile Safari11.0');
INSERT INTO `login_log` VALUES (105, 'admin', '2018-01-20 08:58:51', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (106, 'admin', '2018-01-20 12:01:44', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (107, 'admin', '2018-01-20 12:10:07', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (108, 'admin', '2018-01-20 12:30:19', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (109, 'admin', '2018-01-20 12:34:30', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (110, 'admin', '2018-01-20 13:01:15', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (111, 'admin', '2018-01-20 14:22:20', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (112, 'admin', '2018-01-20 14:33:20', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (113, 'admin', '2018-01-20 15:05:59', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (114, 'admin', '2018-01-20 15:19:29', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (115, 'admin', '2018-01-20 15:22:33', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (116, '2121', '2018-01-20 15:24:42', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (117, 'admin', '2018-01-20 15:27:14', '192.168.1.106', '安卓手机', 'Android Mobile', 'Chrome Mobile40.0.2214.89');
INSERT INTO `login_log` VALUES (118, 'admin', '2018-01-20 15:28:02', '192.168.1.106', '安卓手机', 'Android Mobile', 'Chrome Mobile40.0.2214.89');
INSERT INTO `login_log` VALUES (119, 'admin', '2018-01-20 15:51:43', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (120, 'admin', '2018-01-20 16:56:10', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (121, 'admin', '2018-01-20 17:44:41', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (122, 'admin', '2018-01-20 18:01:06', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (123, 'admin', '2018-01-20 19:16:17', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (124, 'admin', '2018-01-20 19:17:06', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (125, 'admin', '2018-01-20 19:24:51', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (126, 'admin', '2018-01-20 19:39:32', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (127, 'admin', '2018-01-20 20:16:05', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (128, 'admin', '2018-01-20 20:25:06', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (135, 'admin', '2018-01-20 22:59:44', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (136, 'admin', '2018-01-20 22:59:44', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (137, 'admin', '2018-01-20 23:05:25', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (138, 'admin', '2018-01-20 23:11:25', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (139, 'admin', '2018-01-21 14:25:53', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (140, 'admin', '2018-01-21 16:12:03', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (141, 'admin', '2018-01-21 17:21:29', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (142, 'admin', '2018-01-21 17:29:30', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (143, 'admin', '2018-01-21 17:33:47', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (144, 'admin', '2018-01-21 17:34:52', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (145, 'admin', '2018-01-21 17:37:29', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (146, 'admin', '2018-01-21 18:19:53', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (147, 'admin', '2018-01-21 18:57:23', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (148, 'admin', '2018-01-21 19:27:38', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (149, 'test', '2018-01-21 19:36:24', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (150, 'test', '2018-01-21 19:44:26', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (151, 'test', '2018-01-21 19:49:42', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (152, 'admin', '2018-01-21 20:44:03', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (153, 'test', '2018-01-21 20:44:27', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (154, 'admin', '2018-01-21 20:46:25', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (155, 'test', '2018-01-21 20:50:41', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (156, 'admin', '2018-01-21 21:26:48', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (157, 'test', '2018-01-21 21:27:12', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (158, 'admin', '2018-01-21 21:39:09', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (159, 'test', '2018-01-21 21:39:23', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (160, 'admin', '2018-01-21 21:40:15', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (161, 'admin', '2018-01-21 21:42:58', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (162, 'test', '2018-01-21 22:42:11', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (163, 'admin', '2018-01-21 22:42:17', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (164, 'test', '2018-01-21 22:42:51', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (165, 'admin', '2018-01-21 22:49:26', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (166, 'test', '2018-01-21 22:49:56', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (167, 'test', '2018-01-21 23:06:04', '192.168.1.104', 'iPhone', 'Mac OS X (iPhone)', 'Mobile Safari11.0');
INSERT INTO `login_log` VALUES (168, 'admin', '2018-01-21 23:19:19', '172.27.35.2', 'iPhone', 'Mac OS X (iPhone)', 'Mobile Safari11.0');
INSERT INTO `login_log` VALUES (169, 'admin', '2018-01-21 23:44:10', '172.27.35.2', 'iPhone', 'Mac OS X (iPhone)', 'Mobile Safari11.0');
INSERT INTO `login_log` VALUES (170, 'admin', '2018-01-21 23:44:55', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (171, 'test', '2018-01-21 23:45:13', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (172, 'admin', '2018-01-21 23:46:31', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (173, 'test', '2018-01-21 23:47:15', '172.27.35.2', 'iPhone', 'Mac OS X (iPhone)', 'Mobile Safari11.0');
INSERT INTO `login_log` VALUES (174, 'admin', '2018-01-21 23:47:42', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (175, 'test', '2018-01-21 23:47:58', '172.27.35.2', 'iPhone', 'Mac OS X (iPhone)', 'Mobile Safari11.0');
INSERT INTO `login_log` VALUES (176, 'test', '2018-01-21 23:48:40', '172.27.35.2', 'iPhone', 'Mac OS X (iPhone)', 'Mobile Safari11.0');
INSERT INTO `login_log` VALUES (177, 'admin', '2018-01-22 00:19:35', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (178, 'admin', '2018-01-22 00:42:41', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (179, 'admin', '2018-01-22 01:02:34', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (180, 'admin', '2018-01-22 01:13:23', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (181, 'admin', '2018-01-22 01:26:20', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (182, 'admin', '2018-01-22 01:30:30', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (183, 'test', '2018-01-22 01:31:03', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (184, 'admin', '2018-01-22 16:08:17', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (185, 'admin', '2018-01-22 16:33:21', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (186, 'admin', '2018-01-22 17:07:36', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (187, 'test', '2018-01-22 17:13:25', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (188, 'admin', '2018-01-22 17:17:15', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (189, 'admin', '2018-01-22 18:08:50', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (190, 'test2', '2018-01-22 18:19:59', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (191, 'admin', '2018-01-22 18:47:36', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (192, 'admin', '2018-01-22 18:49:50', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (193, 'admin', '2018-01-22 18:50:27', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (194, 'admin', '2018-01-22 18:51:13', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (195, 'admin', '2018-01-22 18:51:58', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (196, 'admin', '2018-01-22 18:58:06', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (197, 'admin', '2018-01-22 19:00:20', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (198, 'admin', '2018-01-22 19:01:43', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (199, 'admin', '2018-01-22 19:10:12', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (200, 'admin', '2018-01-22 19:48:07', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (201, 'test', '2018-01-23 13:30:39', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (202, 'admin', '2018-01-23 13:33:26', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (203, 'admin', '2018-01-23 14:10:07', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (204, 'admin', '2018-01-24 12:26:12', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (205, 'test', '2018-01-24 14:50:26', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (206, 'admin', '2018-01-24 15:54:06', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (207, 'admin', '2018-01-24 16:29:43', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (208, 'admin', '2018-01-24 19:39:21', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (209, 'admin', '2018-01-24 20:32:45', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (210, 'admin', '2018-01-24 21:32:11', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (211, 'admin', '2018-01-24 22:04:42', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (212, 'test', '2018-01-24 23:56:14', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (213, 'test', '2018-01-25 00:01:15', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (214, 'admin', '2018-01-25 00:04:49', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (215, 'admin', '2018-01-25 00:06:30', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (216, 'test2', '2018-01-25 00:07:02', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (217, 'test2', '2018-01-25 00:09:18', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (218, 'admin', '2018-01-25 00:13:13', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (219, 'test', '2018-01-25 00:13:37', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (220, 'admin', '2018-01-25 00:18:04', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (221, 'test', '2018-01-25 00:23:20', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (222, 'admin', '2018-01-25 00:24:11', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (223, 'test2', '2018-01-25 00:38:30', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (224, 'admin', '2018-01-25 00:42:25', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (225, 'admin', '2018-01-25 08:55:59', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (226, 'admin', '2018-01-25 09:31:46', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (227, 'admin', '2018-01-25 10:07:50', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (228, 'admin', '2018-01-25 10:56:09', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (229, 'admin', '2018-01-25 11:10:30', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');
INSERT INTO `login_log` VALUES (230, 'admin', '2018-01-25 11:27:53', '127.0.0.1', '电脑', 'Windows 7', 'Chrome55.0.2883.87');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_nav` int(255) NULL DEFAULT NULL,
  `priority` int(255) NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `p_id` bigint(20) NULL DEFAULT NULL,
  `state` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `index_description`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, '用户管理', NULL, 'no', 1, 1, 'fa-users', 0, 1);
INSERT INTO `sys_permission` VALUES (2, '角色管理', NULL, 'no', 1, 2, 'fa-graduation-cap', 0, 1);
INSERT INTO `sys_permission` VALUES (3, '权限管理', '', 'no', 1, 3, 'fa-unlock-alt', 0, 1);
INSERT INTO `sys_permission` VALUES (4, '用户列表', '/user/list', 'user:list', 1, 1, '', 1, 1);
INSERT INTO `sys_permission` VALUES (5, '添加用户', '', 'user:add', 0, NULL, '', 4, 1);
INSERT INTO `sys_permission` VALUES (6, '删除用户', '', 'user:delete', 0, NULL, NULL, 4, 1);
INSERT INTO `sys_permission` VALUES (7, '修改用户', '', 'user:update', 0, NULL, NULL, 4, 1);
INSERT INTO `sys_permission` VALUES (8, '查看用户', NULL, 'user:show', 0, NULL, NULL, 4, 1);
INSERT INTO `sys_permission` VALUES (9, '重置用户密码', NULL, 'user:reset', 0, NULL, NULL, 4, 1);
INSERT INTO `sys_permission` VALUES (10, '角色列表', '/role/list', 'role:list', 1, 1, '', 2, 1);
INSERT INTO `sys_permission` VALUES (11, '添加角色', '', 'role:add', 0, NULL, NULL, 10, 1);
INSERT INTO `sys_permission` VALUES (12, '删除角色', '', 'role:delete', 0, NULL, NULL, 10, 1);
INSERT INTO `sys_permission` VALUES (13, '修改角色', '', 'role:update', 0, NULL, NULL, 10, 1);
INSERT INTO `sys_permission` VALUES (14, '查看角色', '', 'role:show', 0, NULL, NULL, 10, 1);
INSERT INTO `sys_permission` VALUES (15, '权限列表', '/perm/list', 'perm:list', 1, 1, '', 3, 1);
INSERT INTO `sys_permission` VALUES (16, '添加权限', '', 'perm:add', 0, NULL, NULL, 15, 1);
INSERT INTO `sys_permission` VALUES (17, '删除权限', '', 'perm:delete', 0, NULL, NULL, 15, 1);
INSERT INTO `sys_permission` VALUES (18, '更新权限', '', 'perm:update', 0, NULL, NULL, 15, 1);
INSERT INTO `sys_permission` VALUES (19, '查看权限', NULL, 'perm:show', 0, NULL, NULL, 15, 1);
INSERT INTO `sys_permission` VALUES (20, '用户登录日志', '/loginLog/list', 'loginLog:list', 1, 2, NULL, 1, 1);
INSERT INTO `sys_permission` VALUES (21, '删除登录日志', NULL, 'loginLog:delete', 0, NULL, NULL, 20, 1);
INSERT INTO `sys_permission` VALUES (22, '查看登录日志', NULL, 'loginLog:show', 0, NULL, NULL, 20, 1);
INSERT INTO `sys_permission` VALUES (31, '用户信息', '/module-maintenance', 'userinfo:show', 1, 3, NULL, 1, 1);
INSERT INTO `sys_permission` VALUES (32, '系统管理', NULL, 'no', 1, NULL, NULL, 0, 1);
INSERT INTO `sys_permission` VALUES (33, '性能监控', '/druid/index.html', 'druid:show', 1, NULL, NULL, 32, 1);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', '拥有系统的最高权限', 'superAdmin');
INSERT INTO `sys_role` VALUES (2, '管理员', '拥有系统管理权限', 'admin');
INSERT INTO `sys_role` VALUES (3, '总经理', '拥有企业管理权限', 'generalManager');
INSERT INTO `sys_role` VALUES (4, '副总经理', '拥有职工管理权限', 'deputyGeneralManager');
INSERT INTO `sys_role` VALUES (5, '部门主管', '拥有本部门管理权限', 'departmentHeads');
INSERT INTO `sys_role` VALUES (6, '项目经理', '拥有项目管理权限', 'projectManager');
INSERT INTO `sys_role` VALUES (7, '普通职员', '拥有查看/记录信息权限', 'staff');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `role_id` bigint(20) NULL DEFAULT NULL,
  `permission_id` bigint(20) NULL DEFAULT NULL,
  INDEX `FK_Reference_3`(`role_id`) USING BTREE,
  INDEX `FK_Reference_4`(`permission_id`) USING BTREE,
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (2, 1);
INSERT INTO `sys_role_permission` VALUES (2, 4);
INSERT INTO `sys_role_permission` VALUES (2, 5);
INSERT INTO `sys_role_permission` VALUES (2, 6);
INSERT INTO `sys_role_permission` VALUES (2, 7);
INSERT INTO `sys_role_permission` VALUES (2, 8);
INSERT INTO `sys_role_permission` VALUES (2, 9);
INSERT INTO `sys_role_permission` VALUES (2, 20);
INSERT INTO `sys_role_permission` VALUES (2, 21);
INSERT INTO `sys_role_permission` VALUES (2, 22);
INSERT INTO `sys_role_permission` VALUES (2, 31);
INSERT INTO `sys_role_permission` VALUES (2, 2);
INSERT INTO `sys_role_permission` VALUES (2, 10);
INSERT INTO `sys_role_permission` VALUES (2, 11);
INSERT INTO `sys_role_permission` VALUES (2, 12);
INSERT INTO `sys_role_permission` VALUES (2, 13);
INSERT INTO `sys_role_permission` VALUES (2, 14);
INSERT INTO `sys_role_permission` VALUES (2, 3);
INSERT INTO `sys_role_permission` VALUES (2, 15);
INSERT INTO `sys_role_permission` VALUES (2, 16);
INSERT INTO `sys_role_permission` VALUES (2, 17);
INSERT INTO `sys_role_permission` VALUES (2, 18);
INSERT INTO `sys_role_permission` VALUES (2, 19);
INSERT INTO `sys_role_permission` VALUES (6, 1);
INSERT INTO `sys_role_permission` VALUES (6, 4);
INSERT INTO `sys_role_permission` VALUES (6, 7);
INSERT INTO `sys_role_permission` VALUES (6, 8);
INSERT INTO `sys_role_permission` VALUES (6, 2);
INSERT INTO `sys_role_permission` VALUES (6, 10);
INSERT INTO `sys_role_permission` VALUES (6, 13);
INSERT INTO `sys_role_permission` VALUES (6, 14);
INSERT INTO `sys_role_permission` VALUES (6, 3);
INSERT INTO `sys_role_permission` VALUES (6, 15);
INSERT INTO `sys_role_permission` VALUES (6, 18);
INSERT INTO `sys_role_permission` VALUES (6, 19);
INSERT INTO `sys_role_permission` VALUES (7, 1);
INSERT INTO `sys_role_permission` VALUES (7, 4);
INSERT INTO `sys_role_permission` VALUES (7, 8);
INSERT INTO `sys_role_permission` VALUES (7, 2);
INSERT INTO `sys_role_permission` VALUES (7, 10);
INSERT INTO `sys_role_permission` VALUES (7, 14);
INSERT INTO `sys_role_permission` VALUES (7, 3);
INSERT INTO `sys_role_permission` VALUES (7, 15);
INSERT INTO `sys_role_permission` VALUES (7, 19);
INSERT INTO `sys_role_permission` VALUES (5, 1);
INSERT INTO `sys_role_permission` VALUES (5, 4);
INSERT INTO `sys_role_permission` VALUES (5, 5);
INSERT INTO `sys_role_permission` VALUES (5, 6);
INSERT INTO `sys_role_permission` VALUES (5, 7);
INSERT INTO `sys_role_permission` VALUES (5, 8);
INSERT INTO `sys_role_permission` VALUES (5, 2);
INSERT INTO `sys_role_permission` VALUES (5, 10);
INSERT INTO `sys_role_permission` VALUES (5, 11);
INSERT INTO `sys_role_permission` VALUES (5, 12);
INSERT INTO `sys_role_permission` VALUES (5, 13);
INSERT INTO `sys_role_permission` VALUES (5, 14);
INSERT INTO `sys_role_permission` VALUES (5, 3);
INSERT INTO `sys_role_permission` VALUES (5, 15);
INSERT INTO `sys_role_permission` VALUES (5, 16);
INSERT INTO `sys_role_permission` VALUES (5, 17);
INSERT INTO `sys_role_permission` VALUES (5, 18);
INSERT INTO `sys_role_permission` VALUES (5, 19);
INSERT INTO `sys_role_permission` VALUES (4, 1);
INSERT INTO `sys_role_permission` VALUES (4, 4);
INSERT INTO `sys_role_permission` VALUES (4, 5);
INSERT INTO `sys_role_permission` VALUES (4, 6);
INSERT INTO `sys_role_permission` VALUES (4, 7);
INSERT INTO `sys_role_permission` VALUES (4, 8);
INSERT INTO `sys_role_permission` VALUES (4, 31);
INSERT INTO `sys_role_permission` VALUES (4, 2);
INSERT INTO `sys_role_permission` VALUES (4, 10);
INSERT INTO `sys_role_permission` VALUES (4, 11);
INSERT INTO `sys_role_permission` VALUES (4, 12);
INSERT INTO `sys_role_permission` VALUES (4, 13);
INSERT INTO `sys_role_permission` VALUES (4, 14);
INSERT INTO `sys_role_permission` VALUES (4, 3);
INSERT INTO `sys_role_permission` VALUES (4, 15);
INSERT INTO `sys_role_permission` VALUES (4, 16);
INSERT INTO `sys_role_permission` VALUES (4, 17);
INSERT INTO `sys_role_permission` VALUES (4, 18);
INSERT INTO `sys_role_permission` VALUES (4, 19);
INSERT INTO `sys_role_permission` VALUES (3, 1);
INSERT INTO `sys_role_permission` VALUES (3, 4);
INSERT INTO `sys_role_permission` VALUES (3, 5);
INSERT INTO `sys_role_permission` VALUES (3, 6);
INSERT INTO `sys_role_permission` VALUES (3, 7);
INSERT INTO `sys_role_permission` VALUES (3, 8);
INSERT INTO `sys_role_permission` VALUES (3, 31);
INSERT INTO `sys_role_permission` VALUES (3, 2);
INSERT INTO `sys_role_permission` VALUES (3, 10);
INSERT INTO `sys_role_permission` VALUES (3, 11);
INSERT INTO `sys_role_permission` VALUES (3, 12);
INSERT INTO `sys_role_permission` VALUES (3, 13);
INSERT INTO `sys_role_permission` VALUES (3, 14);
INSERT INTO `sys_role_permission` VALUES (3, 3);
INSERT INTO `sys_role_permission` VALUES (3, 15);
INSERT INTO `sys_role_permission` VALUES (3, 16);
INSERT INTO `sys_role_permission` VALUES (3, 17);
INSERT INTO `sys_role_permission` VALUES (3, 18);
INSERT INTO `sys_role_permission` VALUES (3, 19);
INSERT INTO `sys_role_permission` VALUES (1, 1);
INSERT INTO `sys_role_permission` VALUES (1, 4);
INSERT INTO `sys_role_permission` VALUES (1, 5);
INSERT INTO `sys_role_permission` VALUES (1, 6);
INSERT INTO `sys_role_permission` VALUES (1, 7);
INSERT INTO `sys_role_permission` VALUES (1, 8);
INSERT INTO `sys_role_permission` VALUES (1, 9);
INSERT INTO `sys_role_permission` VALUES (1, 20);
INSERT INTO `sys_role_permission` VALUES (1, 21);
INSERT INTO `sys_role_permission` VALUES (1, 22);
INSERT INTO `sys_role_permission` VALUES (1, 31);
INSERT INTO `sys_role_permission` VALUES (1, 2);
INSERT INTO `sys_role_permission` VALUES (1, 10);
INSERT INTO `sys_role_permission` VALUES (1, 11);
INSERT INTO `sys_role_permission` VALUES (1, 12);
INSERT INTO `sys_role_permission` VALUES (1, 13);
INSERT INTO `sys_role_permission` VALUES (1, 14);
INSERT INTO `sys_role_permission` VALUES (1, 3);
INSERT INTO `sys_role_permission` VALUES (1, 15);
INSERT INTO `sys_role_permission` VALUES (1, 16);
INSERT INTO `sys_role_permission` VALUES (1, 17);
INSERT INTO `sys_role_permission` VALUES (1, 18);
INSERT INTO `sys_role_permission` VALUES (1, 19);
INSERT INTO `sys_role_permission` VALUES (1, 32);
INSERT INTO `sys_role_permission` VALUES (1, 33);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `salt` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '盐',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  `state` int(1) NOT NULL COMMENT '帐号状态，0:未激活1:正常2:锁定',
  `real_name` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `gender` int(4) NULL DEFAULT NULL COMMENT '性别',
  `nation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '民族',
  `birth` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出生日期',
  `education` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住址',
  `mobile` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `email` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门',
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '/assets/images/avatars/profile-pic.jpg' COMMENT '头像',
  `activate_time` datetime(0) NULL DEFAULT NULL COMMENT '激活时间',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮件激活码',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `index_username`(`username`) USING BTREE COMMENT '用户名唯一',
  UNIQUE INDEX `index_email`(`email`) USING BTREE COMMENT '邮箱唯一',
  UNIQUE INDEX `index_mobile`(`mobile`) USING BTREE COMMENT '手机号唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '1637fcf8b38df9216beeab1ee78cabb8', '84012b1f7ab582eb1a0eb46ed08fb5a9', '2017-12-26 23:00:36', 1, '叮咚', 1, '汉族', '2017-12-01', '硕士', '北京市 朝阳区', '18888888888', 'qwe@pydyun.com', '董事会', '副总经理', '无', '/assets/images/avatars/male.jpg', NULL, NULL);
INSERT INTO `sys_user` VALUES (2, 'test', '361b382ebec4e25c01bc9e8ffd25014e', '76f7df5fd5855b13066c2d980e970c64', '2018-01-09 16:42:41', 1, '测试', 0, NULL, NULL, NULL, NULL, NULL, 'qwe@pydy1un.com', NULL, NULL, NULL, '/assets/images/avatars/profile-pic.jpg', '2018-01-02 13:30:04', '444');
INSERT INTO `sys_user` VALUES (3, 'test2', 'ce3b747fcbfaeecb6e1e072b23aac8cf', 'de670d716705726419042805b7066757', '2018-01-22 18:19:43', 2, '测试2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/assets/images/avatars/profile-pic.jpg', NULL, NULL);
INSERT INTO `sys_user` VALUES (4, 'qwe444', '68a0657e1341e3fa2baa6b09448a80a8', '89c8b69a61bfcf1e3dd16f9927164ca9', '2018-01-23 18:13:31', 0, 'qqq', NULL, NULL, NULL, NULL, NULL, NULL, '111@114441.com', NULL, NULL, NULL, '/assets/images/avatars/profile-pic.jpg', '2018-01-24 18:13:31', NULL);
INSERT INTO `sys_user` VALUES (5, 'poi', '329b373d4776937b0aef153abedc9246', 'ce280e949787c2cfdcacd70ee6009189', '2018-01-23 18:47:32', 1, '', NULL, NULL, NULL, NULL, NULL, NULL, '6666@1111.com', NULL, NULL, NULL, '/assets/images/avatars/profile-pic.jpg', '2018-01-24 18:47:32', 'c3e0502afbbd4aea8ef65a5ffd58c6abcb5e47220ca04e4ca0a6317c36eff8fc');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint(20) NULL DEFAULT NULL,
  `role_id` bigint(20) NULL DEFAULT NULL,
  INDEX `FK_Reference_1`(`user_id`) USING BTREE,
  INDEX `FK_Reference_2`(`role_id`) USING BTREE,
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2);
INSERT INTO `sys_user_role` VALUES (3, 7);

SET FOREIGN_KEY_CHECKS = 1;
