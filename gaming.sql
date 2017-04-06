/*
Navicat MySQL Data Transfer

Source Server         : mysql.root
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : gaming

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2017-04-06 21:26:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `userID` int(11) DEFAULT NULL,
  `matchID` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `content` varchar(256) DEFAULT NULL,
  KEY `FK_Relationship_6` (`userID`),
  KEY `FK_Relationship_7` (`matchID`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`matchID`) REFERENCES `gamematch` (`matchID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for gamematch
-- ----------------------------
DROP TABLE IF EXISTS `gamematch`;
CREATE TABLE `gamematch` (
  `matchIMG` varchar(256) DEFAULT NULL,
  `matchName` varchar(256) DEFAULT NULL,
  `deadline` datetime DEFAULT NULL,
  `teamNum` int(11) DEFAULT NULL,
  `personNum` int(11) DEFAULT NULL,
  `ruleID` int(11) DEFAULT NULL,
  `area` varchar(256) DEFAULT NULL,
  `award` int(11) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `matchID` int(11) NOT NULL,
  PRIMARY KEY (`matchID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for regist_multi
-- ----------------------------
DROP TABLE IF EXISTS `regist_multi`;
CREATE TABLE `regist_multi` (
  `userID` int(11) DEFAULT NULL,
  `matchID` int(11) DEFAULT NULL,
  `groupID` int(11) NOT NULL,
  PRIMARY KEY (`groupID`),
  KEY `FK_Relationship_3` (`userID`),
  KEY `FK_Relationship_4` (`matchID`),
  CONSTRAINT `FK_Relationship_3` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`matchID`) REFERENCES `gamematch` (`matchID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for regist_multi_member
-- ----------------------------
DROP TABLE IF EXISTS `regist_multi_member`;
CREATE TABLE `regist_multi_member` (
  `groupID` int(11) DEFAULT NULL,
  KEY `FK_Relationship_5` (`groupID`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`groupID`) REFERENCES `regist_multi` (`groupID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for regist_solo
-- ----------------------------
DROP TABLE IF EXISTS `regist_solo`;
CREATE TABLE `regist_solo` (
  `userID` int(11) DEFAULT NULL,
  `matchID` int(11) DEFAULT NULL,
  `gameID` varchar(256) DEFAULT NULL,
  KEY `FK_Relationship_1` (`userID`),
  KEY `FK_Relationship_2` (`matchID`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`),
  CONSTRAINT `FK_Relationship_2` FOREIGN KEY (`matchID`) REFERENCES `gamematch` (`matchID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userIMG` varchar(256) DEFAULT NULL,
  `userName` varchar(256) DEFAULT NULL,
  `userID` int(11) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
